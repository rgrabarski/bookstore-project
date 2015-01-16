package com.bookstore.service.database;

import com.bookstore.entities.Book;
import com.bookstore.service.ICatalogService;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CatalogDBServiceTest extends AbstractDAOTestCase {

    private ICatalogService catalogService = new CatalogDBService();

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindByLabelAndCriterion() throws Exception {

    }

    @Test
    public void testFindBookByISBN() throws Exception {
        Book bookByISBN = catalogService.findBookByISBN("978-1430219569");

        assertThat(bookByISBN, allOf(
                Matchers.<Book>hasProperty("isbn", is("978-1430219569")),
                Matchers.<Book>hasProperty("title", is("Pro JPA 2: Mastering the Java Persistence API")),
                Matchers.<Book>hasProperty("unitPrice", is(40.84)),
                Matchers.<Book>hasProperty("editor", is("APress")),
                Matchers.<Book>hasProperty("author", hasProperty("id", is(2)))
        ));
    }
}