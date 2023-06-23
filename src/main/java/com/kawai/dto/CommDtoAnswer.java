package com.kawai.dto;

public class CommDtoAnswer {
	private int inquiry_id;
	private String answer;
	private String answer_date;
	private String answer_ip;
	private String user_id;
	private String user_name;
	public CommDtoAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoAnswer(int inquiry_id, String answer, String answer_date, String answer_ip, String user_id,
			String user_name) {
		super();
		this.inquiry_id = inquiry_id;
		this.answer = answer;
		this.answer_date = answer_date;
		this.answer_ip = answer_ip;
		this.user_id = user_id;
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "CommDtoAnswer [inquiry_id=" + inquiry_id + ", answer=" + answer + ", answer_date=" + answer_date
				+ ", answer_ip=" + answer_ip + ", user_id=" + user_id + ", user_name=" + user_name + "]";
	}
	public int getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	public String getAnswer_ip() {
		return answer_ip;
	}
	public void setAnswer_ip(String answer_ip) {
		this.answer_ip = answer_ip;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
}
