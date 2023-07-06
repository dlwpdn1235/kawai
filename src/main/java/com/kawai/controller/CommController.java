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
	@RequestMapping(value="commBookinfo/{bookinfo_title}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commBookinfo(@PathVariable String bookinfo_title) {
	    Map<String, Object> result = new HashMap<>();
	    // 네이버 검색 API 요청
	    String clientId = "GMWaPzp1mjiUos2cjXwP";
	    String clientSecret = "q5o1HLTNRU";

	    // URI 생성
	    URI uri = UriComponentsBuilder
	            .fromUriString("https://openapi.naver.com")
	            .path("/v1/search/book.json")
	            .queryParam("query", bookinfo_title)
	            .queryParam("display", 10)
	            .queryParam("start", 1)
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
	        System.out.println(responseBody);
	    } else {	
	        result.put("result", Boolean.FALSE);
	        result.put("bookinfoList", null);
	    }

	    return result;
	}
	@RequestMapping(value = "commDetail", method = RequestMethod.GET)
	public String commDetail(int community_id, Model model) {	
		model.addAttribute("commRead",commService.commCommunityHitRead(community_id));
		return "community/commDetail";
	}
	@RequestMapping(value = "commInsert", method = RequestMethod.GET)
	public String commInsert() {	
		return "community/commInsert";
	}
	@RequestMapping(value = "commInsert", method = RequestMethod.POST)
	public String commInsertAction(CommDto commdto, CommDtoBookinfo bookinfo, RedirectAttributes rttr) {	
		String result = "fail";
		System.out.println(commdto);
		System.out.println(bookinfo);
		commdto.setCommunity_hide(1);
		commdto.setComm_category_id(2);
		commdto.setUser_id("user001");
		commdto.setBookinfo(bookinfo);
		if(commService.commCommunityInsert(commdto)>0) {result="글쓰기 완료";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/community/commView";
	}
	@RequestMapping(value="commUpdate", method=RequestMethod.GET)
	public String commUpdate(int community_id, Model model) {
		model.addAttribute("commRead",commService.commCommunityRead(community_id));
		return "community/commUpdateForm";
	}
	@RequestMapping(value="commUpdate", method=RequestMethod.POST)
	public String commUpdate(CommDto commdto, Model model, RedirectAttributes rttr) {
		String result = "fail";
		if(commService.commCommunityUpdate(commdto)>0) {result = "글 수정 완료";}
		rttr.addFlashAttribute("success", result);
		return "redirect:/community/commDetail?community_id=" + commdto.getCommunity_id();
	}
	@RequestMapping(value="commDelete", method=RequestMethod.GET)
	public String commDelete(int community_id, RedirectAttributes rttr) {
		String result = "fail";
		if(commService.commCommunityDelete(community_id)>0) {result="글삭제 완료";}
		rttr.addFlashAttribute("success",result);
		return "community/redirect:/community/commView";
	}
	@RequestMapping(value="commLike", method=RequestMethod.POST, headers= {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> commLike(@RequestBody CommDtoCommunityLike like) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(like);
		int check = 0;
		if(like.isCheckLike()) {
			check = commServiceLike.communityLikeDelete(like);
		}else {
			check = commServiceLike.communityLikeInsert(like);			
		}
		if(check>0) {
			result.put("commCheckLike",Boolean.TRUE);			
		}else {
			result.put("commCheckLike",Boolean.FALSE);			
		}
		result.put("result", Boolean.TRUE);
		return result;
	}
	@RequestMapping(value="commentLike", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentLike(@RequestBody CommDtoCommentLike like) {
		Map<String, Object> result = new HashMap<>();
		int check = 0;
		if(like.isCheckLike()) {
			check = commServiceCommentLike.commentLikeInsert(like);
		}else {
			check = commServiceCommentLike.commentLikeDelete(like);			
		}
		if(check>0) {
			result.put("commentCheckLike",Boolean.TRUE);			
		}else {
			result.put("commentCheckLike",Boolean.FALSE);			
		}
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value="commentInsert", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> comment(@RequestBody CommDtoComment comment, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		List<CommDtoComment> comments = commServiceComment.commentInsert(comment,request);
		result.put("result", Boolean.TRUE);
		result.put("comment", comments);
		return result;
	}
	@RequestMapping(value="commentUpdate", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentUpdate(@RequestBody CommDtoComment comment) {
		Map<String, Object> result = new HashMap<>();
		List<CommDtoComment> comments = commServiceComment.commentUpdate(comment);
		result.put("result", Boolean.TRUE);
		result.put("comment", comments);
		return result;
	}
	@RequestMapping(value="commentDelete", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentDelete(@RequestBody CommDtoComment comment) {
		Map<String, Object> result = new HashMap<>();
		List<CommDtoComment> comments = commServiceComment.commentDelete(comment);
		result.put("result", Boolean.TRUE);
		result.put("comment", comments);
		return result;
	}
	
}
