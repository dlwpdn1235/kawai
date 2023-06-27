package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoBookinfo {
	private int bookinfo_id;
	private String book_title;
	private String book_description;
	private String book_author;
	private String book_publisher;
	private String book_image;
	private String book_pubdate;

}
