package com.kawai.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class FindPassMail {
	private String subject, content;
	public void sendMail(String subject , String content , String usermail ) {
		//#1. 보내는 사람
		String host     		= "smtp.naver.com";
		final String user 		= "kimwonsu007@naver.com";
		final String password 	= "rla0629!@#";
		
		//#2. 받는사람

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
    
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.naver.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getDefaultInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
        	
        });
        try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user)); //보내는 사람
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(usermail)); //받는 사람
        
        message.setSubject(subject); // 메일 제목
        message.setContent(
        		"<div style='border-radius:20px; background-color:aliceblue; padding:10px'>"
        		+ "<h3> 귀하의 비밀번호입니다. 잘 챙기세요 좀  ㅡㅡ .</h3>"
        		+ 		content
        		+ "</div>"
        		,"text/html; charset=euc-kr"); //## 메일내용
        
        		Transport.send(message);
        		System.out.println("......successfully......");
        
        }catch(Exception e) { e.printStackTrace(); }
        
        
	}
}
