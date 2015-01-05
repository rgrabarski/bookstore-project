package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.User;
import com.bookstore.web.util.EMFListener;

/**
 * Classe permettant de gérer les utilisateurs.
 * 
 * @author RGAT
 *
 */
public class UserService {

	private EntityManager em = EMFListener.createEntityManager();
	
	/**
	 * Récupère la liste des utilisateurs correspondants à un couple login/mot de passe.
	 * @param login Le login à tester.
	 * @param pwd Le mot de passe à tester.
	 * @return La liste des utilisateurs trouvés.
	 * @throws Exception En cas d'erreur.
	 */
	public List<User> findUserByLoginAndPwd(String login, String pwd) throws Exception{
	
	    try {
	        List<User> users = this.em.createQuery("select u From User u where u.login = :login and u.password = :pwd", User.class)
	                .setParameter("login", login)
	                .setParameter("pwd", pwd)
	                .getResultList();
	        em.close();
	        return users;
	    } catch (Exception e) {
	        throw new Exception("UserService:findUserByLoginAndPwd: " + e.getMessage());
	    }
    }

}
