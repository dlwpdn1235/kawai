package com.kawai.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketPageDto;
import com.kawai.service.CommServiceBookinfo;
import com.kawai.service.MarketService;

@RequestMapping("/market/*")
@Controller
public class MarketController {

	@Autowired
	MarketService service;

	
	@Autowired
	CommServiceBookinfo bookservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "marketview", method = RequestMethod.GET)
	public String market(Model model , MarketPageDto pDto) {
		model.addAttribute("marketlist",service.marketList(pDto));
		return "market/market";
	}

	@RequestMapping(value = "marketDetail", method = RequestMethod.GET)
	public String marketDetail(MarketDto dto, Model model , HttpServletRequest request) {
		model.addAttribute("marketbook",service.marketInsert(dto));
		model.addAttribute("marketDetail",service.marketRead(Integer.parseInt(request.getParameter("market_id"))));
		
		return "market/marketDetail";
	}
	
	@RequestMapping(value = "marketCart", method = RequestMethod.GET)
	public String marketCart(MarketPageDto pDto, Model model , HttpServletRequest request) {
		
		model.addAttribute("marketCart",service.marketList(pDto));

		return "market/marketCart";
	}
	
}
