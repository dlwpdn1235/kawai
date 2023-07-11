package com.kawai.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketCart;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;
import com.kawai.dto.MarketPageDto;
import com.kawai.service.CommServiceBookinfo;
import com.kawai.service.MarketCartService;
import com.kawai.service.MarketProductService;
import com.kawai.service.MarketService;

@RequestMapping("/market/*")
@Controller
public class MarketController {

	@Autowired
	MarketService service;
	
	@Autowired
	MarketCartService cartService;

	
	@Autowired
	CommServiceBookinfo bookservice;
	
	@Autowired
	MarketProductService proService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "marketview", method = RequestMethod.GET)
	public String market( Model model , MarketPageDto pDto , CommDtoBookinfo info ) {

		MarketDto dto = new MarketDto();
		model.addAttribute("marketDto",dto);
		model.addAttribute("marketlist",service.marketList(pDto));
		System.out.println(pDto);
		System.out.println(info);

		pDto.setBookinfo(info);
		return "market/market";
	}
	
	@RequestMapping(value = "marketDetailInsert", method = RequestMethod.GET)
	public String marketDetailInsert(MarketDto dto, Model model , HttpServletRequest request) {
		model.addAttribute("marketbook",service.marketInsert(dto));
		
		return "market/marketDetail";
	}
	
	@RequestMapping(value = "marketDetail", method = RequestMethod.GET)
	public String marketDetail(@RequestParam int market_id , MarketDto dto, CommDtoBookinfo info , Model model , HttpServletRequest request) {
		System.out.println(dto);
		System.out.println(info);
		dto.setUser_id("user001");
		dto.setBookinfo(info);
		MarketDto marketDto = service.marketRead(market_id);
		model.addAttribute("dto", marketDto);
		return "market/marketDetail";
	}
	
	@RequestMapping(value = "marketCart", method = RequestMethod.GET)
	public String marketCart(MarketPageDto pDto,  MarketCart mCartDto, Model model, CommDtoBookinfo info, HttpServletRequest request) {
	    MarketDto dto = new MarketDto();
	    dto.setBookinfo(info);
	    int result = 0 ;
	    model.addAttribute("MarketCount",result);
	    List<MarketCart> marketDto = cartService.marketCartList();
	    model.addAttribute("marketDto", marketDto);
	    model.addAttribute("marketCart", cartService.marketCartList());
	    return "market/marketCart";
	}

	@RequestMapping(value = "marketProductInsert", method = RequestMethod.POST)
	public String marketProductInsert(MarketDto dto, CommDtoBookinfo info , MarketOrderDto oDto, Model model , HttpServletRequest request , RedirectAttributes rttr) throws UnknownHostException {
		System.out.println(dto);
		MarketPageDto pDto = new MarketPageDto();
		dto.setBookinfo(info);
		dto.setUser_id("user001");
		System.out.println(dto);
		System.out.println(info);
		List<MarketDto> marketTest = service.marketList(pDto);
		dto.setMIp(Inet4Address.getLocalHost().getHostAddress());
		model.addAttribute("test",marketTest);
		model.addAttribute("marketProductlist",service.marketInsert(dto));
		model.addAttribute("marketlist",service.marketList(pDto));
		return "market/marketProductAdmin";
	}
	
}
