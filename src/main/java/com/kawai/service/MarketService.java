package com.kawai.service;

import java.util.List;

import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPayDto;

public interface MarketService {
		public int marketInsert(MarketDto dto);
		public int marketUpdate(MarketDto dto);
		public int marketCount(MarketPayDto dto);
		public int delete(int no);
		public MarketDto read(int no);
		public List<MarketDto> readAll();
		public List<CommDtoBookinfo> bookinfo();
}
