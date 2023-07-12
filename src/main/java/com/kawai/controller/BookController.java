package com.kawai.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookLikesVO;
import com.kawai.dto.BookStoreVO;
import com.kawai.dto.BookTagBoxVO;
import com.kawai.service.BookHashTagService;
import com.kawai.service.BookImgService;
import com.kawai.service.BookLikesService;
import com.kawai.service.BookStoreService;
import com.kawai.service.BookTagBoxService;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping(value="/kawai/*")
@Log4j
public class BookController {
	@Autowired BookHashTagService tagservice;
	@Autowired BookStoreService storeservice;
	@Autowired BookImgService imgservice;
	@Autowired BookTagBoxService boxservice;
	@Autowired BookLikesService likeservice;
	
	//index 에서 main2 페이지로 a태그 받아왔을때 처리
	@RequestMapping(value = "/main3", method = RequestMethod.GET)
	public String list(Model model ) {
//		int bsNo = 123; // 실제로 bs_no 값을 가져오는 로직이 필요
//		model.addAttribute("bs_no" ,bsNo);
		model.addAttribute("list" , storeservice.bookstorereadAll());
		return "book/main3";
	}
	
	//main2 에서 write.jsp a태그 등록하기버튼 눌렀을때 처리
	@RequestMapping(value="/write" , method=RequestMethod.GET)
	public String write_view(BookStoreVO vo) {
		System.out.println("write_view page");
		return "book/write";
	}
	
