package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketCart;

public interface MarketCartService {
	public int marketCartInsert(MarketCart dto);
	public int marketCartUpdate(MarketCart dto);
	public int marketCartDelete(MarketCart dto);
	public List<MarketCart>marketCartList(String user_id);
	public int marketCartCount(int no);
}
