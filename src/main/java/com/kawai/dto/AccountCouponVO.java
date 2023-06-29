package com.kawai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCouponVO {
	private String id;
	private int couponname;
	private String context;
	private String period;
	private String start;
	private String end;
}