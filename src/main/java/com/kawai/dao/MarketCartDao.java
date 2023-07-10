package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketCart;

public interface MarketCartDao {
	public int marketCartInsert(MarketCart cdto);
	public int marketCartUpdate(MarketCart cdto);
	public int marketCartDelete(int no);
	public List<MarketCart>marketCartList();
	public MarketCart marketCartRead(int no);
	public int marketCartCountUpdate(MarketCart cdto);
}
