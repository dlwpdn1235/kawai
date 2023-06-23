package com.kawai.dto;

public class CommDtoAnswer {
	private int inquiry_id;
	private String answer;
	private String answer_date;
	private int user_id;
	private int user_name;
	public CommDtoAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoAnswer(int inquiry_id, String answer, String answer_date, int user_id, int user_name) {
		super();
		this.inquiry_id = inquiry_id;
		this.answer = answer;
		this.answer_date = answer_date;
		this.user_id = user_id;
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "CommDtoAnswer [inquiry_id=" + inquiry_id + ", answer=" + answer + ", answer_date=" + answer_date
				+ ", user_id=" + user_id + ", user_name=" + user_name + "]";
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_name() {
		return user_name;
	}
	public void setUser_name(int user_name) {
		this.user_name = user_name;
	}
	
}
