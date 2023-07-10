package com.kawai.dao;

import java.util.List;

import com.kawai.dto.AccountEventVO;
import com.kawai.dto.AccountUserVO;
// 이벤트페이지 출석체크 및 출석일확인페이지 쿠폰발급 및 조회
public interface AccountEventDao {
	// 금일날짜 출석체크 유무 기존에 체크한적이 있다면 체크하지 않기 위함
	public int accountEventCheck(AccountEventVO eventVO);
	// 금일날짜 출석체크 해당날짜에 출석체크를 한 적 없다면 값 입력
	public int accountEventDo(String id);
	// 한 유저의 출석체크한 날짜조회(리스트) VIEW에 달력식으로 값 넣기
	public List<String> accountEventList(String id);
	// 한 유저의 출석체크한 날짜일수 조회 20이 되면 쿠폰을 발급하기 위함
	public int accountEventDays(String id);
	// 쿠폰지급 
	public int couponInsert(String id);
	// 유저 쿠폰 조회
	public AccountUserVO readCoupon(String id);
}
