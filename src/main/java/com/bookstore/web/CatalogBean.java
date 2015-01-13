package com.bookstore.web;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.database.AuthorDBService;
import com.bookstore.service.database.CatalogDBService;
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
	private CatalogDBService catalogService = new CatalogDBService();
	private AuthorDBService authorService = new AuthorDBService();

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

	/**
	 * Recherche un livre selon un critère (couple clé / valeur)
	 * @return
	 */
    public String searchByCriterion(){
        try {
            if (label == "") {
                books = catalogService.findAll();
            } else {
                books = catalogService.findByLabelAndCriterion(label, criterion);
            }
        } catch (Exception e) {
            books = new ArrayList<Book>();
        }
        return null;
    }

    /**
     * Affiche la page de catalogue avec la liste de tous les livres.
     * @return La page affichant la liste de tous les livres.
     */
    public String display(){
        books = catalogService.findAll();
        return "/pages/catalog.xhtml";
    }

    
    /*
     * GETTERS & SETTERS
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
