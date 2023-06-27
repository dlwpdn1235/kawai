package com.kawai.dto;

import java.util.List;

public class CommDto {
	private int community_id;
	private String community_title;
	private String community_content;
	private int community_hit;
	private String community_ip;
	private String community_date;
	private String user_id;
	private String user_name;
	private CommDtoBookinfo bookinfo;
	private CommDtoCategory commcategory;
	private int communityLikeCnt;
	private List<CommDtoComment> comment;
	public CommDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDto(int community_id, String community_title, String community_content, int community_hit,
			String community_ip, String community_date, String user_id, String user_name, CommDtoBookinfo bookinfo,
			CommDtoCategory commcategory, int communityLikeCnt, List<CommDtoComment> comment) {
		super();
		this.community_id = community_id;
		this.community_title = community_title;
		this.community_content = community_content;
		this.community_hit = community_hit;
		this.community_ip = community_ip;
		this.community_date = community_date;
		this.user_id = user_id;
		this.user_name = user_name;
		this.bookinfo = bookinfo;
		this.commcategory = commcategory;
		this.communityLikeCnt = communityLikeCnt;
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommDto [community_id=" + community_id + ", community_title=" + community_title + ", community_content="
				+ community_content + ", community_hit=" + community_hit + ", community_ip=" + community_ip
				+ ", community_date=" + community_date + ", user_id=" + user_id + ", user_name=" + user_name
				+ ", bookinfo=" + bookinfo + ", commcategory=" + commcategory + ", communityLikeCnt=" + communityLikeCnt
				+ ", comment=" + comment + "]";
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_content() {
		return community_content;
	}
	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}
	public int getCommunity_hit() {
		return community_hit;
	}
	public void setCommunity_hit(int community_hit) {
		this.community_hit = community_hit;
	}
	public String getCommunity_ip() {
		return community_ip;
	}
	public void setCommunity_ip(String community_ip) {
		this.community_ip = community_ip;
	}
	public String getCommunity_date() {
		return community_date;
	}
	public void setCommunity_date(String community_date) {
		this.community_date = community_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public CommDtoBookinfo getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(CommDtoBookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}
	public CommDtoCategory getCommcategory() {
		return commcategory;
	}
	public void setCommcategory(CommDtoCategory commcategory) {
		this.commcategory = commcategory;
	}
	public int getCommunityLikeCnt() {
		return communityLikeCnt;
	}
	public void setCommunityLikeCnt(int communityLikeCnt) {
		this.communityLikeCnt = communityLikeCnt;
	}
	public List<CommDtoComment> getComment() {
		return comment;
	}
	public void setComment(List<CommDtoComment> comment) {
		this.comment = comment;
	}


	
}
