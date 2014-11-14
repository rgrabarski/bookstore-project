package com.icl.m2.jsf.basics3;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SkinBean {

	private Skin skin;
	
	private List<Skin> availableSkins;
	
	@PostConstruct
	public void init(){
		skin = new Skin();
		skin.setName("blueSky");
		skin.setLabel("Blue");
		
		availableSkins = SkinUtil.findAllSkins();
	}

	public String changeSkin(String skin){
		this.skin = SkinUtil.findSkinByName(skin);
		return null;
	}

	
	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public List<Skin> getAvailableSkins() {
		return availableSkins;
	}

	public void setAvailableSkins(List<Skin> availableSkins) {
		this.availableSkins = availableSkins;
	}

	
}
