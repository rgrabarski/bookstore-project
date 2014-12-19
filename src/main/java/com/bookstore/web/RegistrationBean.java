package com.bookstore.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="registrationBean")
@SessionScoped
public class RegistrationBean {

	private String email;
	private String login;
    private String pwd;

    public String register(){
    	System.out.println("cocououououououopuposqdujksfklsfnklqsfjskldjfsdmkfjqklgjfgklmjqgklmqdfjmklj");
    	if(email.isEmpty() || login.isEmpty() || pwd.isEmpty()){
    		return null ;
    	}
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

	
}

