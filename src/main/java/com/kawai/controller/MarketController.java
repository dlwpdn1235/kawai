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
import com.kawai.service.MarketCartService;
import com.kawai.service.MarketOrderService;
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
	MarketOrderService oservice;

	@RequestMapping(value = "marketview", method = RequestMethod.GET)
	public String market( Model model , MarketPageDto pDto) {
		
		model.addAttribute("marketlist",service.marketList(pDto));
		return "market/market";
	}
	
	@RequestMapping(value = "marketDetail", method = RequestMethod.GET)
	public String marketDetail(@RequestParam int market_id , Model model , HttpServletRequest request) {
		MarketDto marketDto = service.marketRead(market_id);
		model.addAttribute("market", marketDto);
		return "market/marketDetail";
	}
	
	@RequestMapping(value = "marketCartInsert", method = RequestMethod.GET)
	public String marketCartInsert(@RequestParam int market_id , Model model, HttpServletRequest request) {
		MarketCart mCart = new MarketCart();
		mCart.setMarket_id(market_id);
		System.out.println((String)request.getSession().getAttribute("account"));
		mCart.setUser_id((String)request.getSession().getAttribute("account"));
		cartService.marketCartInsert(mCart);
	    return "redirect:/market/marketCartList?user_id="+mCart.getUser_id();
	}
	
	@RequestMapping(value = "marketCartList", method = RequestMethod.GET)
	public String marketCartList(@RequestParam String user_id , Model model) {
		List<MarketCart> mCart = cartService.marketCartList(user_id);
		int total = 0;

		for(MarketCart c : mCart) {
			total += c.getMarket().getMPrice();
		}
		System.out.println(mCart);
		model.addAttribute("cartlist",mCart);
		model.addAttribute("totalPrice",total);		
		return "/market/marketCart";
	}
	
	


	@RequestMapping(value = "marketProductInsert", method = RequestMethod.POST)
	public String marketProductInsert(MarketDto dto, CommDtoBookinfo info , Model model , HttpServletRequest request , RedirectAttributes rttr) throws UnknownHostException {


		dto.setBookinfo(info);
		dto.setMarket_id(1);
		dto.setUser_id((String)request.getSession().getAttribute("account"));
		dto.setMIp(Inet4Address.getLocalHost().getHostAddress());
		model.addAttribute("marketlist",service.marketInsert(dto));


		return "redirect:/market/marketview";
	}
	
	@RequestMapping(value = "mOrder", method = RequestMethod.POST)
	public String mOrder(@RequestParam int market_id , MarketDto dto) throws UnknownHostException {
		
		

		return "redirect:/market/marketview";
	}
	
	@RequestMapping(value = "marketList", method = RequestMethod.GET)
	public String marketList(Model model) throws UnknownHostException {
		MarketPageDto pdto = new MarketPageDto();
		model.addAttribute("list",service.marketList(pdto));



		return "/market/marketProductAdmin";
	}
	
	@RequestMapping(value = "marketProductWriteUpdate", method = RequestMethod.GET)
	public String marketProductWriteUpdate(@RequestParam int market_id , Model model) throws UnknownHostException {
		MarketDto dto =service.marketRead(market_id);
		model.addAttribute("market",dto);
		return "/market/marketProductWriteUpdate";
	}
	@RequestMapping(value = "marketProductWriteUpdate", method = RequestMethod.POST)
	public String marketProductWriteUpdateAction(MarketDto dto ,CommDtoBookinfo info , Model model) throws UnknownHostException {
		dto.setBookinfo(info);
		service.marketUpdate(dto);
		MarketCart cdto = new MarketCart();
		model.addAttribute("detail" , cdto);
		return "redirect:/market/marketDetail?market_id=" + dto.getMarket_id();
	}
	@RequestMapping(value = "marketProductDelete", method = RequestMethod.GET)
	public String marketProductWriteDelete(@RequestParam int market_id) throws UnknownHostException {
		service.marketDelete(market_id);
		
		return "redirect:/market/marketList";
	}
	
	@RequestMapping(value = "marketCartDelete", method = RequestMethod.GET)
	public String marketCartDelete(@RequestParam int MCart_id , @RequestParam String user_id) throws UnknownHostException {
		MarketCart dto = new MarketCart();
		dto.setMCart_id(MCart_id);
		dto.setUser_id(user_id);
		cartService.marketCartDelete(dto);
		
		return "redirect:/market/marketCartList?user_id="+dto.getUser_id();
	}
	
//	@RequestMapping(value = "marketOrder", method = RequestMethod.GET)
//	public String marketOrder(@RequestParam int MCart_id , @RequestParam String user_id) throws UnknownHostException {
//		
//		return "";
//	}
	
}
