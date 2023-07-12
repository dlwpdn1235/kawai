package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketCart;

public interface MarketCartDao {
	public int marketCartInsert(MarketCart cdto);
	public int marketCartUpdate(MarketCart cdto);
	public int marketCartDelete(MarketCart cdto);
	public List<MarketCart>marketCartList(String user_id);
	public int marketCartCountUpdate(MarketCart cdto);
}
