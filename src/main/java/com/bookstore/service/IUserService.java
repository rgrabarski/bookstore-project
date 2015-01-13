package com.bookstore.service;

import java.util.List;

import com.bookstore.entities.User;

/**
 * Interface définissant les méthodes que doit implémenter un DAO/Servcie gérant la partie des utilisateurs.
 * @author RGAT
 *
 */
public interface IUserService {

	/**
	 * Récupère la liste des utilisateurs correspondants à un couple login/mot de passe.
	 * @param login Le login à tester.
	 * @param pwd Le mot de passe à tester.
	 * @return La liste des utilisateurs trouvés.
	 * @throws Exception En cas d'erreur.
	 */
	public List<User> findUserByLoginAndPwd(String login, String pwd) throws Exception;
	
}
