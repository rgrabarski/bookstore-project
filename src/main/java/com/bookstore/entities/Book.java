package com.bookstore.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Représente un livre et réalise le binding relationnel avec la base de données.
 * 
 * @author RGAT
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable{

	@Id
	@Column(name = "ISBN13")
	@Length(min=14, max=14)
	private String isbn;

	@Column(name = "TITLE", nullable = false)
	@NotNull
	@NotBlank
	private String title;

	@Column(name = "UNIT_PRICE")
	private Double unitPrice;

	private String editor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Author author;

	public Book() {
		super();
	}

	
	/* GETTERS AND SETTERS */
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
