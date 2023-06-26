package kawai_project;

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

import com.kawai.dao.BookImgDao;
import com.kawai.dao.BookLikesDao;
import com.kawai.dao.BookStoreDao;
import com.kawai.dto.BookHashTagVO;
import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookLikesVO;
import com.kawai.dto.BookStoreVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")

public class booktest {
	@Autowired ApplicationContext context;
	//@Autowired BookHashTagDao dao;
	//@Autowired BookImgDao dao;
	//@Autowired BookStoreDao dao;
	@Autowired BookLikesDao dao;
	
	JdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	@Test @Ignore
	public void test0() {
		System.out.println(jdbc.query("select * from test", ((rs,index)->rs.getInt(1)) ) );
		
	}
	@Test @Ignore
	public void testtag() {
		BookHashTagVO vo = new BookHashTagVO(); 
		//dao.tagdelete(22); //delete
		
		//vo.setTag_name("#sally2"); vo.setTag_id(21);
		//System.out.println(dao.taginsert(vo)); // insert
		
		//vo.setTag_name("#sally3"); vo.setTag_id(21);
		//System.out.println(dao.tagupdate(vo)); // update
		
		//System.out.println( dao.tagread(21) );  //read
		
		//(1)  readAll
		//for( BookHashTagVO u  : dao.tagreadAll()) { System.out.println(u); }
	}
	
	@Test @Ignore
	public void testimg() {
		BookImgVO vo = new BookImgVO(); 
		
		//vo.setBs_no(3);  // 해당 이미지와 관련된 bookstore의 bs_no (예: 3번 서점)
	    vo.setImg_file_name("새로운이미지.jpg");  // 추가할 이미지 파일명
	    vo.setImg_reg_date(LocalDateTime.now());  // 이미지 등록 날짜 및 시간

	    System.out.println(dao.imginsert(vo)); // 이미지 추가 메서드 호출
		
		//dao.tagdelete(22); //delete
		
//		vo.setImg_no(1);  // 수정할 이미지의 img_no (예: 1번 이미지)
//		vo.setImg_file_name("수정된이미지.jpg");  // 수정할 이미지 파일명
//		dao.imgupdate(vo);  // 이미지 수정 메서드 호출 update
//		
		System.out.println( dao.imgread(3) );  //read
		
		//(1)  readAll
		for( BookImgVO u  : dao.imgreadAll()) { System.out.println(u); }
	}
	
	@Test @Ignore
	public void testbookstore() {
		BookStoreVO vo = new BookStoreVO(); 
		
//		 vo.setUser_id("김도연");
//		 vo.setTag_id(1);
//		 vo.setBs_name("유어마인드");
//		    vo.setBs_start_date(Time.valueOf("13:00:00"));
//		    vo.setBs_end_date(Time.valueOf("20:00:00"));
//		    vo.setBs_closeday("매달 첫째,셋째 화요일 휴무");
//		    vo.setBs_phonenum("070-8821-8990");
//		    vo.setBs_postnum("03703");
//		    vo.setBs_address("서울특별시 서대문구 연희동 132-32");
//		    vo.setBs_address_detail("2층");
//		    vo.setBs_opendate(LocalDateTime.parse("2010-01-01T00:00:00"));
//		    vo.setBs_content("국 내 최초의 독립출판물 전문 서점이다. 출판사를 겸하고 있다. 2009년부터 매년 서울아트부게어 '언리미티드 에디션(UE, Unlimited Edition)'을 열어오고 있다.");
//		    vo.setBs_reg_date("23-06-01");
//		System.out.println(dao.bookstoreinsert(vo)); // insert
		
	//	System.out.println( dao.bookstoredelete(4)); //delete
		
//			vo.setBs_no(5);
//		 	vo.setTag_id(2);
//		 	vo.setBs_start_date(Time.valueOf("15:00:00"));
//		    vo.setBs_end_date(Time.valueOf("22:00:00"));
//		    vo.setBs_closeday("매달 첫째,셋째 화요일 휴무무");
//		    vo.setBs_phonenum("070-8821-1111");
//		    vo.setBs_opendate(LocalDateTime.parse("2010-01-01T13:13:13"));
//		    vo.setBs_content("국 내 최초의 엄대용 엄대용 출판사를 겸하고 있다. 2009년부터 매년 서울아트부게어 '언리미티드 에디션(UE, Unlimited Edition)'을 열어오고 있다.");
//		    vo.setBs_reg_date("23-06-03");
//		
//		System.out.println(dao.bookstoreupdate(vo)); // update
		
		//System.out.println( dao.bookstoreread(3) );  //read
		
		//(1)  readAll
		for( BookStoreVO u  : dao.bookstorereadAll()) { System.out.println(u); }
	}
	
	@Test //@Ignore
	public void testlikes() {
		BookLikesVO vo = new BookLikesVO(); 

//		vo.setFk_id("김도연");  // 사용자 ID 설정
//		vo.setFk_bs_no(2);  // 서점 번호 설정
//		dao.likesinsert(vo);  // 좋아요 정보 추가
//		System.out.println("좋아요 정보가 추가되었습니다.");
		
		
//		vo.setFk_id("엄대용"); vo.setFk_bs_no(2);
//		System.out.println(dao.likesupdate(vo)); // update 없음
		
		
//		dao.likesdelete(3); //delete
		
//		System.out.println( dao.likesread(2) );  //read
		
		//(1)  readAll
//		for( BookLikesVO u  : dao.likesreadAll()) { System.out.println(u); }
	}
}
