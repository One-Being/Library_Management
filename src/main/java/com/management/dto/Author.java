package com.management.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Author {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int authid;
	private String authname;
	private String place;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book>book;
	public int getAuthid() {
		return authid;
	}
	public void setAuthid(int authid) {
		this.authid = authid;
	}
	public String getAuthname() {
		return authname;
	}
	public void setAuthname(String authname) {
		this.authname = authname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	

}
