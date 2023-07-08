package com.kawai.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.AccountEventDao;
import com.kawai.dto.AccountEventVO;
import com.kawai.dto.AccountUserVO;

@Service("accountEventService")
public class AccountEventServiceImpl implements AccountEventService{
	@Autowired AccountEventDao dao;
	
	@Override
	public int accountEventCheck(String id) {
		// 세션에 있는 아이디값 - 날짜
		//이 아이디값은 세션에 저장된 값을 끌어올 예정
		
		// 금일날짜 출석체크 유무 기존에 체크한적이 있다면 체크하지 않기 위함
		LocalDate now = LocalDate.now();
		AccountEventVO eventVO = new AccountEventVO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		eventVO.setId( id );
		eventVO.setEventdate(formatedNow);
		
		return dao.accountEventCheck(eventVO);
	}

	@Override
	public int accountEventDo(String id) {
		// 금일날짜 출석체크 해당날짜에 출석체크를 한 적 없다면 값 입력
		return dao.accountEventDo(id);
	}

	@Override
	public List<AccountEventVO> accountEventList(String id) {
		// 한 유저의 출석체크한 날짜조회(리스트) VIEW에 달력식으로 값 넣기
		return dao.accountEventList(id);
	}

	@Override
	public int accountEventDays(String id) {
		// 한 유저의 출석체크한 날짜일수 조회 20이 되면 쿠폰을 발급하기 위함
		return dao.accountEventDays(id);
	}

	@Override
	public int couponInsert(String id) {
		// 쿠폰지급
		return dao.couponInsert(id);
	}

	@Override
	public AccountUserVO readCoupon(String id) {
		// 유저 쿠폰 조회
		return dao.readCoupon(id);
	}
	
}
