package com.bookstore.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import com.bookstore.service.database.UserDBService;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

    private String login;
    private String pwd;
    private boolean isLogged = false;
    
    private IUserService userService = new UserDBService();

    /**
     * Fonction de login : vérifie si un utilisateur peut se connecter en vérifiant ses identifiants (user et mot de passe)
     * @return La page à afficher en fonction du résultat de la vérification :<br>
     * - la même page en cas d'erreur<br>
     * - la page de catalogue sinon.
     */
    public String login(){
    	try {
    		// récupération d'une liste d'utilisateurs correspondants au coupe login/pwd :
			List<User> userList = userService.findUserByLoginAndPwd(login, pwd);
			
			// Si la liste est ni nulle ni vide :
			if(userList != null && ! userList.isEmpty() && userList.size() != 0){
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
    	// On renvoie vers la page de login :
    	return "login";
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

