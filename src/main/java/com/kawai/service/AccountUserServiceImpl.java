package com.kawai.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.*;
import com.kawai.dao.AccountUserDao;
import com.kawai.dto.AccountUserVO;

import lombok.extern.log4j.Log4j;
@Log4j
@Service("accountUserService")
public class AccountUserServiceImpl implements AccountUserService {
	@Autowired AccountUserDao dao;

	@Override
	public int accountUserInsert(HttpServletRequest request , AccountUserVO user) {
		//회원가입 서비스
		String basic_adress = request.getParameter("basic_addr");
		user.setAddress(basic_adress + " " +user.getAddress());
		try {
			user.setCreate_ip(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception e) { e.printStackTrace(); }
		return dao.accountUserInsert(user); 
	}
	
	@Override
	public Map<String, String> accountIdCheck(@RequestParam String id) {
		//ID 중복체크
		Map<String,String> result = new HashMap<>();
		if(dao.accountIdCheck(id) > 0) {
			//이미 있는경우
			result.put("check","false");
			result.put("color", "red");
			result.put("msg" , "중복된 아이디입니다.");
		}else{
			result.put("check","true");
			result.put("color","blue");
			result.put("msg", "사용가능한 ID입니다.");
		}
		return result;
	}

	//회원가입 - 아이디 중복체크 - Map "check":"true"/"false", "color":"color", "msg":"message"

	@Override
	public AccountUserVO accountLogin(HttpServletRequest request , AccountUserVO user) {
		//로그인 서비스
		
		if((user = dao.accountLogin(user))!=null) { //로그인이 되었다면
			request.getSession().setAttribute("account", user.getId());
			request.getSession().setAttribute("role_id", user.getRole_id());
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

	@Override //수정
	public int accountUserUpdate(HttpServletRequest request, AccountUserVO user) {
	    String id = request.getParameter("id");
	    String name = request.getParameter("name");
	    String birth = request.getParameter("birth");
	    String email = request.getParameter("email");
	    String phonenum = request.getParameter("phonenum");
	    String postnum = request.getParameter("postnum");
	    String address = request.getParameter("address");
	    
	    user.setId(id);
	    user.setName(name);
	    user.setBirth(birth);
	    user.setEmail(email);
	    user.setPhonenum(phonenum);
	    user.setPostnum(postnum);
	    user.setAddress(address);
	    
	    return dao.accountUserUpdate(user);
	}

	@Override //탈퇴
	public int accountUserDelete(AccountUserVO user) {
		//회원 탈퇴
		return dao.accountUserDelete(user);
	}

	@Override //리드2
	public AccountUserVO accountUserRead2(String userId) {
		return dao.accountUserRead2(userId);
	}

	@Override
	public String kakaoToken(String authorize_code) {
			String access_Token = "";
			String refresh_Token = "";
			String reqURL = "https://kauth.kakao.com/oauth/token";

			try {
				URL url = new URL(reqURL);
	            
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
	            
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
	            
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type=authorization_code");
	            
				sb.append("&client_id=5b0f67c0f0c2554251291f96f710c67d"); //본인이 발급받은 key
				sb.append("&redirect_uri=http://3.34.129.104:8080/kawaiProject/account/kakaoToken"); // 본인이 설정한 주소
				

				sb.append("&code=" + authorize_code);
				bw.write(sb.toString());
				bw.flush();
	            
				// 결과 코드가 200이라면 성공
				int responseCode = conn.getResponseCode();
				System.out.println("#######responseCode : " + responseCode);
	            
				// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				String result = "";
	            
				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("#######response body : " + result);
	            
				// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
				Gson gson = new Gson();
				JsonElement element = gson.fromJson(result, JsonElement.class);
	            
				access_Token = element.getAsJsonObject().get("access_token").getAsString();
				refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
	            
				System.out.println("#######access_token : " + access_Token);
				System.out.println("#######refresh_token : " + refresh_Token);
	            
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return access_Token;
		}

	@Override
	public HashMap<String, Object> kakaoInfo(String access_Token) {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> kakaoInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			
			Gson gson = new Gson();
			JsonElement element = gson.fromJson(result, JsonElement.class);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();

			kakaoInfo.put("nickname", nickname);
			kakaoInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return kakaoInfo;
	}

	
	
	
	
	@Override  
	public void kakaoLogOut() {
		String reqURL = "https://kauth.kakao.com/oauth/logout?client_id=5b0f67c0f0c2554251291f96f710c67d&logout_redirect_uri=http://localhost:8080/kawai/account/logout"; 
		try {			
			URL url = new URL(reqURL);
			log.info("logOut"+1);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();       
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			log.info("logOut"+2);

		} catch (IOException e) { e.printStackTrace(); }
		log.info("logOut"+3);
	}
}