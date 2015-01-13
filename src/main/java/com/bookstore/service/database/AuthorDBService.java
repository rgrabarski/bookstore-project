package com.bookstore.service.database;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Author;
import com.bookstore.service.IAuthorService;
import com.bookstore.web.util.EMFListener;

public class AuthorDBService implements IAuthorService {

	/**
	 * Récupère la liste des auteurs. 
	 * @return La liste des auteurs.
	 */
	public List<Author> findAll() {
		EntityManager em = EMFListener.createEntityManager();
		List<Author> authors = em.createNamedQuery("Author.allSorted", Author.class).getResultList();
		em.close();
		return authors;

	}

}
