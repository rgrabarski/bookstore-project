package com.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.web.LoginBean;

/**
 * Classe permettant de vérifier si un utilisateur est bien logué.<br>
 * Ce filtre est a activer sur chaque page.<br>
 * <br>
 * Redirige chaque demande vers la page de connexion si l'utilisateur n'est pas logué, sauf si la demande concerne la page d'inscription.<br>
 * Si l'utilisateur est logué et qu'il demande la page d'inscription : redirection vers la page de catalogue.
 * <br>
 * <br>
 * Implémente l'interface {@link Filter}.
 * @author RGAT
 *
 */
public class ConnectionFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String[] tab = req.getRequestURI().split("/"); // On éclate l'URI sur la caractère / et on récupère le résultat dans un tableau.
	
		int taille = tab.length - 1 ; // -1 car les index d'un tableau commencent à 0.
		System.out.println("Page demandée : "+tab[taille]);
		
		try{
			// Récupération du bean "loginBean" mis en session lors d'une connexion :
			LoginBean login = (LoginBean) req.getSession().getAttribute("loginBean");
			
			// Si l'utilisateur est connecté :
			if(login.isLogged()){
				System.out.println("L'utilisateur est connecté.");
				
				// Si l'utilisateur est connecté et qu'il demande la page d'inscription :
				if( tab[taille].equals("registration.jsf")){
					// On redirige vers la page de catalogue :
					System.out.println("Redirection vers la page de catalogue.");
					resp.sendRedirect("./catalog.jsf");
				}else{
					// Sinon si l'utilisateur est connecté et qu'il demande une autre page, on passe à l'éventuel filtre suivant :
					chain.doFilter(request, response);
				}
				
			}else{
				System.out.println("L'utilisateur n'est pas connecté.");
				throw new Exception("L'utilisateur n'est pas connecté.");
			}
			
		}catch(Exception e){
			// Si l'utilisateur demandait la page de login ou d'inscription :
			if( tab[taille].equals("login.jsf") || tab[taille].equals("registration.jsf") ){
				// On le laisse aller vers cette page :
				chain.doFilter(request, response);
			}else{
				// Redirection vers la page de login en cas d'erreur :
				System.out.println("Une erreur est survenue.\nRedirection vers la page de login. (cause : "+e.getMessage()+").");
				resp.sendRedirect("./login.jsf");
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
