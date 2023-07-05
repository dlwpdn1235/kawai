package com.kawai.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kawai.dto.AccountCouponVO;
import com.kawai.dto.AccountEventVO;
import com.kawai.dto.AccountUserVO;
import com.kawai.service.AccountEventService;
import com.kawai.service.AccountUserService;

@Controller
public class AccountController {
	@Autowired AccountUserService userService;
	@Autowired AccountEventService eventService;
	
	@RequestMapping(value = "/singUp", method = RequestMethod.GET)
	public String singUp_view() { return "account/singUp"; }
	//회원가입폼으로 이동
	
	@RequestMapping(value = "/singUp", method = RequestMethod.POST)
	public String accountUserInsert(HttpServletRequest request, AccountUserVO userVO , RedirectAttributes rttr) {
	//회원가입액션
		String result="회원가입에 실패하였습니다. 관리자에게 문의 바랍니다.";
		if(userService.accountUserInsert(request , userVO) > 0) {
			result="회원가입이 완료되었습니다.";
		}
		rttr.addFlashAttribute("success" , result);
		return "redirect:/account/userEvent";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String accountLogin_view() { return "account/login"; }
	//사용자 로그인 뷰페이지로
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String accountLogin(HttpServletRequest request , AccountUserVO userVO ,
			AccountEventVO eventVO , AccountCouponVO couponVO) {
		//사용자 로그인액션
		String result="로그인 실패! 아이디 또는 비밀번호를 확인해주세요.";
		if((userVO = userService.accountLogin(request , userVO)) != null) {		
			result="환영합니다."+userVO.getName() + "님!";
		}
		return "redirect:/account/userEvent";
	}

	@RequestMapping(value= "/userDetail" , method = RequestMethod.GET)
	public void userDetail(AccountUserVO userVO , Model model) {
		//유저정보 상세보기
		model.addAttribute(userService.accountUserRead(userVO));
		model.addAttribute(eventService.readCoupon(userVO.getId()));
	}
	
	@RequestMapping(value="/userEdit" , method = RequestMethod.GET)
	public void userEdit_view(AccountUserVO userVO , Model model) {
		//유저정보 수정폼
		model.addAttribute(userService.accountUserRead(userVO));
	}
	
	@RequestMapping(value="/userEdit" , method = RequestMethod.POST)
	public String userEdit(AccountUserVO userVO , HttpServletRequest request,RedirectAttributes rttr) {
		//유저정보 수정액션
		String result = "정보수정에 실패하였습니다. 관리자에게 문의 바랍니다.";
		if(userService.accountUserUpdate(request, userVO) > 0 ) { result = "회원정보가 변경되었습니다."; }
		rttr.addFlashAttribute("success" , result);
		return "redirect:/account/userEdit?id=" + userVO.getId();
	
	}
	
	@RequestMapping(value="/userDelete" , method = RequestMethod.GET)
		//유저 탈퇴 폼
	public String userDelete_view() { return "account/userDelete"; }
	
	@RequestMapping(value="/userDelete" , method = RequestMethod.POST)
		//유저 탈퇴 폼
	public String userDelete(AccountUserVO userVO , RedirectAttributes rttr) {
		String result = "회원탈퇴 실패. 관리자에게 문의 바랍니다.";
		if(userService.accountUserDelete(userVO) > 0 ) { result = "회원탈퇴가 정상 처리되었습니다."; }
		rttr.addFlashAttribute("success" , result);
		return "redirect:/main";
	}

	
	
	// 여기는 이벤트 페이지에대한 처리
	
	@RequestMapping(value="/userEvent" , method = RequestMethod.GET )
	public String userEvent(AccountUserVO userVO , AccountEventVO eventVO
				, AccountCouponVO couponVO ,RedirectAttributes rttr ) {
		//출석체크 리스트
		eventService.accountEventList(eventVO.getId());
		
		//출석체크에대한 구문
		if(eventService.accountEventCheck(eventVO) > 0) {
			eventService.accountEventDo(eventVO.getId());
		}
		
		//쿠폰지금 조회
		if(eventService.accountEventDays(eventVO.getId()) == 20) {
			eventService.couponInsert(eventVO.getId());
		}
		
		return "redirect:/account/userEvent?id=" + userVO.getId();
	}
	
	
	
	
	
	
	
	
	
}