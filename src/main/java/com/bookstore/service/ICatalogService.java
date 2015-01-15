package com.bookstore.service;

import java.util.List;

import com.bookstore.entities.Book;

/**
 * Interface définissant les méthodes que doit implémenter un DAO/Service gérant la partie catalogue.
 * @author RGAT
 *
 */
public interface ICatalogService {

    /**
     * Récupère la liste de tous les livres.
     * @return Une liste de tous les livres.
     */
	public List<Book> findAll();

	/**
	 * Recherche des livres selon des critères et des valeurs.
	 * @param label La valeur à chercher (Keith, 978-1932394887, 47.03, ...) 
	 * @param criterion Le critère à rechercher (nom, isbn, prix, ...)
	 * @return La liste des livres correspondants au couple critère / label.
	 * @throws Exception En cas d'erreur.
	 */
    public List<Book> findByLabelAndCriterion(String label, String criterion) throws Exception;

//    public List<Book> findByMultiCriterions(String author_label, String title_label, String isbn_label, String price_label) throws Exception;
	
    /**
     * Recherche un livre en focntion de son ISBN.
     * @param isbn L'ISBN du livre à rechercher.
     * @return Le livre correspondant à cet ISBN, {@code null} sinon.
     */
    public Book findBookByISBN(String isbn);
    
}
