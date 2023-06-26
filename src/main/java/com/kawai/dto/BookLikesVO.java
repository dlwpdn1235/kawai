package com.kawai.dto;

public class BookLikesVO {
	private String fk_id;
	private int fk_bs_no;
	public BookLikesVO() { super(); }
	public BookLikesVO(String fk_id, int fk_bs_no) {
		super();
		this.fk_id = fk_id;
		this.fk_bs_no = fk_bs_no;
	}
	public String getFk_id() {
		return fk_id;
	}
	public void setFk_id(String fk_id) {
		this.fk_id = fk_id;
	}
	public int getFk_bs_no() {
		return fk_bs_no;
	}
	public void setFk_bs_no(int fk_bs_no) {
		this.fk_bs_no = fk_bs_no;
	}
	@Override
	public String toString() {
		return "BookLikesVO [fk_id=" + fk_id + ", fk_bs_no=" + fk_bs_no + "]";
	}
	
	
	
}
