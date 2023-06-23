package com.kawai.dto;

public class CommDtoInquiry {
	private int inquiry_id;
	private String inquiry_title;
	private String inquiry_content;
	private String inquiry_date;
	private String inquiry_ip;
	private String user_id;
	private String user_name;
	private String user_eamil;
	private int market_id;
	private String market_title;
	private int inquiry_category_id;
	private String inquiry_category;
	private CommDtoAnswer answer;
	private boolean isAnswer;
	public CommDtoInquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoInquiry(int inquiry_id, String inquiry_title, String inquiry_content, String inquiry_date,
			String inquiry_ip, String user_id, String user_name, String user_eamil, int market_id, String market_title,
			int inquiry_category_id, String inquiry_category, CommDtoAnswer answer, boolean isAnswer) {
		super();
		this.inquiry_id = inquiry_id;
		this.inquiry_title = inquiry_title;
		this.inquiry_content = inquiry_content;
		this.inquiry_date = inquiry_date;
		this.inquiry_ip = inquiry_ip;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_eamil = user_eamil;
		this.market_id = market_id;
		this.market_title = market_title;
		this.inquiry_category_id = inquiry_category_id;
		this.inquiry_category = inquiry_category;
		this.answer = answer;
		this.isAnswer = isAnswer;
	}
	@Override
	public String toString() {
		return "CommDtoInquiry [inquiry_id=" + inquiry_id + ", inquiry_title=" + inquiry_title + ", inquiry_content="
				+ inquiry_content + ", inquiry_date=" + inquiry_date + ", inquiry_ip=" + inquiry_ip + ", user_id="
				+ user_id + ", user_name=" + user_name + ", user_eamil=" + user_eamil + ", market_id=" + market_id
				+ ", market_title=" + market_title + ", inquiry_category_id=" + inquiry_category_id
				+ ", inquiry_category=" + inquiry_category + ", answer=" + answer + ", isAnswer=" + isAnswer + "]";
	}
	public int getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getInquiry_title() {
		return inquiry_title;
	}
	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}
	public String getInquiry_content() {
		return inquiry_content;
	}
	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}
	public String getInquiry_date() {
		return inquiry_date;
	}
	public void setInquiry_date(String inquiry_date) {
		this.inquiry_date = inquiry_date;
	}
	public String getInquiry_ip() {
		return inquiry_ip;
	}
	public void setInquiry_ip(String inquiry_ip) {
		this.inquiry_ip = inquiry_ip;
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
	public String getUser_eamil() {
		return user_eamil;
	}
	public void setUser_eamil(String user_eamil) {
		this.user_eamil = user_eamil;
	}
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}
	public String getMarket_title() {
		return market_title;
	}
	public void setMarket_title(String market_title) {
		this.market_title = market_title;
	}
	public int getInquiry_category_id() {
		return inquiry_category_id;
	}
	public void setInquiry_category_id(int inquiry_category_id) {
		this.inquiry_category_id = inquiry_category_id;
	}
	public String getInquiry_category() {
		return inquiry_category;
	}
	public void setInquiry_category(String inquiry_category) {
		this.inquiry_category = inquiry_category;
	}
	public CommDtoAnswer getAnswer() {
		return answer;
	}
	public void setAnswer(CommDtoAnswer answer) {
		this.answer = answer;
	}
	public boolean isAnswer() {
		return isAnswer;
	}
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	

}
