package com.kawai.dto;

public class CommDtoBookinfo {
	private int bookinfo_id;
	private String book_title;
	private String book_description;
	private String book_author;
	private String book_publisher;
	private String book_image;
	private String book_pubdate;
	public CommDtoBookinfo() {
		super();
	}
	public CommDtoBookinfo(int bookinfo_id, String book_title, String book_description, String book_author,
			String book_publisher, String book_image, String book_pubdate) {
		super();
		this.bookinfo_id = bookinfo_id;
		this.book_title = book_title;
		this.book_description = book_description;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_image = book_image;
		this.book_pubdate = book_pubdate;
	}
	@Override
	public String toString() {
		return "CommDtoBookinfo [bookinfo_id=" + bookinfo_id + ", book_title=" + book_title + ", book_description="
				+ book_description + ", book_author=" + book_author + ", book_publisher=" + book_publisher
				+ ", book_image=" + book_image + ", book_pubdate=" + book_pubdate + "]";
	}
	public int getBookinfo_id() {
		return bookinfo_id;
	}
	public void setBookinfo_id(int bookinfo_id) {
		this.bookinfo_id = bookinfo_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getBook_pubdate() {
		return book_pubdate;
	}
	public void setBook_pubdate(String book_pubdate) {
		this.book_pubdate = book_pubdate;
	}
	
}
