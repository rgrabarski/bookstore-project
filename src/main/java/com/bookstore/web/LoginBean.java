package com.bookstore.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

    private String login;
    private String pwd;
    private boolean isLogged = false;

    public String login(){
    	if(login.equals("a") && pwd.equals("a")){
    		isLogged = true ;
    		return "catalog";
    	}
    	return null ;
    }
    
//    @PostConstruct
//    public void init() {
//
//    }

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

