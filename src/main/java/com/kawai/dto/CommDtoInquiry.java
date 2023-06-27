package com.kawai.dto;

import lombok.Data;

@Data
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
	public boolean isAnswer() {
		return isAnswer;
	}
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
}
