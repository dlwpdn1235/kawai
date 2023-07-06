package com.kawai.controller;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Locale.IsoCountryCode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookStoreVO;
import com.kawai.service.BookHashTagService;
import com.kawai.service.BookImgService;
import com.kawai.service.BookStoreService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/kawai/*")
@Log4j
public class BookController {
	@Autowired BookHashTagService tagservice;
	@Autowired BookStoreService storeservice;
	@Autowired BookImgService imgservice;
	
	//index 에서 main2 페이지로 a태그 받아왔을때 처리
	@RequestMapping(value = "/main2", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		return "book/main2";
	}
	
	
	//main2 에서 write.jsp a태그 등록하기버튼 눌렀을때 처리
	@RequestMapping(value="/write" , method=RequestMethod.GET)
	public String write_view(BookStoreVO vo) {
		System.out.println("write_view page");
		log.info("..............this is page.");
		return "book/write";
	}
	
	@PostMapping(value="/write")
	public String write(BookStoreVO vo, @RequestParam(value="taglist", required = false) int[] taglist,
            @RequestParam("bs_opendate") @DateTimeFormat(pattern = "yyyy-MM-dd") String bs_opendate ,
            @RequestParam("bs_start_time") @DateTimeFormat(pattern = "HH:mm:ss") Date bs_start_time,
            @RequestParam("bs_end_time") @DateTimeFormat(pattern = "HH:mm:ss") Date bs_end_time) throws ParseException {
	    log.info(".................." + vo);
	    vo.setUser_id("김도연");
	    vo.setBs_postnum("121");
	    vo.setTag_id(2);
	    vo.getTaglist();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    format.parse(bs_opendate);
	    
	    Time start_time = new Time(bs_start_time.getTime());
	    Time end_time = new Time(bs_end_time.getTime());
	    vo.setBs_start_date(start_time);
	    vo.setBs_end_date(end_time);
	    
	    log.info(".................." + vo);
	    System.out.println("작성완료" + vo);
	    return "book/book_admin_list";
	}
	
	@RequestMapping(value="/read" , method= RequestMethod.GET)   
	public void read(Model model , BookStoreVO vo)  {
		log.info(".............read");
		model.addAttribute(storeservice.bookstoreread(2));
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
			 @GetMapping(value="/getHashtags")
			 @ResponseBody
			  public List<BookHashTagVO> getHashtags() {
			    // 서비스 레이어나 데이터베이스로부터 해시태그 데이터를 가져와서 반환
			    List<BookHashTagVO> hashtags = tagservice.tagreadAll();
			    log.info(hashtags);
			    return hashtags;
			  }
		 
		 
		// 선택한 태그값들을 배열처리후 확인문구보내기 
//		 @PostMapping("/kawai/processTags")
//		 @ResponseBody
//		 public String processTags(@RequestBody int[] tag_id) {
//		   // 선택한 태그 배열 처리 및 필요한 작업 수행
//		   if (tag_id != null) {
//		     for (int t : tag_id) {
//		       System.out.println("선택된 태그 ID: " + t);
//		     }
//		   }
//		   // 응답 메시지 등을 반환
//		   return tag_id != null ? Arrays.toString(tag_id) : "";
//		 }
		 
		 
	//이미지 파일 업로드
		 @PostMapping(value="/uploadImage")
		 public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile,  HttpServletRequest request) {
		   // 이미지 파일 업로드 처리
		   if (!imageFile.isEmpty()) {
		     try {
		       // 파일 저장 경로 설정
		       String uploadPath = "/path/to/upload/directory";
		       String fileName = imageFile.getOriginalFilename();
		       String filePath = uploadPath + "/" + fileName;

		       // 파일 저장
		       File dest = new File(filePath);
		       imageFile.transferTo(dest);

		       // 파일 업로드 성공
		       // 추가로 필요한 로직을 작성하거나 필요한 데이터를 처리할 수 있습니다.

		       return "upload_success";
		     } catch (Exception e) {
		       e.printStackTrace();
		       // 파일 업로드 실패
		       // 실패 처리를 위한 로직을 작성하거나 에러 페이지로 리다이렉트 등을 수행할 수 있습니다.

		       return "upload_failure";
		     }
		   }

		   // 업로드할 이미지 파일이 없는 경우
		   // 예외 처리 등을 수행할 수 있습니다.

		   return "upload_failure";
		 }
		 
		 

	
}
