package com.bookstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.DemoAuthorService;
import com.bookstore.service.DemoService;

@ManagedBean(name="demoBean")
@RequestScoped
public class DemoBean {

//	@Inject
	private DemoService demoService = new DemoService();
	private DemoAuthorService authorService = new DemoAuthorService();
	
	private String test = "erojkfepof";
	private List<Book> books ;
	private List<Author> authors ;
	
	@PostConstruct
	public void init(){
		books = demoService.findAll();
		authors = authorService.findAll();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
