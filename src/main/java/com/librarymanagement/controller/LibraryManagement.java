package com.librarymanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.management.dao.AdminDao;
import com.management.dao.AuthorDao;
import com.management.dao.BookDao;
import com.management.dao.Issued_BookDao;
import com.management.dao.LibraryDao;
import com.management.dao.UserDao;
import com.management.dto.Admin;
import com.management.dto.Author;
import com.management.dto.Book;
import com.management.dto.IssuedBookStatus;
import com.management.dto.Issued_Book;
import com.management.dto.Library;
import com.management.dto.User;

public class LibraryManagement {
	AdminDao adao = new AdminDao();
	UserDao userDao = new UserDao();
	BookDao bdao = new BookDao();
	LibraryDao ldao = new LibraryDao();
	Issued_BookDao isdao = new Issued_BookDao();
	AuthorDao audao = new AuthorDao();
	
	public Admin saveAdmin(Admin admin) {
		return adao.saveAdmin(admin);
	}
	
	public Library createLibrary(Library lib , int admnid) {
		Admin exadmin = adao.findAdmin(admnid);
		Library savelib = ldao.saveLibrary(lib);
		savelib.setAdmin(exadmin);
		return ldao.updateLibrary(savelib, savelib.getLibraryid());
		
	}
	
	public Author saveAuthor(Author auth) {
		return audao.saveAuthor(auth);
	}
	
	public Book saveBook(Book book,int authid,int lib) {
		Book bk = bdao.saveBook(book);
		Author auth = audao.findAuthor(authid);
		Library library = ldao.findLibrary(lib);
		List<Book>lis = new ArrayList<Book>();
		lis.add(bk);
		auth.setBook(lis);
		bk.setAuthor(auth);
		book = bdao.updateBook(bk, bk.getBookid());
		library.getBook().add(book);
		ldao.updateLibrary(library, lib);
		return book;
		
	}
	
	public User saveUser(User u) {
		return userDao.saveUser(u);
	}
	
	public Issued_Book issue(int uid,int bid) 
	{
		User exuser = userDao.findUser(uid);
		Book exbook = bdao.findBook(bid);
		if(exuser != null) {
			if(exbook != null) {
				if(exbook.getAvailablecopies() >0) {
					exbook.setAvailablecopies(exbook.getAvailablecopies()-1);
					bdao.updateBook(exbook, bid);
					
					Issued_Book iss = new Issued_Book();
					iss.setBookid(bid);
					iss.setIssueddate(LocalDate.now());
					iss.setIssuedbookstatus(IssuedBookStatus.ISSUED);
					
					Issued_Book save = isdao.saveIssuedBook(iss);
					exuser.getIssuedbook().add(save);
					userDao.updateUser(exuser, uid);
					return save;
				}
				return null; //Book Outofstack
			}
			return null; //no book present
		}
		return null; //no user present
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		LibraryManagement lib = new LibraryManagement();
//		Admin adm = new Admin();
//		adm.setAdname("Gokul");
//		adm.setEmail("aravindgokul90@gmail.com");
//		adm.setPassword("gokul");
//		lib.saveAdmin(adm);
//		
//		Library library = new Library();
//		library.setLibname("Hulk Library");
//		library.setLibcontact(234567890);
//		library.setLocation("Anna Nagar");
//		lib.createLibrary(library, 1);
//		
//		Author auth = new Author();
//		auth.setAuthname("Charlie Chaplin");
//		auth.setPlace("London");
//		lib.saveAuthor(auth);
//		
//		Book bok = new Book();
//		bok.setTitle("Tales of Laugh");
//		bok.setPrice(120);
//		bok.setAvailablecopies(10);
//		lib.saveBook(bok, 1, 1);
//		
		
//		User user = new User();
//		user.setUname("GoCool");
//		user.setUcontact(944593874);
//		lib.saveUser(user);
		
		
		lib.issue(1, 1);
	}

}
