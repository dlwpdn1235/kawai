package com.kawai.common;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserCalendar {
	Calendar today;
	String[] weektitle;
	String[] calc_days;
	int year, month, day;
	int startyoil ,endyoil ,lastday;
	
	public UserCalendar() {
		today = Calendar.getInstance();
		this.year 	= today.get(Calendar.YEAR);
		this.month 	= today.get(Calendar.MONTH);
		this.day 	= today.get(Calendar.DATE);
		
	}
	public UserCalendar(int year , int month , int day) {

		this.year 	= year;
		this.month 	= month;
		this.day 	= day;
		
	}
	
	
	public void calc_settings() {
		this.weektitle = new String[] { "SUM", "MON" , "TUE" , "WED" , "THU" , "FRI" , "SAT" };
		
		if(this.month == 12 ) { this.year +=1; this.month=0; }
		else if(this.month == -1) { this.year-=1; this.month=11;}
		// month : 0~11 0이 1월 , 1이 2월 ,,,, 11이 12월
		
		
		
		today.set(this.year, this.month , 1);
		this.startyoil = today.get(Calendar.DAY_OF_WEEK);
		
		this.lastday = today.getActualMaximum(Calendar.DATE);  //28 , 30 , 31 
		today.set(this.year, this.month , this.lastday);
		this.endyoil = today.get(Calendar.DAY_OF_WEEK);
		
		this.calc_days = new String[42];
		Arrays.fill(this.calc_days, "" );
		
		this.month = this.month + 1;
		int cnt = 1;
		for(int i=this.startyoil-1; i<(this.startyoil+this.lastday-1); i++) {
			this.calc_days[i] = String.valueOf( cnt++);
		}
		
		
		/*
		 * this.startyoil; this.endyoil; this.lastday;
		 */
		
	}
}
