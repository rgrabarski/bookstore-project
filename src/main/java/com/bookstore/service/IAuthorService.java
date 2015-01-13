package com.bookstore.service;

import java.util.List;

import com.bookstore.entities.Author;

/**
 * Interface définissant les méthodes que doit implémenter un DAO/Service gérant la partie des auteurs.
 * @author RGAT
 *
 */
public interface IAuthorService {

	/**
	 * Récupère la liste des auteurs. 
	 * @return La liste des auteurs.
	 */
	public List<Author> findAll();
	
}
