package com.kawai.dto;

import java.util.List;

public class MarketCart {
	private int mCart_id;
	private int mCount;
	private String mCartDate;
	private List<MarketDto> market;
	private List<AccountUserVO> user;
	public MarketCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketCart(int mCart_id, int mCount, String mCartDate, List<MarketDto> market, List<AccountUserVO> user) {
		super();
		this.mCart_id = mCart_id;
		this.mCount = mCount;
		this.mCartDate = mCartDate;
		this.market = market;
		this.user = user;
	}
	public int getmCart_id() {
		return mCart_id;
	}
	public void setmCart_id(int mCart_id) {
		this.mCart_id = mCart_id;
	}
	public int getmCount() {
		return mCount;
	}
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}
	public String getmCartDate() {
		return mCartDate;
	}
	public void setmCartDate(String mCartDate) {
		this.mCartDate = mCartDate;
	}
	public List<MarketDto> getMarket() {
		return market;
	}
	public void setMarket(List<MarketDto> market) {
		this.market = market;
	}
	public List<AccountUserVO> getUser() {
		return user;
	}
	public void setUser(List<AccountUserVO> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "MarketCart [mCart_id=" + mCart_id + ", mCount=" + mCount + ", mCartDate=" + mCartDate + ", market="
				+ market + ", user=" + user + "]";
	}
	
	
}
