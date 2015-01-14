package com.bookstore.service.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Author;
import com.bookstore.service.IAuthorService;
import com.bookstore.web.util.EMFListener;

/**
 * Classe permettant de récupérer les informations relatives aux auteurs depuis la base de données.<br>
 * Implémente l'interface {@link IAuthorService}.
 * 
 * @author RGAT
 *
 */
@SuppressWarnings("serial")
public class AuthorDBService implements IAuthorService, Serializable {

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
