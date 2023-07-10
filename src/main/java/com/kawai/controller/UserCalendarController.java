package com.kawai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	@Autowired
	UserCalendar mycalc;
	@Autowired
	AccountEventService event;

	@RequestMapping(value = "/myCalendar_go", method = RequestMethod.GET)
	public String myCalendar_go() {

		return "account/userEvent";
	}

	
	
	@RequestMapping(value="/myCalendar", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> myCalendar(HttpServletRequest request) {
	    Map<String, Object> result = new HashMap<>();
	    log.info("......... myCalendar");
	    mycalc = new UserCalendar();
	    mycalc.calc_settings();
	    
	    // 이벤트 리스트를 가져와서 result 맵에 추가
	    List<String> accountEventList = event.accountEventList((String)request.getSession().getAttribute("account"));
	    
	    List<String> eventDates = new ArrayList<>();
	    for (String event : accountEventList) {
	        eventDates.add(event); // 출석체크한 날짜 리스트에 추가
	    }
	    
	    result.put("mycalc", mycalc);
	    result.put("accountEventList", accountEventList);
	    result.put("eventDates", eventDates); // eventDates 배열을 추가
	    
	    log.info(Arrays.toString(mycalc.getCalc_days()));
	    
	    
	    log.info(""+eventDates);
	    log.info("accountEventList.........."+accountEventList);
	    return result;
	}
	
	
	/*
	 * @RequestMapping(value="/myCalendar" , method=RequestMethod.GET)
	 * 
	 * @ResponseBody public Map<String,Object> myCalendar(HttpServletRequest
	 * request) { Map<String,Object> result = new HashMap<>();
	 * log.info("......... myCalendar"); mycalc = new UserCalendar();
	 * mycalc.calc_settings();
	 * 
	 * mycalc.calc_settings();
	 * event.accountEventCheck((String)request.getSession().getAttribute("account"))
	 * ;
	 * 
	 * result.put("mycalc", mycalc); result.put("accountEventList",
	 * event.accountEventList((String)request.getSession().getAttribute("account"))
	 * ); return mycalc; return result; }
	 */
}