package com.bookstore.service.factory;

import com.bookstore.service.IUserService;
import com.bookstore.service.database.UserDBService;

/**
 * Factory permettant de récupérer un service de gestion des utilisateurs.
 * 
 * @author RGAT
 *
 */
public class UserFactory {

	private static IUserService userService = null ;
	
	/**
	 * Fourni un service de gestion des utilisateur.
	 * @return Un service de gestion du catalogue implémentant l'interface {@link IUserService}.
	 */
	public static IUserService getUserServiceInstance(){
		if(userService == null){
			return new UserDBService();
		}
		return userService;
	}

}
