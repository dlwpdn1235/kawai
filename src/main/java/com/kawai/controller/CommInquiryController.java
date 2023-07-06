package com.kawai.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kawai.dto.CommDtoAnswer;
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
		return "redirect:/inquiry/myPage";
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
		return "redirect:/inquiry/myPage";
	}
	@RequestMapping(value="commInquiryDelete", method=RequestMethod.GET)
	public String commInquiryDelete(int inquiry_id, RedirectAttributes rttr) {
		String result = "fail";
		if(serviceInquiry.commInquiryDelete(inquiry_id)>0) {result="문의삭제 완료";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/inquiry/myPage";
	}
	@RequestMapping(value="commInquiryRead", method=RequestMethod.GET)
	public String commInquiryRead(int inquiry_id, Model model) {
		model.addAttribute("inquiryRead",serviceInquiry.commInquiryDelete(inquiry_id));
		return "inquiry/detail";
	}
	@RequestMapping(value = "commAnswerInsert", method = RequestMethod.POST)
	public String commAnswerAction(CommDtoAnswer answer,Model model ,RedirectAttributes rttr) {	
		String result = "fail";
		if(serviceAnswer.commAnswerInsert(answer)>0) {result="답변 완료";}
		model.addAttribute("inquiryRead", serviceInquiry.commInquiryRead(answer.getInquiry_id()));
		rttr.addFlashAttribute("success",result);
		return "redirect:/inquiry/detail";
	}
	
}
