package com.icl.m2.jsf.basics3;

import java.util.ArrayList;
import java.util.List;

//TODO : you can switch this statis utility classes to an application scoped managedBean!!
public class SkinUtil {

	private final static List<Skin> skins = new ArrayList<Skin>();
	
	static{
		skins.add(new Skin("Blue sky", "blueSky"));
		skins.add(new Skin("Kawaï", "japanCherry"));
		skins.add(new Skin("Very ugly skin", "ugly"));
		skins.add(new Skin("Wine", "wine"));
		skins.add(new Skin("Ruby", "ruby"));
		skins.add(new Skin("Green", "emeraldTown"));
		skins.add(new Skin("Ocean", "deepMarine"));
		skins.add(new Skin("Classic", "classic"));
	}

	public static Skin findSkinByName(String name) {
		for(Skin skin : findAllSkins()){
			if (skin.getName().equals(name) || skin.getLabel().equals(name)){
				return skin;
			}
		}
		return null;
	}

	public static List<Skin> findAllSkins() {
		return skins;
	}

}
