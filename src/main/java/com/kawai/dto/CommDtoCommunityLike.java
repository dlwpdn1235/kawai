package com.kawai.dto;

public class CommDtoCommunityLike {
	private int community_id;
	private String user_id;
	private boolean checkLike;
	public CommDtoCommunityLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoCommunityLike(int community_id, String user_id, boolean checkLike) {
		super();
		this.community_id = community_id;
		this.user_id = user_id;
		this.checkLike = checkLike;
	}
	@Override
	public String toString() {
		return "CommDtoLike [community_id=" + community_id + ", user_id=" + user_id + ", checkLike=" + checkLike + "]";
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isCheckLike() {
		return checkLike;
	}
	public void setCheckLike(boolean checkLike) {
		this.checkLike = checkLike;
	}
	
}
