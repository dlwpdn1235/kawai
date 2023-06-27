package com.kawai.dao;

import java.util.List;

import com.kawai.dto.MarketCart;


public interface MarketCartDao {
	public int marketCartInsert(MarketCart dto);
	public int marketCartUpdate(MarketCart dto);
	public int marketCartDelete(int no);
	public List<MarketCart>marketList();
}
