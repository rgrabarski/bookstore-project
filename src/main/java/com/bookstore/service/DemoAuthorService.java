package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Author;
import com.bookstore.web.util.EMFListener;

public class DemoAuthorService {

	public List<Author> findAll() {
		EntityManager em = EMFListener.createEntityManager();
		List<Author> authors = em.createNamedQuery("Author.allSorted", Author.class).getResultList();
		em.close();
		return authors;

	}

}
