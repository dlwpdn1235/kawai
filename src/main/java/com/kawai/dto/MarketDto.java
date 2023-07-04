package com.kawai.dto;

import lombok.Data;

@Data
public class MarketDto {
	private int market_id;
	private String mTitle;
	private String mContent;
	private String mIp;
	private int mPrice;
	private String mDate;
	private String user_id;
	private CommDtoBookinfo bookInfo;
}
