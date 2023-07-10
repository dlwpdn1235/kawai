package com.kawai.service;

import java.util.List;

import com.kawai.dto.MarketCart;

public interface MarketCareerService {
	public int marketCareerInsert (MarketCart cdto);
	public int marketCareerDelete(int no);
	public int marketCareerUpdate(MarketCart cdto);
	public List<MarketCart>marketCareerList(MarketCart cdto);
}
