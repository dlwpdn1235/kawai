package com.kawai.dto;

import java.time.LocalTime;

public class BookStoreVO {
	private int bs_no;
	private String user_id;
	private int tag_id;
	private String bs_name;
	private LocalTime bs_startdate;
	private LocalTime bs_enddate;
	private String bs_closeday;
	private String bs_phonenum;
	private String bs_postnum;
	private String bs_address;
	private String bs_address_detail;
	private String bs_opendate;
	private String bs_content;
	private String bs_reg_date;
	public BookStoreVO() { super(); }
	public BookStoreVO(int bs_no, String user_id, int tag_id, String bs_name, LocalTime bs_startdate,
			LocalTime bs_enddate, String bs_closeday, String bs_phonenum, String bs_postnum, String bs_address,
			String bs_address_detail, String bs_opendate, String bs_content, String bs_reg_date) {
		super();
		this.bs_no = bs_no;
		this.user_id = user_id;
		this.tag_id = tag_id;
		this.bs_name = bs_name;
		this.bs_startdate = bs_startdate;
		this.bs_enddate = bs_enddate;
		this.bs_closeday = bs_closeday;
		this.bs_phonenum = bs_phonenum;
		this.bs_postnum = bs_postnum;
		this.bs_address = bs_address;
		this.bs_address_detail = bs_address_detail;
		this.bs_opendate = bs_opendate;
		this.bs_content = bs_content;
		this.bs_reg_date = bs_reg_date;
	}
	public int getBs_no() {
		return bs_no;
	}
	public void setBs_no(int bs_no) {
		this.bs_no = bs_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getBs_name() {
		return bs_name;
	}
	public void setBs_name(String bs_name) {
		this.bs_name = bs_name;
	}
	public LocalTime getBs_startdate() {
		return bs_startdate;
	}
	public void setBs_startdate(LocalTime bs_startdate) {
		this.bs_startdate = bs_startdate;
	}
	public LocalTime getBs_enddate() {
		return bs_enddate;
	}
	public void setBs_enddate(LocalTime bs_enddate) {
		this.bs_enddate = bs_enddate;
	}
	public String getBs_closeday() {
		return bs_closeday;
	}
	public void setBs_closeday(String bs_closeday) {
		this.bs_closeday = bs_closeday;
	}
	public String getBs_phonenum() {
		return bs_phonenum;
	}
	public void setBs_phonenum(String bs_phonenum) {
		this.bs_phonenum = bs_phonenum;
	}
	public String getBs_postnum() {
		return bs_postnum;
	}
	public void setBs_postnum(String bs_postnum) {
		this.bs_postnum = bs_postnum;
	}
	public String getBs_address() {
		return bs_address;
	}
	public void setBs_address(String bs_address) {
		this.bs_address = bs_address;
	}
	public String getBs_address_detail() {
		return bs_address_detail;
	}
	public void setBs_address_detail(String bs_address_detail) {
		this.bs_address_detail = bs_address_detail;
	}
	public String getBs_opendate() {
		return bs_opendate;
	}
	public void setBs_opendate(String bs_opendate) {
		this.bs_opendate = bs_opendate;
	}
	public String getBs_content() {
		return bs_content;
	}
	public void setBs_content(String bs_content) {
		this.bs_content = bs_content;
	}
	public String getBs_reg_date() {
		return bs_reg_date;
	}
	public void setBs_reg_date(String bs_reg_date) {
		this.bs_reg_date = bs_reg_date;
	}
	@Override
	public String toString() {
		return "BookStoreVO [bs_no=" + bs_no + ", user_id=" + user_id + ", tag_id=" + tag_id + ", bs_name=" + bs_name
				+ ", bs_startdate=" + bs_startdate + ", bs_enddate=" + bs_enddate + ", bs_closeday=" + bs_closeday
				+ ", bs_phonenum=" + bs_phonenum + ", bs_postnum=" + bs_postnum + ", bs_address=" + bs_address
				+ ", bs_address_detail=" + bs_address_detail + ", bs_opendate=" + bs_opendate + ", bs_content="
				+ bs_content + ", bs_reg_date=" + bs_reg_date + "]";
	}
	
	
	
	
}
