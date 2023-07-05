package com.kawai.service;

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
	public int accountEventCheck(AccountEventVO eventVO) {
		// 금일날짜 출석체크 유무 기존에 체크한적이 있다면 체크하지 않기 위함
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
