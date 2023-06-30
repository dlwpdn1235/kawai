package com.kawai.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserVO {
	private String id;
	private String pass;
	private String name;
	private String birth;
	private String email;
	private String phonenum;
	private String postnum;
	private String address;
	private int role_id;
	private String create_date;
	private String create_ip;
	private String picture;
	private List<AccountUserRoleVO> userRoleList;
	private List<AccountEventVO> eventList;
	private List<AccountCouponVO> couponList;
}