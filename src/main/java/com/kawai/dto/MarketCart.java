package com.kawai.dto;

import java.util.List;

import lombok.Data;

@Data
public class MarketCart {
	private int mCart_id;
	private int mCount;
	private String mCartDate;
	private int market_id;
	private String user_id;
	private List<CommDtoBookinfo> bookinfo;
}
