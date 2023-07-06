package com.kawai.service;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.AccountUserDao;
import com.kawai.dto.AccountUserVO;

@Service("accountUserService")
public class AccountUserServiceImpl implements AccountUserService {
	@Autowired AccountUserDao dao;

	@Override
	public int accountUserInsert(HttpServletRequest request , AccountUserVO user) {
		//회원가입 서비스
		String basic_adress = request.getParameter("basic_addr");
		user.setAddress(basic_adress + user.getAddress());
		try {
			user.setCreate_ip(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception e) { e.printStackTrace(); }
		return dao.accountUserInsert(user); 
	}

	@Override
	public AccountUserVO accountLogin(HttpServletRequest request , AccountUserVO user) {
		//로그인 서비스
		if(dao.accountLogin(user)!=null) { //로그인이 되었다면
			request.getSession().setAttribute("account", user);
		}
		return dao.accountLogin(user);
	}

	@Override
	public AccountUserVO accountUserRead(AccountUserVO user) {
		//나의 정보
		return dao.accountUserRead(user);
	}

	@Override
	public List<AccountUserVO> accountUserList() {
		//회원목록
		return dao.accountUserList();
	}

	@Override
	public int accountUserUpdate(HttpServletRequest request , AccountUserVO user ) {
		//회원정보 수정
		return dao.accountUserUpdate(user);
	}

	@Override
	public int accountUserDelete(AccountUserVO user) {
		//회원 탈퇴
		return dao.accountUserDelete(user);
	}


}
