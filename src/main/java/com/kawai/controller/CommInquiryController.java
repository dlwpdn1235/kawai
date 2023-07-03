package com.kawai.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kawai.dto.CommDtoInquiry;
import com.kawai.service.CommServiceAnswer;
import com.kawai.service.CommServiceInquiry;

@RequestMapping("/inquiry/*")
@Controller
public class CommInquiryController {
	
	@Autowired
	CommServiceInquiry serviceInquiry;
	@Autowired
	CommServiceAnswer serviceAnswer;
	
	@RequestMapping(value = "commInquiry", method = RequestMethod.GET)
	public String commInquiry(Map<String,String> map, Model model) {	
		model.addAttribute("inquiryList",serviceInquiry.commInquiryAllRead(map));
		return "inquiry/myPage";
	}
	@RequestMapping(value = "commInquiryInsert", method = RequestMethod.GET)
	public String commInquiryInsert() {	
		return "inquiry/insertForm";
	}
	@RequestMapping(value = "commInquiryInsert", method = RequestMethod.POST)
	public String commInquiryInsertAction(CommDtoInquiry inquiry, RedirectAttributes rttr) {	
		String result = "fail";
		if(serviceInquiry.commInquiryInsert(inquiry)>0) {result="글쓰기 완료";}
		rttr.addFlashAttribute("success",result);
		return "inquiry/detail";
	}
	@RequestMapping(value = "commInquiryUpdate", method = RequestMethod.GET)
	public String commInquiryUpdate() {	
		return "inquiry/updateForm";
	}
	@RequestMapping(value = "commInquiryUpdate", method = RequestMethod.POST)
	public String commInquiryUpdateAction(CommDtoInquiry inquiry, RedirectAttributes rttr) {	
		String result = "fail";
		if(serviceInquiry.commInquiryInsert(inquiry)>0) {result="문의작성 완료";}
		rttr.addFlashAttribute("success",result);
		return "inquiry/detail";
	}
	
	
}
