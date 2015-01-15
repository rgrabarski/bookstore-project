package com.bookstore.service.factory;

import com.bookstore.service.IAuthorService;
import com.bookstore.service.database.AuthorDBService;

/**
 * Factory permettant de récupérer un service de gestion des auteurs.
 * 
 * @author RGAT
 *
 */
public class AuthorFactory {

	private static IAuthorService authorService = null ;
	
	/**
	 * Fourni un service de gestion des auteurs.
	 * @return Un service de gestion des auteurs implémentant l'interface {@link IAuthorService}.
	 */
	public static IAuthorService getAuthorServiceInstance(){
		if(authorService == null){
			return new AuthorDBService();
		}
		return authorService;
	}
		
}
