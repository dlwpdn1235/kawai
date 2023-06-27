package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoAnswer {
	private int inquiry_id;
	private String answer;
	private String answer_date;
	private String answer_ip;
	private String user_id;
	private String user_name;
	
}
