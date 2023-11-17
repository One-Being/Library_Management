package com.management.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int  uid;
	private String uname;
	private long ucontact;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Issued_Book>issuedbook;
	private int dueamount;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getUcontact() {
		return ucontact;
	}
	public void setUcontact(long ucontact) {
		this.ucontact = ucontact;
	}
	public List<Issued_Book> getIssuedbook() {
		return issuedbook;
	}
	public void setIssuedbook(List<Issued_Book> issuedbook) {
		this.issuedbook = issuedbook;
	}
	public int getDueamount() {
		return dueamount;
	}
	public void setDueamount(int dueamount) {
		this.dueamount = dueamount;
	}
	
	
	
	

}
