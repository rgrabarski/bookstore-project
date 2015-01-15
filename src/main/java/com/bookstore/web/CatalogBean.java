package com.bookstore.web;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.ICatalogService;
import com.bookstore.service.factory.CatalogFactory;
import com.bookstore.web.util.Criterions;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe représentant un bean de vue.<br>
 * Le bean représente la page de catalogue.
 * 
 * @author RGAT
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="catalogBean")
@ViewScoped
public class CatalogBean implements Serializable {

	// Récupération d'un service de gestion du catalogue par le pattern Factory :
	private ICatalogService catalogService = CatalogFactory.getCatalogServiceInstance();

    private String label = "";
    private String criterion = "";
    private HashMap<String,String> criterions = new Criterions().getCriterionsMap();

	private List<Book> books ;
	private List<Author> authors ;
	private Book selectedBook = null;

	/**
	 * Initialise les données, notamment la liste des livres.
	 */
	@PostConstruct
	public void init(){				
		books = catalogService.findAll();
	}

	/**
	 * Recherche un livre selon les critères de recherches entrées dans les formulaires
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


    public Book getSelectedBook() {
		return selectedBook;
	}

	
    public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}
}
