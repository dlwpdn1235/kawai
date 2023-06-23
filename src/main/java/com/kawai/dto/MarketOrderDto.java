package com.kawai.dto;

import java.util.List;

public class MarketOrderDto {
	private int mOrder_id;
	private String mRecIp;
	private String mRecDate;
	private int RecPrice;
	private String mRecContent;
	private String mRecAddress;
	private String user;
	private List<MarketDto> market;
	public MarketOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketOrderDto(int mOrder_id, String mRecIp, String mRecDate, int recPrice, String mRecContent,
			String mRecAddress, String user, List<MarketDto> market) {
		super();
		this.mOrder_id = mOrder_id;
		this.mRecIp = mRecIp;
		this.mRecDate = mRecDate;
		RecPrice = recPrice;
		this.mRecContent = mRecContent;
		this.mRecAddress = mRecAddress;
		this.user = user;
		this.market = market;
	}
	public int getmOrder_id() {
		return mOrder_id;
	}
	public void setmOrder_id(int mOrder_id) {
		this.mOrder_id = mOrder_id;
	}
	public String getmRecIp() {
		return mRecIp;
	}
	public void setmRecIp(String mRecIp) {
		this.mRecIp = mRecIp;
	}
	public String getmRecDate() {
		return mRecDate;
	}
	public void setmRecDate(String mRecDate) {
		this.mRecDate = mRecDate;
	}
	public int getRecPrice() {
		return RecPrice;
	}
	public void setRecPrice(int recPrice) {
		RecPrice = recPrice;
	}
	public String getmRecContent() {
		return mRecContent;
	}
	public void setmRecContent(String mRecContent) {
		this.mRecContent = mRecContent;
	}
	public String getmRecAddress() {
		return mRecAddress;
	}
	public void setmRecAddress(String mRecAddress) {
		this.mRecAddress = mRecAddress;
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
		return "MarketOrderDto [mOrder_id=" + mOrder_id + ", mRecIp=" + mRecIp + ", mRecDate=" + mRecDate
				+ ", RecPrice=" + RecPrice + ", mRecContent=" + mRecContent + ", mRecAddress=" + mRecAddress + ", user="
				+ user + ", market=" + market + "]";
	}
	
	
	
}
