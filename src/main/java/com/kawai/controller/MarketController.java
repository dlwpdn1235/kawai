package com.kawai.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.kawai.dto.MarketPageDto;
import com.kawai.service.CommServiceBookinfo;
import com.kawai.service.MarketCareerService;
import com.kawai.service.MarketCartService;
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
	MarketCareerService caService;


	@RequestMapping(value = "marketview", method = RequestMethod.GET)
	public String market( Model model , MarketPageDto pDto) {
		
		model.addAttribute("marketlist",service.marketList(pDto));
		return "market/market";
	}
	
	@RequestMapping(value = "marketDetail", method = RequestMethod.GET)
	public String marketDetail(@RequestParam int market_id , Model model , HttpServletRequest request) {
		MarketDto marketDto = service.marketRead(market_id);
		model.addAttribute("market", marketDto);
		System.out.println(marketDto);
		return "market/marketDetail";
	}
	
	@RequestMapping(value = "marketCart", method = RequestMethod.POST)
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
	public String marketProductInsert(MarketDto dto, CommDtoBookinfo info , Model model , HttpServletRequest request , RedirectAttributes rttr) throws UnknownHostException {

		dto.setBookinfo(info);
		dto.setMarket_id(1);
		dto.setUser_id("user001");
		dto.setMIp(Inet4Address.getLocalHost().getHostAddress());
		model.addAttribute("marketlist",service.marketInsert(dto));

		return "redirect:/market/marketview";
	}
	
	@RequestMapping(value = "marketCareer", method = RequestMethod.POST)
	public String marketCareer(@RequestParam int market_id , MarketDto dto , Model model) throws UnknownHostException {
		MarketCart cdto = new MarketCart();
		cdto.setUser_id("user001");
		System.out.println(cdto);
		model.addAttribute("list",caService.marketCareerInsert(cdto));
		
		return "redirect:/market/marketCart?user_id=${user_id}";
	}
	
}
