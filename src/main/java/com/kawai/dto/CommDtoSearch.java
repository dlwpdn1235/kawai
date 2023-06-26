package com.kawai.dto;

public class CommDtoSearch {
	private int category_id;
	private int condition;
	private int day;
	private String searchKeyword;
	private int searchType;
	private int count;
	public CommDtoSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommDtoSearch(int category_id, int condition, int day, String searchKeyword, int searchType, int count) {
		super();
		this.category_id = category_id;
		this.condition = condition;
		this.day = day;
		this.searchKeyword = searchKeyword;
		this.searchType = searchType;
		this.count = count;
	}
	@Override
	public String toString() {
		return "CommDtoSearch [category_id=" + category_id + ", condition=" + condition + ", day=" + day
				+ ", searchKeyword=" + searchKeyword + ", searchType=" + searchType + ", count=" + count + "]";
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
