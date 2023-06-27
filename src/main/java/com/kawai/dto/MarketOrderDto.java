package com.kawai.dto;

import lombok.Data;

@Data
public class MarketOrderDto {
	private int mOrder_id;
	private String mRecIp;
	private String mRecDate;
	private String mRecContent;
	private int mRecPrice;
	private String mRecAddress;
	private String user_id;
	private int market_id;

}
