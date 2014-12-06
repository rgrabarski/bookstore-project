package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Book;
import com.bookstore.web.util.EMFListener;

public class CatalogService {

    private EntityManager em = EMFListener.createEntityManager();
	public List<Book> findAll() {
		List<Book> books = this.em.createQuery("From Book", Book.class).getResultList();
		em.close();
		return books;
	}

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
