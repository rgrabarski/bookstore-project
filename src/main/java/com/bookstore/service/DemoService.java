package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entities.Book;
import com.bookstore.web.util.EMFListener;

public class DemoService {

	//private EntityManager em = ;
	
	public List<Book> findAll() {
		EntityManager em = EMFListener.createEntityManager();
		List<Book> books = em.createQuery("From Book", Book.class).getResultList();
		em.close();
		return books;
	}

}
