package com.kawai.dto;

public class AccountUserVO {
	private String id;
	private String pass;
	private String name;
	private String birth;
	private String email;
	private String phonenum;
	private String postnum;
	private int role_id;
	private String create_date;
	private String create_ip;
	private String picture;
	public AccountUserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountUserVO(String id, String pass, String name, String birth, String email, String phonenum,
			String postnum, int role_id, String create_date, String create_ip, String picture) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.birth = birth;
		this.email = email;
		this.phonenum = phonenum;
		this.postnum = postnum;
		this.role_id = role_id;
		this.create_date = create_date;
		this.create_ip = create_ip;
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "AccountUserDto [id=" + id + ", pass=" + pass + ", name=" + name + ", birth=" + birth + ", email="
				+ email + ", phonenum=" + phonenum + ", postnum=" + postnum + ", role_id=" + role_id + ", create_date="
				+ create_date + ", create_ip=" + create_ip + ", picture=" + picture + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPostnum() {
		return postnum;
	}
	public void setPostnum(String postnum) {
		this.postnum = postnum;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getCreate_ip() {
		return create_ip;
	}
	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}