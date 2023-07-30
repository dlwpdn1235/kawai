package com.kawai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoSearch;
import com.kawai.service.CommService;

@RequestMapping("/main/*")
@Controller
public class MainController {
	
	@Autowired
	CommService commService;

	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String home1(Model model) {
		CommDtoSearch search = new CommDtoSearch();
		search.setCategory_id(1);
		search.setCondition(0);
		search.setDay(0);
		search.setSearchKeyword("");
		search.setSearchType(1);
		search.setCount(0);
		search.setCommunity_hide(1);
		List<CommDto> commList = commService.commCommunityAllRead(search);
		model.addAttribute("commList",commList);
		return "main";
	}

}
