package com.bookstore.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.bookstore.entities.Book;
import com.bookstore.service.IDemoStockService;
import com.bookstore.service.database.DemoStockDBService;
import com.bookstore.service.exception.AuthorUnknownException;
import com.bookstore.service.exception.BookAlreadyExistsException;

@ManagedBean
@RequestScoped
public class DemoAddBookBean {

	private IDemoStockService stockService = new DemoStockDBService();

	private Book book;
	
	private Integer authorId;

	//the list of books is sotred inside, if we want to "refersh it " we need the bean
	@ManagedProperty("#{demoBean}")
	private DemoBean demoBean;
	
	public String addBook(){
		try {
			stockService.addBookToStock(book.getIsbn(), book.getTitle(), authorId);
			demoBean.init();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book added", book.getIsbn() + " " + book.getTitle() + " has been added to our stock"));
		} catch (AuthorUnknownException e){
			FacesContext.getCurrentInstance().addMessage("addBookForm:author", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
		}catch(BookAlreadyExistsException e) {
			FacesContext.getCurrentInstance().addMessage("addBookForm:isbn", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
		}
		
		//we stay on the same page
		return null;
	}
	
	
	@PostConstruct
	public void init(){
		book = new Book();
		authorId = 0;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public DemoBean getDemoBean() {
		return demoBean;
	}

	public void setDemoBean(DemoBean demoBean) {
		this.demoBean = demoBean;
	}

	
}
