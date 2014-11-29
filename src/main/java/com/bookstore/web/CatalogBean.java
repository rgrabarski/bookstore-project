package com.bookstore.web;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.DemoAuthorService;
import com.bookstore.service.DemoService;
import com.bookstore.web.util.Criterions;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ManagedBean(name="catalogBean")
@RequestScoped
public class CatalogBean {

//	@Inject
	private DemoService demoService = new DemoService();
	private DemoAuthorService authorService = new DemoAuthorService();

    private String label;
    private String criterion;
    private HashMap<String,String> criterions = new Criterions().getCriterionsMap();

	private List<Book> books ;
	private List<Author> authors ;

	@PostConstruct
	public void init(){
		//books = demoService.findAll();
		authors = authorService.findAll();
	}

    public String searchByCriterion(){
        try {
            books = demoService.findByLabelAndCriterion(label, criterion);
        } catch (Exception e) {
            books = new ArrayList<Book>();
        }
        return null;
    }

    public String display(){
        books = demoService.findAll();
        return "/pages/catalog.xhtml";
    }

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
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    public HashMap<String, String> getCriterions() {
        return criterions;
    }
}
