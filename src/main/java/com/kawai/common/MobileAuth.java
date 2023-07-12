package com.kawai.common;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Component
public class MobileAuth {
	
	public String phoneNumberCheck(String to) throws CoolsmsException {
		String result = "";
		String api_key = "NCSLVSDS5TX2NSR7";
		String api_secret = "9R3BSQCXSNYZTTVOYVFPIY6UHL6B4VE0";
		Message message = new Message(api_key, api_secret);
		HashMap<String, String> params = new HashMap<String, String>();
		
		Random rand = new Random();
		for(int i=0; i<6; i++) {
			result += Integer.toString(rand.nextInt(10));
		}
		
	
		
		params.put("to", to);						// 수신자 - ajax로 view화면에서 받아온값
	    params.put("from", "01035189041");						// 발신자 - 02,031,050
	    params.put("type", "SMS");								// 타입
	    params.put("text", "인증번호 [ " + result + " ] 입니다.");	// 내용
		
	    
	    message.send(params);
		return result;
	}
}
