package com.bookstore.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import com.bookstore.service.factory.UserFactory;

/**
 * Classe permettant de vérifier qu'un login est bien unique.<br>
 * Implémente l'interface {@link Validator}.
 * 
 * @author RGAT
 *
 */
@FacesValidator("uniqueLoginValidator")
public class UniqueLoginValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// Récupération du login saisi :
		String login = value.toString();
	 
	  // Let required="true" do its job.
	  if (login == null || login.isEmpty()) {
			return;
	  }
	 
	  // On vérifie si un utilisateur ayant ce login existe déjà ou non.
	  // On utilise pour cela le pattern Factory pour récupérer un IUserService :
		IUserService userService = UserFactory.getUserServiceInstance();
	  	User u = userService.findUserByLogin(login);
		if(u != null){
			// On défini le message d'erreur :
			throw new ValidatorException(new FacesMessage("Ce login est déjà utilisé. Choisissez-en un autre."));
		}
		
	}

}
