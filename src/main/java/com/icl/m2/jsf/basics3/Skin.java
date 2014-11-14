package com.icl.m2.jsf.basics3;

public class Skin {

	private String name;
	
	public Skin() {
		super();
	}

	public Skin(String label, String name) {
		super();
		this.name = name;
		this.label = label;
	}


	private String label;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	@Override
	public String toString() {
		return label;
	}
}
