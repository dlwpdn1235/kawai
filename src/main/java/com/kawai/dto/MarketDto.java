package com.kawai.dto;

import java.util.List;

public class MarketDto {
	private int market_id;
	private String mTitle;
	private String mContent;
	private String mIp;
	private int mPrice;
	private String mDate;
	private List<UserDto> user;
	private List<CommDtoBookinfo> bookInfo;
	public MarketDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketDto(int market_id, String mTitle, String mContent, String mIp, int mPrice, String mDate,
			List<UserDto> user, List<CommDtoBookinfo> bookInfo) {
		super();
		this.market_id = market_id;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mIp = mIp;
		this.mPrice = mPrice;
		this.mDate = mDate;
		this.user = user;
		this.bookInfo = bookInfo;
	}
	public int getMarket_id() {
		return market_id;
	}
	public void setMarket_id(int market_id) {
		this.market_id = market_id;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getmIp() {
		return mIp;
	}
	public void setmIp(String mIp) {
		this.mIp = mIp;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public List<UserDto> getUser() {
		return user;
	}
	
	public void setUser(List<UserDto> user) {
		this.user = user;
	}
	public List<CommDtoBookinfo> getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(List<CommDtoBookinfo> bookInfo) {
		this.bookInfo = bookInfo;
	}
	@Override
	public String toString() {
		return "MarketDto [market_id=" + market_id + ", mTitle=" + mTitle + ", mContent=" + mContent + ", mIp=" + mIp
				+ ", mPrice=" + mPrice + ", mDate=" + mDate + ", user=" + user + ", bookInfo=" + bookInfo + "]";
	}
	
}
