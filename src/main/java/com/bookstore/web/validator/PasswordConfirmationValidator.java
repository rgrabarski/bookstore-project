package com.bookstore.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe permettant de vérifier qu'un mot de passe et un mot de passe de confirmation sont bien identiques.<br>
 * Implémente l'interface {@link Validator}.
 * 
 * @author RGAT
 *
 */
@FacesValidator("passwordConfirmationValidator")
public class PasswordConfirmationValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String password = value.toString();
		 
		// Récupération de la valeur du champ "initialPassword" :
		UIInput uiInputInitalPassword = (UIInput) component.getAttributes().get("initialPassword");
		String initialPassword = uiInputInitalPassword.getSubmittedValue().toString();
		 
		// Let required="true" do its job.
		if (password == null || password.isEmpty() || initialPassword == null || initialPassword.isEmpty()) {
			return;
		}
		 
		// Si les 2 mots de passe sont différents :
		if (!password.equals(initialPassword)) {
			// On invalide le validator :
			uiInputInitalPassword.setValid(false);
			// Et on défini le message d'erreur :
			throw new ValidatorException(new FacesMessage("Le mot de passe doit correspondre au mot de passe de confirmation renseigné ci-dessous."));
		}
	}

}
