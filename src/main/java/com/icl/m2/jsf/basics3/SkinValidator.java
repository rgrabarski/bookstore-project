package com.icl.m2.jsf.basics3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="skinValidator")
public class SkinValidator implements javax.faces.validator.Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		System.out.println("skinValidator");
		if (arg2 == null){
			throw new ValidatorException(new FacesMessage("Unknown skin !!"));
		}
		
	}

}
