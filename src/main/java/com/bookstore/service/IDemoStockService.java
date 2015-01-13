package com.bookstore.service;

import com.bookstore.entities.Book;
import com.bookstore.service.exception.AuthorUnknownException;
import com.bookstore.service.exception.BookAlreadyExistsException;

/**
 * Interface définissant les méthodes que doit implémenter un DAO/Service gérant la partie DemoStock.
 * @author RGAT
 *
 */
public interface IDemoStockService {

	public Book addBookToStock(String isbn, String title, Integer authorId) throws AuthorUnknownException, BookAlreadyExistsException;
	
}
