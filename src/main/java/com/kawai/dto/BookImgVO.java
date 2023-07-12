package com.kawai.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookImgVO {
	private int img_no;
	private String img_file_name;
	private String img_reg_date;
	
	
	private int bs_no;
	
}
