package com.bookstore.service.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import com.bookstore.web.util.EMFListener;

/**
 * Classe permettant de gérer les utilisateurs venant de la base de données.
 * Implémente l'interface {@link IUserService}.
 * 
 * @author RGAT
 *
 */
public class UserDBService implements IUserService {

	private EntityManager em = EMFListener.createEntityManager();
	
	/**
	 * Récupère la liste des utilisateurs correspondants à un couple login/mot de passe.
	 * @param login Le login à tester.
	 * @param pwd Le mot de passe à tester.
	 * @return La liste des utilisateurs trouvés.
	 * @throws Exception En cas d'erreur.
	 */
	public User findUserByLoginAndPwd(String login, String pwd) throws Exception{
	
	    try {
	        User user = this.em.createQuery("select u From User u where u.login = :login and u.password = :pwd", User.class)
	                .setParameter("login", login)
	                .setParameter("pwd", pwd)
	                .getSingleResult();
//	        em.close();
	        return user;
	    } catch (Exception e) {
	        throw new Exception("UserService:findUserByLoginAndPwd: " + e.getMessage());
	    }
    }

	/**
	 * Créé et sauvegarde un nouvel utilisateur.
	 * @param u L'utilisateur à créer.
	 */
	@Override
	public void createUser(User u) {
		if(u != null){
			EntityTransaction transaction = this.em.getTransaction();
			transaction.begin();
			em.persist(u);
			transaction.commit();
		}
	}

	/**
	 * Recherche un utilisateur par son login.
	 * @param login Le login à rechercher.
	 * @return L'utilisateur trouvé, {@code null} sinon.
	 */
	@Override
	public User findUserByLogin(String login) {
		User u = em.find(User.class, login);
		return u;
	}

}
