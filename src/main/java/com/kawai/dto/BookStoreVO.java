package com.kawai.dto;



import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookStoreVO {
	private int bs_no;
	private String user_id;  //#
	private String bs_name;
	private String bs_closeday;
	private String bs_phonenum;
	private String bs_postnum;
	private String bs_address;
	private String bs_address_detail;
	private java.sql.Date bs_opendate;
	private String bs_content;
	private Date bs_reg_date;
	private String bs_start_time;
	private String bs_end_time;
	private int[] taglist;
	private String selected_tagname;
	
	private List<String> tagNames;

/* private List<Integer> taglist; */
//	private List<String> hashtags;
}
