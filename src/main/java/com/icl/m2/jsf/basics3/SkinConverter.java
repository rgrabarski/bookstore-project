package com.icl.m2.jsf.basics3;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Skin.class, value="skinConverter")
public class SkinConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		return SkinUtil.findSkinByName(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		return ((Skin)arg2).getLabel();
	}
	
	

}
