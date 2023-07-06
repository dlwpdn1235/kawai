package com.kawai.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.AccountEventDao;
import com.kawai.dao.AccountUserDao;
import com.kawai.dto.AccountEventVO;
import com.kawai.dto.AccountUserVO;

import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class AccountTest {
	@Autowired AccountEventDao event;
	@Autowired AccountUserDao user;

	@Test @Ignore
	public void singupTest() { //회원가입 테스트
		AccountUserVO userVO = new AccountUserVO();
		userVO.setId("user003234");
		userVO.setPass("1234");
		userVO.setName("wonsu");
		userVO.setBirth("1993-08-16");
		userVO.setEmail("kimwonsu007@naver.com");
		userVO.setPhonenum("010-3518-9041");
		userVO.setPostnum("05211");
		userVO.setAddress("서울특별시 은평구 구산동 서오릉로 25길");
		userVO.setCreate_ip("123.123.123.12");
		user.accountUserInsert(userVO);
	}
	
	@Test @Ignore
	public void loginTest() { //로그인 테스트
		AccountUserVO userVO = new AccountUserVO();
		userVO.setId("user001");
		userVO.setPass("1234");
		log.info(user.accountLogin(userVO));
	}
	
	/*
	 * @Test @Ignore public void accountUserReadTest() { //나의정보 테스트
	 * log.info(user.accountUserRead("user001")); }
	 */
	@Test @Ignore
	public void accountUserListTest() { //유저목록 테스트
		log.info(user.accountUserList());
		
	}
	
	@Test @Ignore
	public void accountUserUpdateTest() { //나의정보 수정 테스트
		AccountUserVO userVO = new AccountUserVO();
		userVO.setName("Test");
		userVO.setBirth("1994-08-16");
		userVO.setPhonenum("010-1234-1234");
		userVO.setPostnum("12345");
		userVO.setAddress("테스트테스트");
		userVO.setId("user001");
		log.info(user.accountUserUpdate(userVO));
		
	}
	
	@Test @Ignore
	public void accountUserDeleteTest() { //회원탈퇴 테스트
		AccountUserVO userVO = new AccountUserVO();
		userVO.setId("user003");
		userVO.setPass("1234");
		log.info(user.accountUserDelete(userVO));
	}
	
	
	
	//여기서부턴 이벤트 관련 DAO
	
	@Test @Ignore
	public void accountEventCheckTest() {
		//금일날짜 출석체크 유무 기존에 체크한적이 있다면 체크하지 않기 위함
		AccountEventVO eventVO = new AccountEventVO();
		eventVO.setId("user001");
		eventVO.setEventdate("2023-07-05");
		log.info(event.accountEventCheck(eventVO));
	}
	
	@Test @Ignore
	public void accountEventDoTest() {
		//금일날짜 출석체크 해당날짜에 출석체크를 한 적 없다면 값 insert
		log.info(event.accountEventDo("user001"));
	}
	
	@Test @Ignore
	public void accountEventListTest() {
		//한 유저의 출석체크한 날짜조회(리스트) VIEW에 달력식으로 값 넣어줄 예정
		log.info(event.accountEventList("user001"));
	}
	
	@Test @Ignore
	public void accountEventDaysTest() {
		//한 유저의 출석체크한 날짜일수 조회 20이 되면 쿠폰을 발급하기 위함
		log.info(event.accountEventDays("user001"));
	}
	
	@Test @Ignore
	public void couponInsertTest() {
		//쿠폰발급 (유저아이디의 event테이블 카운트가 20이 되면 사용)
		log.info(event.couponInsert("user001"));
	}
	
	@Test @Ignore
	public void readCoupon() {
		//쿠폰 조인하기위한 녀석 필요한것은 id값 뿐 쿠폰번호는 sql에서 디폴트를 난수로 내용은'해당월쿠폰'으로 디폴트 생성날짜는 커런트타임스탬프 / 스타트 앤드는 해당월의 시작일과 끝일
		log.info(event.readCoupon("user001"));
	}
	
	@Test //@Ignore
	public void timetest() {
		LocalDate now = LocalDate.now();
		AccountEventVO eventVO = new AccountEventVO();
		log.info(now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		eventVO.setId("user001");
		eventVO.setEventdate(formatedNow);
		log.info(event.accountEventCheck(eventVO));
	}
}