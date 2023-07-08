package com.kawai.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kawai.common.UserCalendar;
import com.kawai.service.AccountEventService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UserCalendarController {
	@Autowired UserCalendar mycalc;
	@Autowired AccountEventService event;
	
	@RequestMapping(value="/myCalendar_go" , method=RequestMethod.GET)
	public String myCalendar_go() {
		
		return "account/userEvent";
	}
	
	@RequestMapping(value="/myCalendar" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> myCalendar(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		log.info("......... myCalendar");
		mycalc = new UserCalendar();
		mycalc.calc_settings();
		/*
		 * mycalc.calc_settings();
		 *  event.accountEventCheck((String)request.getSession().getAttribute("account"));
		 */
		result.put("mycalc", mycalc);
		result.put("accountEventList", event.accountEventList((String)request.getSession().getAttribute("account")) );
		/* return mycalc; */	
		return result;	
	}
}