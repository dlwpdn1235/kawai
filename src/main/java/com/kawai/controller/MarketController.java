package com.kawai.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kawai.dto.MarketDto;
import com.kawai.service.MarketService;

public class MarketController {


	@Autowired
	MarketService service;

	@RequestMapping(value="/Marketlist" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getMarketList(Model model){
		Map<String,Object> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		result.put("data", service.readAll());

		return result;
	}
	
	@RequestMapping(value="/marketInsert" , method=RequestMethod.POST,headers= {"Content-type=application/json"})
	@ResponseBody
	public Map<String,Object> getMarketInsert(@RequestBody MarketDto dto){
		
		if(dto!=null) {
			service.marketInsert(dto);
		}
		Map<String,Object> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		
		return result;
	}
	
	@RequestMapping(value="/marketDelete" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getMarketDelete(int no){
		
		if(no>0) {
			service.delete(no);
		}
		Map<String,Object> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		return result;
	}

}
