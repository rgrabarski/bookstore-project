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

	/**
	 * Ajoute un livre au stock
	 * @param isbn L'isbn du livre
	 * @param title Le titre du livre
	 * @param authorId L'ID de l'auteur du livre
	 * @return Le livre.
	 * @throws AuthorUnknownException
	 * @throws BookAlreadyExistsException
	 */
	public Book addBookToStock(String isbn, String title, Integer authorId) throws AuthorUnknownException, BookAlreadyExistsException;
	
}
