package com.management.dto;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int  bookid;
	private String title;
	private int availablecopies;
	private int price;
	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAvailablecopies() {
		return availablecopies;
	}
	public void setAvailablecopies(int availablecopies) {
		this.availablecopies = availablecopies;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	

}
