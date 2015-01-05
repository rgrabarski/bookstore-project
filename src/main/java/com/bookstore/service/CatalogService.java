package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Book;
import com.bookstore.web.util.EMFListener;

public class CatalogService {

    private EntityManager em = EMFListener.createEntityManager();
    
    /**
     * Récupère la liste de tous les livres.
     * @return Une liste de tous les livres.
     */
	public List<Book> findAll() {
		List<Book> books = this.em.createQuery("From Book", Book.class).getResultList();
		em.close();
		return books;
	}

	/**
	 * Recherche des livres selon des critères et des valeurs.
	 * @param label La valeur à chercher (Keith, 978-1932394887, 47.03, ...) 
	 * @param criterion Le critère à rechercher (nom, isbn, prix, ...)
	 * @return La liste des livres correspondants au couple critère / label.
	 * @throws Exception En cas d'erreur.
	 */
    public List<Book> findByLabelAndCriterion(String label, String criterion) throws Exception{
        try {
            List<Book> books = this.em.createQuery("select b From Book b where b." + criterion + "= :label", Book.class)
                    .setParameter("label", label)
                    .getResultList();
            em.close();
            return books;
        } catch (Exception e) {
            throw new Exception("CatalogService:findByLabelAndCriterion: " + e.getMessage());
        }

    }

}
