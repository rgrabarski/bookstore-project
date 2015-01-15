package com.bookstore.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import com.bookstore.service.factory.UserFactory;

/**
 * Classe représentant un bean de session.<br>
 * Le bean représente la page d'enregistrement.
 * 
 * @author RGAT
 *
 */
@ManagedBean(name="registrationBean")
@SessionScoped
public class RegistrationBean {

	// Récupération d'un service de gestion des utilisateurs par le pattern Factory :
	private IUserService userService = UserFactory.getUserServiceInstance();
	
	private String email;
	private String confirmedEmail;
	private String login;
    private String pwd;
    private String confirmedPwd ;

    /**
     * Permet d'enregistrer un nouvel utilisateur.
     * @return La page vers laquelle rediriger l'utilisateur.<br>
     * La même page en cas d'erreur, la page de login sinon.
     */
    public String register(){
    	// Si un des champs est vide ou si les champs de confirmation sont différents des champs à confirmer :
    	if(email.isEmpty() || login.isEmpty() || pwd.isEmpty() || ! confirmedEmail.equals(email) || ! confirmedPwd.equals(pwd)){
    		// On reste sur la même page
    		return null ;
    	}
    	
    	// Création d'un nouvel utilisateur :
    	User u = new User();
    	u.setEmail(confirmedEmail);
    	u.setLogin(login);
    	u.setPassword(confirmedPwd);
    	
    	// On vérifie si l'utilisateur existe déjà en base :
    	if(userAlreadyExists(u.getLogin())){
    		// On reste sur la même page :
    		return null ;
    	}
    	
    	// Sauvegarde de l'utilisateur :
    	userService.createUser(u);
    	
    	// Sinon on envoie sur la page de login :
    	return "login";
    }
    
    /**
     * Vérifie si un utilisateur possédant déjà ce login existe déjà.
     * @param login Le login à tester.
     * @return {@code true} si l'utilisateur existe, {@code false} sinon.
     */
    private boolean userAlreadyExists(String login) {
		User u = userService.findUserByLogin(login);
		if(u != null){
			return true;
		}
    	return false;
	}
    
    /**
     * Initialisation des variables.
     */
	@PostConstruct
    public void init() {
    	email ="";
    	login = "";
    	pwd = "";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmedEmail() {
		return confirmedEmail;
	}

	public void setConfirmedEmail(String confirmedEmail) {
		this.confirmedEmail = confirmedEmail;
	}

	public String getConfirmedPwd() {
		return confirmedPwd;
	}

	public void setConfirmedPwd(String confirmedPwd) {
		this.confirmedPwd = confirmedPwd;
	}
	
}

