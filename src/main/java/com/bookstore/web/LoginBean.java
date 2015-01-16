package com.bookstore.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import com.bookstore.service.factory.UserFactory;

/**
 * Classe représentant un bean de session.<br>
 * Le bean représente la page de login.
 * 
 * @author RGAT
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

    private String login;
    private String pwd;
    private boolean isLogged = false;
    
    // Récupération d'un service de gestion des utilisateurs par le pattern Factory :
    private IUserService userService = UserFactory.getUserServiceInstance();

    /**
     * Fonction de login : vérifie si un utilisateur peut se connecter en vérifiant ses identifiants (user et mot de passe)
     * @return La page à afficher en fonction du résultat de la vérification :<br>
     * - la même page en cas d'erreur<br>
     * - la page de catalogue sinon.
     */
    public String login(){
    	try {
    		// récupération de l'utilisateur correspondant au couple login/pwd :
			User user = userService.findUserByLoginAndPwd(login, pwd);
			
			// Si la liste est ni nulle ni vide :
			if(user != null){
				// Alors on connecte l'utilisateur :
				isLogged = true ;
				// Et on le redirige vers la page de catalogue :
	    		return "catalog";
			}else{
				System.out.println("La liste des utilisateurs est vide ou nulle.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	// Sinon on reste sur la même page :
    	return null ;
    }
    
    /**
     * Déconnecte l'utilisateur.
     * @return La page de login.
     */
    public String logout(){
    	// On déconnecte l'utilisateur :
    	this.isLogged = false ;
    	// On renvoie vers la page de login :
    	return "login";
    }
    
    
    /* GETTERS AND SETTERS */
    
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

}

