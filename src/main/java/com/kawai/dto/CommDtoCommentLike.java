package com.kawai.dto;

public class CommDtoCommentLike {
	private int comment_id;
	private String user_id;
	private boolean checkLike;
	public CommDtoCommentLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoCommentLike(int comment_id, String user_id, boolean checkLike) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.checkLike = checkLike;
	}
	@Override
	public String toString() {
		return "CommDtoCommentLike [comment_id=" + comment_id + ", user_id=" + user_id + ", checkLike=" + checkLike
				+ "]";
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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
