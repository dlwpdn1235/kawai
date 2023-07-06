package com.kawai.dto;

import lombok.Data;

@Data
public class BookStoreVO {
//	private List<String> hashtags;
	private int bs_no;
	private String user_id;  //#
	private int tag_id;
	private String bs_name;
	private java.sql.Time bs_start_date;
	private java.sql.Time bs_end_date;
	private String bs_closeday;
	private String bs_phonenum;
	private String bs_postnum;
	private String bs_address;
	private String bs_address_detail;
	
	private java.sql.Date bs_opendate;
	
	private String bs_content;
	private String bs_reg_date;
	
	/* private List<Integer> taglist; */
	private int[] taglist; 


    
}
