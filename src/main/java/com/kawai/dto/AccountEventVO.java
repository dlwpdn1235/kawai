package com.kawai.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEventVO {
	private String id;
	private String eventdate;
	private List<AccountCouponVO> couponList;
}