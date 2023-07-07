package com.kawai.dao;

import java.util.List;

import com.kawai.dto.CommDtoBookinfo;

public interface MarketSearchDao {
	public List<CommDtoBookinfo> marketSearch(String book_title);
}
