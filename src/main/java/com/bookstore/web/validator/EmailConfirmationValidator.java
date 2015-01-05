package com.bookstore.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe permettant de vérifier qu'un email de confirmation correspond bien à la valeur saisie dans un champ email source.<br>
 * Implémente l'interface {@link Validator}.
 * 
 * @author RGAT
 *
 */
@FacesValidator("emailConfirmationValidator")
public class EmailConfirmationValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String email = value.toString();
		 
		// Récupération de la valeur du champ "confirmEmail" : 
		UIInput uiInputConfirmEmail = (UIInput) component.getAttributes().get("confirmEmail");
		String confirmEmail = uiInputConfirmEmail.getSubmittedValue().toString();
	 
		  // Let required="true" do its job.
		  if (email == null || email.isEmpty() || confirmEmail == null || confirmEmail.isEmpty()) {
				return;
		  }
	 
		  // Si les 2 emails sont différents :
		  if (!email.equals(confirmEmail)) {
			  // On invalide le validator :
			uiInputConfirmEmail.setValid(false);
			// On défini le message d'erreur :
			throw new ValidatorException(new FacesMessage("L'email doit correspondre à l'adresse de confirmation renseignée ci-dessous."));
		  }
		
	}

}