	@RequestMapping(value="/write" , method=RequestMethod.POST)
	public String write(
	        BookStoreVO vo,  
	        MultipartFile file, HttpServletRequest request,
	        Model model,
	        @RequestParam("selectedTags") String selectedTagIds
	        /* @RequestParam(value="taglist", required = false) int[] taglist, */
	       /*  , 
	         @RequestParam("bs_opendate") @DateTimeFormat(pattern = "yyyy-MM-dd") String bs_opendate, 
	        @RequestParam("bs_start_time") String start_time,
	        @RequestParam("bs_end_time") String end_time  */
	      ) throws ParseException {
	
	    vo.setUser_id((String)request.getSession().getAttribute("account")); //user_id(user 테이블의 id) 설정 
	    
	    log.info("............." + vo);
	    log.info("............." + selectedTagIds);
	
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    vo.setBs_reg_date(now);  // 등록날짜 (커렌트)
		
	    String start_time = vo.getBs_start_time();
	    String end_time = vo.getBs_end_time();
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    Date time = timeFormat.parse(start_time);
	    Date time2 = timeFormat.parse(end_time);

	    SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
	    String formattedTime = outputFormat.format(time);
	    String formattedTime2 = outputFormat.format(time2);
	    vo.setBs_start_time(formattedTime);  // 오픈시간
	    vo.setBs_end_time(formattedTime2);   // 마감시간

	    
	    //이미지 업로드
//	    log.info( imgservice.imginsert(file, request, ivo) );
	   //model.addAttribute("img",imgservice.imginsert(file, request, ivo));
	    //왜 안되니...이친구야...
	    
//	    log.info(model.addAttribute("img" , imgservice.imgread(ivo)));
	    
	    ///// 1.   insert  -   bsNo
	    log.info("............." + vo); 
	    log.info("잘들어가는지 확인: " + storeservice.bookstoreinsert(file, request, vo));
	    
	    ///// 2.  제일 높은bs_no 찾아서 bsNo에 넣고
	    Integer bsNo = storeservice.findMaxBsNo(); 
	    vo.setBs_no(bsNo);

         ///// 3. 리스트로 만들기 -  BookTagBoxVO
	    List<Integer> selectedTagId = Arrays.asList(selectedTagIds.split(","))
	            .stream()
	            .map(Integer::parseInt)
	            .collect(Collectors.toList());
	    log.info(selectedTagId);
	  

	    List<BookTagBoxVO> tagBoxes = new ArrayList<>();

        ///// 4. 리스트로 만들기 -  BookTagBoxVO
	    for (Integer tagId : selectedTagId) {
	        BookTagBoxVO tagBox = new BookTagBoxVO();
	        tagBox.setBs_no(vo.getBs_no());
	        tagBox.setTag_id(tagId);
	        tagBox.setBs_name(vo.getBs_name());
	        String tagName = tagservice.getTagNameByTagId(tagId);
	        tagBox.setTag_name(tagName);
	        
	        log.info("tagBox 잘 가져오는지 확인: " + tagBox);
	        tagBoxes.add(tagBox);
	        boxservice.boxinsert(tagBox);  //##
	    }
	    log.info(selectedTagId);
        ///// 5. 
	    List<BookStoreVO> storeList = storeservice.bookstorereadAll();
	   // log.info(storeList);   // 값은 제데로 가져오긴하는대... tagnames=null 인상황

	    ///// 6. tag _name 가져오기
	    BookTagBoxVO tvo = new BookTagBoxVO();
	    tvo.setBs_no(vo.getBs_no());
	    List<BookTagBoxVO> tagname = boxservice.findTagByName2(tvo);
	    for (BookTagBoxVO tagBox : tagname) {
	        String tagName = tagBox.getTag_name();
	        log.info("Tag Name: " + tagName);
	    }
	    
	    log.info("vo 출력 :"+vo);
	    
	    model.addAttribute("list", storeList);

	    return "book/book_admin_list";
  
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("bs_name") String bs_name,
			Model model) {
	    // bs_name에 해당하는 정보를 가져와서 모델에 저장
	    List<BookStoreVO> storeList = storeservice.getBsName(bs_name);
	    if (!storeList.isEmpty()) {
	        BookStoreVO store = storeList.get(0); // 첫 번째 객체 가져오기
	        
	        int bsNo = store.getBs_no();
	        
	        List<String> tagNames = storeservice.getBookStoreTagNames(bsNo);
	        store.setTagNames(tagNames);
	        
	        log.info("tagNames 값: " + tagNames);
	        log.info("store 값: " + store);
	        
	        model.addAttribute("tagNames", tagNames); // 해시태그 값을 모델에 추가
	        model.addAttribute("name", store);
	    }
	    return "book/detail";
	}
	
	
	//임시용 
	// main2 에서 book_admin_list.jsp a태그 리스트로 가기 눌렀을때 처리
	@RequestMapping(value="/book_admin_list", method=RequestMethod.GET)
	public String test( Model model ) {
	    model.addAttribute("list", storeservice.bookstorereadAll());

	    // 해당 서점의 해시태그 정보 가져오기 (조인 사용)
//	    int bs_no = bvo.getBs_no();
//	    List<String> tagNames = storeservice.getBookStoreTagNames(bs_no);
	    
	    // 모델에 해시태그 목록 저장
//	    model.addAttribute("tagNames", tagNames);
	    
	    return "book/book_admin_list";
	}
	
	//임시용 2
		// main2 에서 book_user.jsp a태그 리스트로 가기 눌렀을때 처리
		@RequestMapping(value="/book_user", method=RequestMethod.GET)
		public String book_user(Model model ) {
			
		    model.addAttribute("list", storeservice.bookstorereadAll());

		    // 해당 서점의 해시태그 정보 가져오기 (조인 사용)
//		    int bs_no = bvo.getBs_no();
//		    List<String> tagNames = storeservice.getBookStoreTagNames(bs_no);
//
//		    // 모델에 해시태그 목록 저장
//		    model.addAttribute("tagNames", tagNames);

		    return "book/book_user";
		}
		

