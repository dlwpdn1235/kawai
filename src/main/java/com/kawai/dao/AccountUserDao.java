package com.kawai.dao;

import java.util.List;

import com.kawai.dto.AccountUserVO;

public interface AccountUserDao {
	// 회원가입 accountUserInsert
	public int accountUserInsert(AccountUserVO user);
	
	// 아이디 중복 체크
	public int accountIdCheck(String id);
	
	// 로그인 accointLogin
	public AccountUserVO accountLogin(AccountUserVO user);
	
	// 회원정보 상세보기 accountUserRead
	public AccountUserVO accountUserRead(AccountUserVO user);
	public AccountUserVO accountUserRead2(String userId);
	
	// 회원목록 리스트 accountUserList
	public List<AccountUserVO> accountUserList();
	
	// 회원정보 수정 accountUserUpdate
	public int accountUserUpdate(AccountUserVO user);
	
	// 회원탈퇴 accountUserDelete
	public int accountUserDelete(AccountUserVO user);
	
	// email 찾기 emailfind
	public String emailfind(String email);
	
	//<!-- pass 전송 -->
	public String findPass(String email);
}
