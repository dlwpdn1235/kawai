package com.kawai.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kawai.common.FindPassMail;
import com.kawai.common.MobileAuth;
import com.kawai.dao.AccountUserDao;
import com.kawai.dto.AccountUserVO;
import com.kawai.service.AccountEventService;
import com.kawai.service.AccountUserService;

import lombok.extern.log4j.Log4j;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@Controller
@Log4j
@RequestMapping("/account/*")
public class AccountController {
	@Autowired AccountUserService userService;
	@Autowired AccountEventService eventService;

	@Autowired FindPassMail mail;
	@Autowired AccountUserDao dao;
	@Autowired MobileAuth mobile;
	
	@RequestMapping(value = "/sendSMS" , method = RequestMethod.GET)
	public @ResponseBody String sendSMS(@RequestParam String to) throws CoolsmsException {
		return mobile.phoneNumberCheck(to);
	}


	
	@RequestMapping(value = "/singUp", method = RequestMethod.GET)
	public String singUp_view() { return "account/singUp"; }
	//회원가입폼으로 이동
	
	@RequestMapping(value = "/singUp", method = RequestMethod.POST)
	public String accountUserInsert(HttpServletRequest request, AccountUserVO userVO , RedirectAttributes rttr) {
	//회원가입액션
		String result="fail";
		if(userService.accountUserInsert(request , userVO) > 0) {
			result="회원가입이 완료되었습니다.";
		}
		rttr.addFlashAttribute("success" , result);
		return "redirect:/main/view";
	}
	
	
	//아이디 중복체크
		@RequestMapping(value="/accountIdCheck" ,method=RequestMethod.GET )
		@ResponseBody
		public Map<String, String> ajaxIdCheck(Model model, @RequestParam String id) {
			return userService.accountIdCheck(id);
		}
	
		
		
		
		
		
		
		
		
	
	
	@RequestMapping(value = "login" , method = RequestMethod.GET)
	public String accountLogin_view() { return "account/login"; }
	//사용자 로그인 뷰페이지로
	
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public String accountLogin(HttpServletRequest request , AccountUserVO userVO , RedirectAttributes rttr) {
		//사용자 로그인액션
		//세션 저장 + 현재날자구해서 
		String result="fail";
		if((userVO = userService.accountLogin(request , userVO)) != null) {		
			result="환영합니다."+userVO.getName() + "님!";			
		rttr.addFlashAttribute("success" , result); 
	    // 출석체크 처리
	    int checkCount = eventService.accountEventCheck(userVO.getId());	    
	    if (checkCount == 0) { eventService.accountEventDo(userVO.getId()); } //사용자일때
		if(userVO.getRole_id() == 1) { return "redirect:/main/view"; } //관리자일때
		
		/* return "redirect:/account/userEvent?id="+userVO.getId(); */
		return "redirect:/myCalendar_go";
		} result = "아이디와 비밀번호를 확인해주세요.";
		rttr.addFlashAttribute("success" , result);
		return "redirect:/account/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String accountLogout(HttpServletRequest request, RedirectAttributes rttr) {
	    // 세션 제거
	    // 1. 카카오 세션이 있다면  -  세션.겟에튜리뷰트할때 kakaoUser
		// 2. ver1 - ㄱUrl connection 끊기
		//"https://kauth.kakao.com/oauth/logout?client_id=5b0f67c0f0c2554251291f96f710c67d&logout_redirect_uri=http://localhost:8080/kawai/account/kakaoLogout"
	    // ver2 - 로그아웃 버튼이 나오게 
		request.getSession().invalidate(); 
	    rttr.addFlashAttribute("success", "로그아웃되었습니다.");
	    return "redirect:https://kauth.kakao.com/oauth/logout?client_id=5b0f67c0f0c2554251291f96f710c67d&logout_redirect_uri=http://3.34.129.104:8080/kawaiProject/account/logout2";
	}                 																										//http://3.34.129.104:8080/kawaiProject/kawai/account/logout2
	
