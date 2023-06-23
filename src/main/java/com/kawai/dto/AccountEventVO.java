package com.kawai.dto;

public class AccountEventVO {
	private String id;
	private String eventdate;
	public AccountEventVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountEventVO(String id, String eventdate) {
		super();
		this.id = id;
		this.eventdate = eventdate;
	}
	@Override
	public String toString() {
		return "AccountEventDto [id=" + id + ", eventdate=" + eventdate + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	
}