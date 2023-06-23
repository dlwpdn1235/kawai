package com.kawai.dto;

public class MarketDto {
	private int market_id;
	private String mTitle;
	private String mContent;
	private String mIp;
	private int mPrice;
	private String mDate;
	private String user_id;
	private CommDtoBookinfo bookInfo;
	public MarketDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketDto(int market_id, String mTitle, String mContent, String mIp, int mPrice, String mDate,
			String user_id, CommDtoBookinfo bookInfo) {
		super();
		this.market_id = market_id;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mIp = mIp;
		this.mPrice = mPrice;
		this.mDate = mDate;
		this.user_id = user_id;
		this.bookInfo = bookInfo;
	}
	@Override
	public String toString() {
		return "MarketDto [market_id=" + market_id + ", mTitle=" + mTitle + ", mContent=" + mContent + ", mIp=" + mIp
				+ ", mPrice=" + mPrice + ", mDate=" + mDate + ", user_id=" + user_id + ", bookInfo=" + bookInfo + "]";
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public CommDtoBookinfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(CommDtoBookinfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	
}
