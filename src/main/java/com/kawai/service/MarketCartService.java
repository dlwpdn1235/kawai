package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketCart;

public interface MarketCartService {
	public int marketCartInsert(MarketCart cdto);
	public int marketCartUpdate(MarketCart cdto);
	public int marketCartDelete(int no);
	public MarketCart marketCartRead(int no);
	public List<MarketCart>marketCartList();
}
