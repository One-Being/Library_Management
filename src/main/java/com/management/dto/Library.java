package com.management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Library {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int libraryid;
	private String libname;
	private String location;
	private long libcontact;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book>book;
	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;
	public int getLibraryid() {
		return libraryid;
	}
	public void setLibraryid(int libraryid) {
		this.libraryid = libraryid;
	}
	public String getLibname() {
		return libname;
	}
	public void setLibname(String libname) {
		this.libname = libname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getLibcontact() {
		return libcontact;
	}
	public void setLibcontact(long libcontact) {
		this.libcontact = libcontact;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

}