	@RequestMapping(value="/read" , method= RequestMethod.GET)   
	public void read(Model model , BookStoreVO vo)  {
		log.info(".............read");
		model.addAttribute(storeservice.bookstoreread(vo));
		}
	
	
//	@RequestMapping(value="/kawai/book_admin_list", method=RequestMethod.POST)
//	@ResponseBody
//	public String admin_list(@RequestParam List<Integer> taglist, BookStoreVO vo, Model model) {
//	  if (taglist != null) {
//	    for (Integer t : taglist) {
//	      System.out.println("선택된 태그 ID: " + t);
//	    }
//	  }
//	  vo.setTaglist(taglist);
//	  model.addAttribute("taglist", taglist);
//	  storeservice.bookstoreinsert(vo);
//
//	  return "book/book_admin_list"; // 클라이언트로 응답을 전송할 뷰 페이지
//	}
	
////////////////////////////////////
//////////// Ajax 기능구현 ////////////
	
		//모달창에 태그목록(HashTag 값) 보여주기
			 @RequestMapping(value="/getHashtags" , method= RequestMethod.GET)   
			 @ResponseBody
			  public List<BookHashTagVO> getHashtags() {
			    // 서비스 레이어나 데이터베이스로부터 해시태그 데이터를 가져와서 반환
			    List<BookHashTagVO> hashtags = tagservice.tagreadAll();
			    //log.info(hashtags);
			    return hashtags;
			  }
		 
		//좋아요 이미지 클릭했을때 이미지 변경하기
			 @RequestMapping(value="/add" , method= RequestMethod.POST )
			    public String addBookLikes(@ModelAttribute BookLikesVO bookLikes) {
			        likeservice.insertBookLikes(bookLikes);
			        return "book/detail";
			    }

			    @RequestMapping(value="/remove" , method= RequestMethod.POST )
			    public String removeBookLikes(@ModelAttribute BookLikesVO bookLikes) {
			    	likeservice.deleteBookLikes(bookLikes);
			        return "book/detail";
			    }

			    @RequestMapping(value="/success" , method= RequestMethod.GET )
			    public String successPage() {
			        return "book/detail"; // success.jsp 또는 success.html과 같은 뷰 페이지를 반환합니다.
			    }
			    
			    @RequestMapping(value = "/checkLikes", method = RequestMethod.POST)
			    @ResponseBody
			    public Map<String, Object> checkLikes(@RequestParam("fk_id") String fk_id, @RequestParam("fk_bs_no") String fk_bs_no) {
			        // 좋아요 상태를 확인하는 로직을 구현합니다.
			        boolean isLiked = likeservice.checkLikes(fk_id, fk_bs_no);

			        // 이미지 URL을 설정합니다.
			        String imageUrl = isLiked ? "${pageContext.request.contextPath}/kawai/img/marketLikeCheck.jpg"
			                : "${pageContext.request.contextPath}/kawai/img/marketLikeUnCheck.jpg";

			        // 응답 데이터를 생성합니다.
			        Map<String, Object> response = new HashMap<>();
			        response.put("imageUrl", imageUrl);

			        return response;
			    }







			 
			 
		 
		 
	//이미지 파일 업로드
//		 @RequestMapping(value="/uploadImage" , method=RequestMethod.POST)
//		 public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile,  HttpServletRequest request) {
//		   // 이미지 파일 업로드 처리
//		   if (!imageFile.isEmpty()) {
//		     try {
//		       // 파일 저장 경로 설정
//		       String uploadPath = "/path/to/upload/directory";
//		       String fileName = imageFile.getOriginalFilename();
//		       String filePath = uploadPath + "/" + fileName;
//
//		       // 파일 저장
//		       File dest = new File(filePath);
//		       imageFile.transferTo(dest);
//
//		       // 파일 업로드 성공
//		       // 추가로 필요한 로직을 작성하거나 필요한 데이터를 처리할 수 있습니다.
//
//		       return "upload_success";
//		     } catch (Exception e) {
//		       e.printStackTrace();
//		       // 파일 업로드 실패
//		       // 실패 처리를 위한 로직을 작성하거나 에러 페이지로 리다이렉트 등을 수행할 수 있습니다.
//
//		       return "upload_failure";
//		     }
//		   }
//
//		   // 업로드할 이미지 파일이 없는 경우
//		   // 예외 처리 등을 수행할 수 있습니다.
//
//		   return "upload_failure";
//		 }
		 
		 

	
}
