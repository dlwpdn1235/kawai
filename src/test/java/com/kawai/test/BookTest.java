package com.kawai.test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dao.BookImgDao;
import com.kawai.dao.BookLikesDao;
import com.kawai.dao.BookStoreDao;
import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookLikesVO;
import com.kawai.dto.BookStoreVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/**/servlet-kawai-context.xml"})

@WebAppConfiguration
@Log4j
public class BookTest {
	@Autowired BookHashTagDao tagdao;
	@Autowired BookImgDao imgdao;
	@Autowired BookStoreDao bookdao;
	@Autowired BookLikesDao likesdao;
	
	@Test  @Ignore
	public void testtag() {
		BookHashTagVO vo = new BookHashTagVO(); 
	//	tagdao.tagdelete(23); //delete
		
	//	vo.setTag_name("#sally2"); vo.setTag_id(21);
	//	System.out.println(tagdao.taginsert(vo)); // insert
		
	//	vo.setTag_name("#sally3"); vo.setTag_id(21);
	//	System.out.println(tagdao.tagupdate(vo)); // update
		
	//	System.out.println( tagdao.tagread(21) );  //read
		
		//(1)  readAll
		for( BookHashTagVO u  : tagdao.tagreadAll()) { System.out.println(u); }
	}
	
	@Test @Ignore
	public void testimg() {
		BookImgVO vo = new BookImgVO(); 
		
		vo.setBs_no(0);  // 해당 이미지와 관련된 bookstore의 bs_no (예: 3번 서점)
	    vo.setImg_file_name("새로운이미지.jpg");  // 추가할 이미지 파일명
	    //vo.setImg_reg_date(LocalDateTime.now());  // 이미지 등록 날짜 및 시간

	    System.out.println(imgdao.imginsert(vo)); // 이미지 추가 메서드 호출
/*		
	    imgdao.imgdelete(3); //delete
		
		vo.setImg_no(1);  // 수정할 이미지의 img_no (예: 1번 이미지)
		vo.setImg_file_name("수정된이미지.jpg");  // 수정할 이미지 파일명
		imgdao.imgupdate(vo);  // 이미지 수정 메서드 호출 update
		
		System.out.println( imgdao.imgread(3) );  //read
*/		
		//(1)  readAll
		for( BookImgVO u  : imgdao.imgreadAll()) { System.out.println(u); }
	}
	
	@Test //@Ignore
	public void testbookstore() {
		BookStoreVO vo = new BookStoreVO(); 
		vo.setUser_id("김도연");
		vo.setTag_id(1);
		vo.setBs_name("유어마인드");
		vo.setBs_start_date(Time.valueOf("13:00:00"));
		vo.setBs_end_date(Time.valueOf("20:00:00"));
		vo.setBs_closeday("매달 첫째,셋째 화요일 휴무");
		vo.setBs_phonenum("070-8821-8990");
		vo.setBs_postnum("03703");
		vo.setBs_address("서울특별시 서대문구 연희동 132-32");
		vo.setBs_address_detail("2층");
		//vo.setBs_opendate(LocalDateTime.parse("2010-01-01T00:00:00"));
		vo.setBs_content("국 내 최초의 독립출판물 전문 서점이다. 출판사를 겸하고 있다. 2009년부터 매년 서울아트부게어 '언리미티드 에디션(UE, Unlimited Edition)'을 열어오고 있다.");
		vo.setBs_reg_date("23-06-01");
		

	    System.out.println(bookdao.bookstoreinsert(vo)); // insert	
		
		
/*		System.out.println( bookdao.bookstoredelete(4)); //delete
		
			vo.setBs_no(5);
		 	vo.setTag_id(2);
		 	vo.setBs_start_date(Time.valueOf("15:00:00"));
		    vo.setBs_end_date(Time.valueOf("22:00:00"));
		    vo.setBs_closeday("매달 첫째,셋째 화요일 휴무무");
		    vo.setBs_phonenum("070-8821-1111");
		    vo.setBs_opendate(LocalDateTime.parse("2010-01-01T13:13:13"));
		    vo.setBs_content("국 내 최초의 엄대용 엄대용 출판사를 겸하고 있다. 2009년부터 매년 서울아트부게어 '언리미티드 에디션(UE, Unlimited Edition)'을 열어오고 있다.");
		    vo.setBs_reg_date("23-06-03");
		
		System.out.println(bookdao.bookstoreupdate(vo)); // update
		
		System.out.println( bookdao.bookstoreread(3) );  //read
		*/
		//(1)  readAll
		for( BookStoreVO u  : bookdao.bookstorereadAll()) { System.out.println(u); }
	}
	
	@Test @Ignore
	public void testlikes() {
		BookLikesVO vo = new BookLikesVO(); 

		vo.setFk_id("김도연");  // 사용자 ID 설정
		vo.setFk_bs_no(3);  // 서점 번호 설정
		likesdao.likesinsert(vo);  // 좋아요 정보 추가
		System.out.println("좋아요 정보가 추가되었습니다.");
		
		
//		vo.setFk_id("엄대용"); vo.setFk_bs_no(2);
//		System.out.println(likesdao.likesupdate(vo)); // update 없음
		
		
//		likesdao.likesdelete(3); //delete
		
		System.out.println( likesdao.likesread(2) );  //read
		
		//(1)  readAll
		for( BookLikesVO u  : likesdao.likesreadAll()) { System.out.println(u); }
	}
}
