package com.ssafy.book.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Book (도서 정보)", description = "도서 번호, 제목, 저자, 가격, 설명, 이미지 링크의 정보를 가진 클래스")
public class Book {

	@ApiModelProperty(value = "도서 번호")
	String isbn;
	@ApiModelProperty(value = "제목")
	String title;
	@ApiModelProperty(value = "저자")
	String author;
	@ApiModelProperty(value = "가격")
	int price;
	@ApiModelProperty(value = "설명")
	String desc;
	@ApiModelProperty(value = "이미지 링크")
	String img;

	public Book() {
		super();
	}

	public Book(String isbn, String title, String author, int price, String desc, String img) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.desc = desc;
		this.img = img;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
