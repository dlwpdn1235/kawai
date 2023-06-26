package com.kawai.dto;

import java.time.LocalDateTime;

public class BookImgVO {
	private int img_no;
	private String img_file_name;
	private LocalDateTime img_reg_date;
	private int bs_no;
	
	public BookImgVO(int img_no, String img_file_name, LocalDateTime img_reg_date, int bs_no) {
		super();
		this.img_no = img_no;
		this.img_file_name = img_file_name;
		this.img_reg_date = img_reg_date;
		this.bs_no = bs_no;
	}
	public int getBs_no() {
		return bs_no;
	}
	public void setBs_no(int bs_no) {
		this.bs_no = bs_no;
	}
	public BookImgVO() {
		super();
	}
	public BookImgVO(int img_no, String img_file_name, LocalDateTime img_reg_date) {
		super();
		this.img_no = img_no;
		this.img_file_name = img_file_name;
		this.img_reg_date = img_reg_date;
	}
	@Override
	public String toString() {
		return "BookImgVO [img_no=" + img_no + ", img_file_name=" + img_file_name + ", img_reg_date=" + img_reg_date
				+ "]";
	}
	public int getImg_no() {
		return img_no;
	}
	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}
	public String getImg_file_name() {
		return img_file_name;
	}
	public void setImg_file_name(String img_file_name) {
		this.img_file_name = img_file_name;
	}
	public LocalDateTime getImg_reg_date() {
		return img_reg_date;
	}
	public void setImg_reg_date(LocalDateTime img_reg_date) {
		this.img_reg_date = img_reg_date;
	}
	
	
	
}
