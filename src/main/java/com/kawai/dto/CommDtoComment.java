package com.kawai.dto;

public class CommDtoComment {
	private int comment_id;
	private String comment;
	private String comment_date;
	private int comment_group;
	private int comment_step;
	private int comment_indent;
	private String user_id;
	private String comment_ip;
	private int community_id;
	private int commentLikeCnt;
	public CommDtoComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoComment(int comment_id, String comment, String comment_date, int comment_group, int comment_step,
			int comment_indent, String user_id, String comment_ip, int community_id, int commentLikeCnt) {
		super();
		this.comment_id = comment_id;
		this.comment = comment;
		this.comment_date = comment_date;
		this.comment_group = comment_group;
		this.comment_step = comment_step;
		this.comment_indent = comment_indent;
		this.user_id = user_id;
		this.comment_ip = comment_ip;
		this.community_id = community_id;
		this.commentLikeCnt = commentLikeCnt;
	}
	@Override
	public String toString() {
		return "CommDtoComment [comment_id=" + comment_id + ", comment=" + comment + ", comment_date=" + comment_date
				+ ", comment_group=" + comment_group + ", comment_step=" + comment_step + ", comment_indent="
				+ comment_indent + ", user_id=" + user_id + ", comment_ip=" + comment_ip + ", community_id="
				+ community_id + ", commentLikeCnt=" + commentLikeCnt + "]";
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public int getComment_group() {
		return comment_group;
	}
	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}
	public int getComment_step() {
		return comment_step;
	}
	public void setComment_step(int comment_step) {
		this.comment_step = comment_step;
	}
	public int getComment_indent() {
		return comment_indent;
	}
	public void setComment_indent(int comment_indent) {
		this.comment_indent = comment_indent;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment_ip() {
		return comment_ip;
	}
	public void setComment_ip(String comment_ip) {
		this.comment_ip = comment_ip;
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public int getCommentLikeCnt() {
		return commentLikeCnt;
	}
	public void setCommentLikeCnt(int commentLikeCnt) {
		this.commentLikeCnt = commentLikeCnt;
	}
	
}
