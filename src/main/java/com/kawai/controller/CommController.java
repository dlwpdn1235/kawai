package com.kawai.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.CommDtoCategory;
import com.kawai.dto.CommDtoComment;
import com.kawai.dto.CommDtoCommentLike;
import com.kawai.dto.CommDtoCommunityLike;
import com.kawai.dto.CommDtoSearch;
import com.kawai.service.CommService;
import com.kawai.service.CommServiceCategory;
import com.kawai.service.CommServiceComment;
import com.kawai.service.CommServiceCommentLike;
import com.kawai.service.CommServiceLike;

@RequestMapping("/community/*")
@Controller
public class CommController {
	
	@Autowired  
	CommService commService;
	@Autowired  
	CommServiceLike commServiceLike;
	@Autowired  
	CommServiceComment commServiceComment;
	@Autowired  
	CommServiceCommentLike commServiceCommentLike;
	@Autowired
	CommServiceCategory commServiceCategory;

	@RequestMapping(value = "commAdminPage", method = RequestMethod.GET)
	public String commAdminPage() {	
		return "community/commAdminPage";
	}
	@RequestMapping(value = "commView", method = RequestMethod.GET)
	public String commView() {	
		return "community/commView";
	}
	@RequestMapping(value = "commAjaxView", method = RequestMethod.POST, headers= {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> commAjaxView(@RequestBody CommDtoSearch search) {	
		Map<String, Object> result = new HashMap<>();
		List<CommDto> commList = commService.commCommunityAllRead(search);
		List<CommDtoCategory> comm_category = commServiceCategory.commCategoryList();
		for(CommDto cL : commList) {
			for(CommDtoCategory cC : comm_category) {
				if(cL.getComm_category_id() == cC.getCategory_id()) {
					cL.setCategory_name(cC.getCategory_name());
					break;
				}
			}
		}
		result.put("result", Boolean.TRUE);
		result.put("commList",commList);
		result.put("comm_category",comm_category);
		return result;
	}
	@RequestMapping(value = "commAjaxAdminView", method = RequestMethod.POST, headers= {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> commAjaxAdminView(@RequestBody CommDtoSearch search) {	
		Map<String, Object> result = new HashMap<>();
		List<CommDto> commList = commService.commAdminCommunityAllRead(search);
		List<CommDtoCategory> comm_category = commServiceCategory.commCategoryList();
		for(CommDto cL : commList) {
			System.out.println(cL.getCommunity_hide());
			for(CommDtoCategory cC : comm_category) {
				if(cL.getComm_category_id() == cC.getCategory_id()) {
					cL.setCategory_name(cC.getCategory_name());
					break;
				}
			}
		}
		result.put("result", Boolean.TRUE);
		result.put("commList",commList);
		result.put("comm_category",comm_category);
		return result;
	}
	@RequestMapping(value = "commAjaxAdminHide/{community_id}/{community_hide}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commAjaxAdminHide(@PathVariable int community_id, @PathVariable int community_hide) {	
		Map<String, Object> result = new HashMap<>();
		commService.commCommunityDelete(community_id, community_hide);
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="commBookinfo/{bookinfo_title}/{start_page}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commBookinfo(@PathVariable String bookinfo_title, @PathVariable int start_page) {
	    Map<String, Object> result = new HashMap<>();
	    // 네이버 검색 API 요청
	    String clientId = "GMWaPzp1mjiUos2cjXwP";
	    String clientSecret = "q5o1HLTNRU";
	    System.out.println(start_page);
	    // URI 생성
	    URI uri = UriComponentsBuilder
	            .fromUriString("https://openapi.naver.com")
	            .path("/v1/search/book.json")
	            .queryParam("query", bookinfo_title)
	            .queryParam("display", 10)
	            .queryParam("start", start_page)
	            .queryParam("sort", "sim")
	            .build()
	            .encode()
	            .toUri();

	    // HTTP 요청 헤더 설정
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-Naver-Client-Id", clientId);
	    headers.set("X-Naver-Client-Secret", clientSecret);
	    HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

	    // HTTP GET 요청 보내기
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Map<String, Object>>() {});

	    // API 응답 처리
	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
	        Map<String, Object> responseBody = responseEntity.getBody();
	        result.put("result", Boolean.TRUE);
	        result.put("bookinfoList", responseBody);
	    } else {	
	        result.put("result", Boolean.FALSE);
	        result.put("bookinfoList", null);
	    }

	    return result;
	}
	@RequestMapping(value = "commDetail", method = RequestMethod.GET)
	public String commDetail(int community_id, Model model, HttpServletRequest request) {	
		model.addAttribute("commRead",commService.commCommunityHitRead(community_id,(String)request.getSession().getAttribute("account")));
		return "community/commDetail";
	}
	@RequestMapping(value = "commUpdateDetail", method = RequestMethod.GET)
	public String commUpdateDetail(int community_id, Model model, HttpServletRequest request) {	
		model.addAttribute("commRead",commService.commCommunityRead(community_id, (String)request.getSession().getAttribute("account")));
		return "community/commDetail";
	}
	@RequestMapping(value = "commInsert", method = RequestMethod.GET)
	public String commInsert() {	
		return "community/commInsert";
	}
	@RequestMapping(value = "commAdminInsert", method = RequestMethod.GET)
	public String commAdminInsert() {	
		return "community/commAdminInsert";
	}
	@RequestMapping(value = "commInsert", method = RequestMethod.POST)
	public String commInsertAction(CommDto commdto, CommDtoBookinfo bookinfo, RedirectAttributes rttr , HttpServletRequest request) {	
		String result = "fail";
		if(bookinfo.getBook_title() == null && bookinfo.getBook_author()==null) {
			bookinfo = new CommDtoBookinfo();
			bookinfo.setBook_title("기본");
			bookinfo.setBook_description("기본");
			bookinfo.setBook_author("기본");
			bookinfo.setBook_publisher("없음");
			bookinfo.setBook_image("없음");
			bookinfo.setBook_pubdate("2023-07-05 10:38:12");
		}
		commdto.setCommunity_hide(1);
		
		commdto.setUser_id((String)request.getSession().getAttribute("account"));
		commdto.setBookinfo(bookinfo);
		if(commService.commCommunityInsert(commdto)>0) {result="글쓰기 완료";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/community/commView";
	}
	@RequestMapping(value = "commAdminInsert", method = RequestMethod.POST)
	public String commAdminInsert(CommDto commdto, CommDtoBookinfo bookinfo, RedirectAttributes rttr, HttpServletRequest request) {	
		String result = "fail";
		if(bookinfo.getBook_title() == null && bookinfo.getBook_author()==null) {
			bookinfo = new CommDtoBookinfo();
			bookinfo.setBook_title("기본");
			bookinfo.setBook_description("기본");
			bookinfo.setBook_author("없음");
			bookinfo.setBook_publisher("없음");
			bookinfo.setBook_image("없음");
			bookinfo.setBook_pubdate("2023-07-05 10:38:12");
		}
		commdto.setCommunity_hide(1);
		commdto.setUser_id((String)request.getSession().getAttribute("account"));
		commdto.setBookinfo(bookinfo);
		if(commService.commCommunityInsert(commdto)>0) {result="글쓰기 완료";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/community/commAdminPage";
	}
	@RequestMapping(value="commUpdate", method=RequestMethod.GET)
	public String commUpdate(int community_id, Model model,  HttpServletRequest request) {
		model.addAttribute("commRead",commService.commCommunityRead(community_id, (String)request.getSession().getAttribute("account")));
		return "community/commUpdateForm";
	}
	@RequestMapping(value="commUpdate", method=RequestMethod.POST)
	public String commUpdate(CommDto commdto, CommDtoBookinfo bookinfo, RedirectAttributes rttr) {
		String result = "fail";
		commdto.setBookinfo(bookinfo);
		if(commService.commCommunityUpdate(commdto)>0) {result = "글 수정 완료";}
		rttr.addFlashAttribute("success", result);
		return "redirect:/community/commUpdateDetail?community_id=" + commdto.getCommunity_id();
	}
	@RequestMapping(value="commDelete", method=RequestMethod.GET)
	public String commDelete(int community_id, RedirectAttributes rttr) {
		String result = "fail";
		if(commService.commCommunityDelete(community_id,0)>0) {result="글삭제 완료";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/community/commView";
	}
	@RequestMapping(value = "commLike", method = RequestMethod.POST , headers = {"Content-Type=application/json"})
	@ResponseBody
	public Map<String, Object> commLike(@RequestBody CommDtoCommunityLike dtoLike) {
	    Map<String, Object> result = new HashMap<>();
	    System.out.println(dtoLike);
	    dtoLike.setCheckLike(dtoLike.getIsLike().equals("0")? true:false);
	    if (dtoLike.isCheckLike()) {
	        commServiceLike.communityLikeDelete(dtoLike);
	        result.put("commCheckLike", Boolean.FALSE);
	    } else {
	        commServiceLike.communityLikeInsert(dtoLike);
	        result.put("commCheckLike", Boolean.TRUE);
	    }
	    result.put("commLikeCnt", commServiceLike.communityLikeCnt(dtoLike.getCommunity_id()));
	    result.put("result", Boolean.TRUE);
	    return result;
	}
	@RequestMapping(value="commentLike", method=RequestMethod.POST ,  headers = {"Content-Type=application/json"})
	@ResponseBody
	public Map<String, Object> commentLike(@RequestBody CommDtoCommentLike like) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(like);
		like.setCheckLike(like.getIsLike().equals("0")? true:false);
		if(like.isCheckLike()) {
			commServiceCommentLike.commentLikeDelete(like);			
			result.put("commentCheckLike",Boolean.FALSE);			
		}else {
			commServiceCommentLike.commentLikeInsert(like);
			result.put("commentCheckLike",Boolean.TRUE);			
		}
	    result.put("commentLikeCnt", commServiceCommentLike.commentLikeCnt(like.getComment_id()));
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value="commentAllRead/{community_id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentAllRead(@PathVariable int community_id, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		List<CommDtoComment> comments = commServiceComment.commCommentAllRead(community_id,(String)request.getSession().getAttribute("account"));
		result.put("result", Boolean.TRUE);
		result.put("comment", comments);
		return result;
	}
	@RequestMapping(value="commentInsert", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commentInsert(@RequestBody CommDtoComment comment, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		commServiceComment.commentInsert(comment,request);
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="commreply", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commreply(@RequestBody CommDtoComment comment, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(comment);
		commServiceComment.commentInsert(comment,request);
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="commentUpdate", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commentUpdate(@RequestBody CommDtoComment comment) {
		Map<String, Object> result = new HashMap<>();
		commServiceComment.commentUpdate(comment);
		
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="commentDelete", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentDelete(@RequestBody CommDtoComment comment) {
		Map<String, Object> result = new HashMap<>();
		commServiceComment.commentDelete(comment);
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="communityMyPage", method=RequestMethod.GET)
	public String communityMyPage(Model model, HttpServletRequest request) {
		List<CommDto> commList = commService.commUserAllRead((String)request.getSession().getAttribute("account"), 0);
		List<CommDtoCategory> comm_category = commServiceCategory.commCategoryList();
		for(CommDto cL : commList) {
			for(CommDtoCategory cC : comm_category) {
				if(cL.getComm_category_id() == cC.getCategory_id()) {
					cL.setCategory_name(cC.getCategory_name());
					break;
				}
			}
		}
		model.addAttribute("commList",commList);
		return "community/commMyPage";
	}
	@RequestMapping(value="communityMyPageAdd/{plusPage}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> communityMyPageAdd(@PathVariable int plusPage, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(plusPage);
		List<CommDto> commList = commService.commUserAllRead((String)request.getSession().getAttribute("account"), plusPage);
		List<CommDtoCategory> comm_category = commServiceCategory.commCategoryList();
		for(CommDto cL : commList) {
			for(CommDtoCategory cC : comm_category) {
				if(cL.getComm_category_id() == cC.getCategory_id()) {
					cL.setCategory_name(cC.getCategory_name());
					break;
				}
			}
		}
		result.put("commList",commList);
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="communityLikeMyPageAdd/{plusPage}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> communityLikeMyPageAdd(@PathVariable int plusPage, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		List<CommDto> commList = commServiceLike.communityLikeAllRead((String)request.getSession().getAttribute("account"), plusPage);
		List<CommDtoCategory> comm_category = commServiceCategory.commCategoryList();
		for(CommDto cL : commList) {
			for(CommDtoCategory cC : comm_category) {
				if(cL.getComm_category_id() == cC.getCategory_id()) {
					cL.setCategory_name(cC.getCategory_name());
					break;
				}
			}
		}
		result.put("commList",commList);
		result.put("result", Boolean.TRUE);
		return result;
	}
	
}
