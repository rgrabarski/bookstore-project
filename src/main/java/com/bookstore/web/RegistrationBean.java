package com.bookstore.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="registrationBean")
@SessionScoped
public class RegistrationBean {

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
    	// Sinon on envoie sur la page de login :
    	return "login";
    }
    
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

