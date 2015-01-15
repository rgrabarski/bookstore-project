package com.bookstore.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.IAuthorService;
import com.bookstore.service.ICatalogService;
import com.bookstore.service.factory.AuthorFactory;
import com.bookstore.service.factory.CatalogFactory;

@ManagedBean(name="demoBean")
@RequestScoped
public class DemoBean {

	// Récupération d'un service de gestion du catalogue par le pattern Factory :
	private ICatalogService catalogService = CatalogFactory.getCatalogServiceInstance();
	// Récupération d'un service de gestion des auteurs par le pattern Factory :
	private IAuthorService authorService = AuthorFactory.getAuthorServiceInstance();
	
	private List<Book> books ;
	private List<Author> authors ;
	
	@PostConstruct
	public void init(){
		books = catalogService.findAll();
		authors = authorService.findAll();
	}

	/*
	 * GETTERS AND SETTERS
	 * */
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
