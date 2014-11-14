package com.bookstore.service.exception;

public class BookAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7452809028728707815L;

	public BookAlreadyExistsException(String isbn, Throwable cause){
		super ("A book with the isbn " + isbn + " already exists", cause);
	}
	
	public BookAlreadyExistsException(String isbn){
		this(isbn, null);
	}
	
}