	@RequestMapping(value = "logout2", method = RequestMethod.GET)
	public String accountLogout2(HttpServletRequest request, RedirectAttributes rttr) {
		rttr.addFlashAttribute("success", "로그아웃되었습니다.");
		return "redirect:/main/view";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String userList(Model model) {
        List<AccountUserVO> userList = userService.accountUserList();
        model.addAttribute("userList", userList);
        return "account/userList";
    }


	@RequestMapping(value= "userDetail" , method = RequestMethod.GET)
	public void userDetail(AccountUserVO userVO , Model model) {
		//유저정보 상세보기
		model.addAttribute("userInfo" , userService.accountUserRead(userVO));
		model.addAttribute("couponInfo",eventService.readCoupon(userVO.getId()));
	}
	
	@RequestMapping(value = "userDetail2", method = RequestMethod.GET)
	public String userDetail2(@RequestParam("id") String userId, Model model) {
	    // userId를 기준으로 DB에서 사용자 정보를 조회
	    AccountUserVO userInfo = userService.accountUserRead2(userId);
	    
	    // 모델에 사용자 정보를 담아서 JSP에 전달
	    model.addAttribute("userInfo", userInfo);
	    
	    return "account/userDetail2";
	}
	
	
	@RequestMapping(value = "userEdit", method = RequestMethod.GET)
	public String userEdit_view(AccountUserVO userVO, Model model) {
	    // 유저정보 수정폼
	    AccountUserVO userInfo = userService.accountUserRead(userVO);
	    model.addAttribute("userInfo", userInfo);
	    return "account/userEdit";
	}
	@RequestMapping(value = "userEdit2", method = RequestMethod.GET)
	public String userEdit_view2(AccountUserVO userVO, Model model) {
	    // 유저정보 수정폼
	    AccountUserVO userInfo = userService.accountUserRead(userVO);
	    model.addAttribute("userInfo", userInfo);
	    return "account/userEdit2";
	}
	
	
	@RequestMapping(value="userEdit" , method = RequestMethod.POST)
	public String userEdit(AccountUserVO userVO , HttpServletRequest request,RedirectAttributes rttr) {
		//유저정보 수정액션
		String result = "fail";
		if(userService.accountUserUpdate(request, userVO) > 0 ) { result = "회원정보가 변경되었습니다."; }
		rttr.addFlashAttribute("success" , result);
		return "redirect:/account/userList";
	}
	
	@RequestMapping(value = "userEdit2", method = RequestMethod.POST)
	public String userEdit2(AccountUserVO userVO, HttpServletRequest request, RedirectAttributes rttr) {
	    // 유저정보 수정액션
	    String result = "fail";
	    if (userService.accountUserUpdate(request, userVO) > 0) {
	        result = "회원정보가 변경되었습니다.";
	    }
	    rttr.addFlashAttribute("success", result);

	    // 'id' 파라미터를 리다이렉트 시에 전달
	    String id = userVO.getId();
	    return "redirect:/account/userDetail2?id=" + id;
	}
	
	
	@RequestMapping(value="userDelete" , method = RequestMethod.GET)
		//유저 탈퇴 폼
	public String userDelete_view(AccountUserVO userVO, Model model) {
	    AccountUserVO userInfo = userService.accountUserRead(userVO);
	    model.addAttribute("userInfo", userInfo);

		return "account/userDelete"; 
	}
	

	@RequestMapping(value = "userDelete", method = RequestMethod.POST)
	public String userDelete(AccountUserVO userVO, RedirectAttributes rttr , HttpServletRequest request) {
	    String result = "비밀번호를 확인해주세요.";
	    if (userService.accountUserDelete(userVO) > 0) {
	    	 request.getSession().invalidate();
	         result = "회원탈퇴가 정상 처리되었습니다.";
	    }
	    rttr.addFlashAttribute("success", result);
	    return "redirect:/main/view";
	}
	
	
	@RequestMapping(value="/findPass", method=RequestMethod.GET)
	public String findpass() {
		return "account/findPassView";
	}
	
	
	@RequestMapping(value="/findPass", method=RequestMethod.POST)
	public String findpassAct(RedirectAttributes rttr , HttpServletRequest request) {
		String result = "e-mail로 전송된 password로 다시 로그인 해 주세요~";
		String subject = "동네글방에서 비밀번호를 쏴드립니다~";
		String usermail = request.getParameter("email");
		String content = dao.findPass(usermail);

		mail.sendMail(subject, content, usermail);
		rttr.addFlashAttribute("success", result);
		return "redirect:/main/view";
	}

	
	

	//카카오 로그인기능
	@RequestMapping(value="/kakaoToken", method=RequestMethod.GET)
	public String kakaoToken(@RequestParam(value = "code", required = false) String code , HttpServletRequest request , AccountUserVO user , RedirectAttributes rttr) throws Exception {
		System.out.println("코드컨트롤 : " + code);
		String access_Token = userService.kakaoToken(code);
		
		System.out.println("토큰컨트롤 : " + access_Token);
		HashMap<String, Object> kakaoInfo =userService.kakaoInfo(access_Token); 
		// 위에서 만든 코드 아래에 코드 추가
		//HashMap<String, Object> userInfo = userSe);
		System.out.println("###access_Token#### : " + kakaoInfo);
		System.out.println("###nickname#### : " + kakaoInfo.get("nickname"));
		System.out.println("###email#### : " + kakaoInfo.get("email"));
		
		String result = dao.emailfind((String) kakaoInfo.get("email"));
		

		if(result == null) {
			String msg = "이메일로그인에 필요한 추가정보를 기입해 주세요.\\n 첫회에만 적용 됩니다.";
			rttr.addFlashAttribute("success" , msg ); 
			rttr.addFlashAttribute("email" , kakaoInfo.get("email"));
			return "redirect:/account/singUp2";			
		}else {
			request.getSession().setAttribute("kakaoUser", 1);
			request.getSession().setAttribute("account", result);
			request.getSession().setAttribute("role_id", 0);
			return "redirect:/main/view";
			}
		
    	}

	@RequestMapping(value="singUp2" , method = RequestMethod.GET )
	public String singUp2() {
		return "account/singUp2";
	}


	@RequestMapping(value="/kakaoSingUp", method=RequestMethod.GET)
	public String singUp_view2() { return "account/singUp1"; }


	
	
	
	
	
	

	
	

	
	// 여기는 이벤트 페이지에대한 처리
	@RequestMapping(value="userEvent" , method = RequestMethod.GET )
	public String userEvent(
			//AccountUserVO userVO , AccountEventVO eventVO
				//, AccountCouponVO couponVO ,
				RedirectAttributes rttr , @RequestParam String id) {
		//출석체크 리스트
		eventService.accountEventList(id);
		
		//출석체크에대한 구문
		//  String userid - 세션에서 로그인한 값을 참고할 예정
		if(eventService.accountEventCheck(id) == 0) {
			//금일 출석한 기록이 없다면 출석인정. 
			eventService.accountEventDo(id);
		}
		
		//쿠폰지금 조회
		if(eventService.accountEventDays(id) == 20) {
			//만약 출석한 날짜가 20일 이라면 0~19 or 21~30 안됨 꼭 20이여야함 한달에 한번만 줄거니깐
			eventService.couponInsert(id);
		}
		
		return "redirect:/account/userEvent?id=" + id;
	}

}