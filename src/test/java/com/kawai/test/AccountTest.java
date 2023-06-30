package com.kawai.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.AccountEventDao;
import com.kawai.dao.AccountUserDao;
import com.kawai.dto.AccountUserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class AccountTest {
	@Autowired AccountEventDao event;
	@Autowired AccountUserDao user;

	@Test //@Ignore
	public void singupTest() {
		AccountUserVO userVO = new AccountUserVO();
		userVO.setId("user001123");
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
	public void loginTest() {
		AccountUserVO userVO = new AccountUserVO();
		userVO.setId("user001");
		userVO.setPass("1234");
		user.accointLogin(userVO);
	}
	
}
