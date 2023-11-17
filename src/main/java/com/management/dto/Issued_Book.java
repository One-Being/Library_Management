package com.management.dto;

import java.time.LocalDate;

import javax.persistence.*;



@Entity
public class Issued_Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	private int issueid;
	private int bookid;
	private LocalDate issueddate;
	private LocalDate returneddate;
	private IssuedBookStatus issuedbookstatus;
	public int getIssueid() {
		return issueid;
	}
	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public LocalDate getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(LocalDate issueddate) {
		this.issueddate = issueddate;
	}
	public LocalDate getReturneddate() {
		return returneddate;
	}
	public void setReturneddate(LocalDate returneddate) {
		this.returneddate = returneddate;
	}
	public IssuedBookStatus getIssuedbookstatus() {
		return issuedbookstatus;
	}
	public void setIssuedbookstatus(IssuedBookStatus issuedbookstatus) {
		this.issuedbookstatus = issuedbookstatus;
	}
	
	

}
