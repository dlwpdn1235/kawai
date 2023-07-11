package com.kawai.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawai.dao.MarketDao;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPageDto;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MarketServiceImpl implements MarketService{

	@Autowired
	MarketDao dao;
	
	@Autowired
	CommServiceBookinfo info;

	@Override
	public MarketDto marketRead(int no) {
		MarketDto dto = new MarketDto();
		
		dto.setMarket_id(no);
		
		return dao.marketRead(no);
	}

	@Override
	public List<MarketDto> marketList(MarketPageDto dto) {
		CommDtoBookinfo info = new CommDtoBookinfo();
		info.setBookinfo_id(1);
		
		dto.setMarketSerchKeyWord("���ㅽ��");
		return dao.marketList(dto);
	}


	@Override
	public int marketUpdate(MarketDto dto) {
		int result = dao.marketUpdate(dto);

			return result;
	}


	@Override
	public int marketInsert(MarketDto dto) {
		int bookinfo_id = (int)info.commBookinfoInsert(dto.getBookinfo());
		dto.getBookinfo().setBookinfo_id(bookinfo_id);
		try {
			dto.setMIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.marketInsert(dto);
	}



}
