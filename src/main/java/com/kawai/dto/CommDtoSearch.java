package com.kawai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommDtoSearch {
	private int category_id;
	private int condition;
	private int day;
	private String searchKeyword;
	private int searchType;
	private int count;
	private int community_hide;
}
