package com.kawai.dto;

import java.util.List;

public class MarketPayDto {
	private int mPay_id;
	private int mPayCount;
	private String mPayDate;
	private String user;
	private List<MarketOrderDto> order;
	private List<MarketDto> market;
	public MarketPayDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketPayDto(int mPay_id, int mPayCount, String mPayDate, List<MarketOrderDto> order, String user,
			List<MarketDto> market) {
		super();
		this.mPay_id = mPay_id;
		this.mPayCount = mPayCount;
		this.mPayDate = mPayDate;
		this.order = order;
		this.user = user;
		this.market = market;
	}
	public int getmPay_id() {
		return mPay_id;
	}
	public void setmPay_id(int mPay_id) {
		this.mPay_id = mPay_id;
	}
	public int getmPayCount() {
		return mPayCount;
	}
	public void setmPayCount(int mPayCount) {
		this.mPayCount = mPayCount;
	}
	public String getmPayDate() {
		return mPayDate;
	}
	public void setmPayDate(String mPayDate) {
		this.mPayDate = mPayDate;
	}
	public List<MarketOrderDto> getOrder() {
		return order;
	}
	public void setOrder(List<MarketOrderDto> order) {
		this.order = order;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<MarketDto> getMarket() {
		return market;
	}
	public void setMarket(List<MarketDto> market) {
		this.market = market;
	}
	@Override
	public String toString() {
		return "MarketPayDto [mPay_id=" + mPay_id + ", mPayCount=" + mPayCount + ", mPayDate=" + mPayDate + ", order="
				+ order + ", user=" + user + ", market=" + market + "]";
	}
	
	
	
}
