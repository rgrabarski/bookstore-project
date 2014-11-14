package com.bookstore.service.exception;

public class AuthorUnknownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160480221517183150L;

	public AuthorUnknownException(Integer authorId, Throwable cause) {
		super("Author with id " + authorId +" is unknown!", cause);
	}

	public AuthorUnknownException(Integer authorId) {
		this(authorId, null);
	}

	
}

