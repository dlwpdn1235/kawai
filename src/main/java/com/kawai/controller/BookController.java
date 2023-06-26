package com.kawai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kawai.dto.BookStoreVO;
import com.kawai.service.BookStoreService;

public class BookController {
//	  @Autowired
//	    private BookStoreService bookstoreService;
//	    
//	    @RequestMapping(value = "/search", method = RequestMethod.GET)
//	    public String search(@RequestParam("searchtype") String searchtype,
//	                         @RequestParam("keyword") String keyword, Model model) {
//	        List<BookStoreVO> bList = bookstoreService.search(searchtype, keyword);
//	        model.addAttribute("bList", bList);
//	        
//	        return "main";  // 수정된 뷰 페이지 경로
//	    }
	
	@Autowired
	private BookStoreService bookstoreService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(@RequestParam("searchtype") String searchtype,
	                     @RequestParam("keyword") String keyword, Model model) {
	    List<BookStoreVO> bList = bookstoreService.search(searchtype, keyword);
	    int totalCount = bookstoreService.getSearchTotalCount(searchtype, keyword);
	    
	    model.addAttribute("blist", bList);
	    model.addAttribute("totalCount", totalCount);
	    
	    return "main";
	}
}
