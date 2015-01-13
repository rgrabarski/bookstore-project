package com.bookstore.service.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bookstore.entities.Author;
import com.bookstore.entities.Book;
import com.bookstore.service.IDemoStockService;
import com.bookstore.service.exception.AuthorUnknownException;
import com.bookstore.service.exception.BookAlreadyExistsException;
import com.bookstore.web.util.EMFListener;;

public class DemoStockDBService implements IDemoStockService {

	public Book addBookToStock(String isbn, String title, Integer authorId) throws AuthorUnknownException, BookAlreadyExistsException {

		EntityManager em = EMFListener.createEntityManager();
		
		// author exists?
		Author author = em.find(Author.class, authorId);
		if (author == null){
			throw new AuthorUnknownException(authorId);
		}
		
		//book already exists?
		Book book = em.find(Book.class, isbn);
		if (book != null){
			throw new BookAlreadyExistsException(isbn);
		}
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		em.persist(book);
		
		book.setAuthor(author);
		
		tx.commit();
		
		em.close();
		
		return book;
	}
	
}
