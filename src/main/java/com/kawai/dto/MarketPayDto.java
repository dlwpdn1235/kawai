package com.kawai.dto;

import java.util.List;

import lombok.Data;

@Data
public class MarketPayDto {
	private int mPay_id;
	private int mPayCount;
	private String mPayDate;
	private String user_id;
	private int market_id;
	private int mOrder_id;
	private List<MarketOrderDto> mOrder;
	private List<MarketDto> market;

}
