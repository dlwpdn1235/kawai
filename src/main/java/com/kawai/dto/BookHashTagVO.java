package com.kawai.dto;

public class BookHashTagVO {
	private int tag_id;
	private String tag_name;
	public BookHashTagVO() {
		super();
	}
	public BookHashTagVO(int tag_id, String tag_name) {
		super();
		this.tag_id = tag_id;
		this.tag_name = tag_name;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	@Override
	public String toString() {
		return "BookHashTagVO [tag_id=" + tag_id + ", tag_name=" + tag_name + "]";
	}
	
	
}
