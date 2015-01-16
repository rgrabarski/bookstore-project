package com.bookstore.service.database;

import com.bookstore.entities.Book;
import com.bookstore.service.ICatalogService;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CatalogDBServiceTest extends AbstractDAOTestCase {

    private ICatalogService catalogService = new CatalogDBService();

    @Test
    public void testFindAll() throws Exception {
        List<Book> books = catalogService.findAll();

        assertThat(books, hasItems(
                        allOf(
                                Matchers.<Book>hasProperty("isbn", is("978-1932394887")),
                                Matchers.<Book>hasProperty("title", is("Java Persistence with Hibernate")),
                                Matchers.<Book>hasProperty("unitPrice", is(47.03)),
                                Matchers.<Book>hasProperty("editor", is(nullValue())),
                                Matchers.<Book>hasProperty("author", hasProperty("id", is(1)))
                        ), allOf(
                                Matchers.<Book>hasProperty("isbn", is("978-1430219569")),
                                Matchers.<Book>hasProperty("title", is("Pro JPA 2: Mastering the Java Persistence API")),
                                Matchers.<Book>hasProperty("unitPrice", is(40.84)),
                                Matchers.<Book>hasProperty("editor", is("APress")),
                                Matchers.<Book>hasProperty("author", hasProperty("id", is(2)))
                        ),  allOf(
                                Matchers.<Book>hasProperty("isbn", is("978-2070415731")),
                                Matchers.<Book>hasProperty("title", is("Fahrenheit 451")),
                                Matchers.<Book>hasProperty("unitPrice", is(5.04)),
                                Matchers.<Book>hasProperty("editor", is(nullValue())),
                                Matchers.<Book>hasProperty("author", is(nullValue()))
                        )
                )
        );
    }

    @Test
    public void testFindByLabelAndCriterion() throws Exception {
        List<Book> bookByLabelAndCriterion = catalogService.findByLabelAndCriterion("Pro JPA 2: Mastering the Java Persistence API", "title");
        assertThat(bookByLabelAndCriterion, hasItems(
                allOf(
                        Matchers.<Book>hasProperty("isbn", is("978-1430219569")),
                        Matchers.<Book>hasProperty("title", is("Pro JPA 2: Mastering the Java Persistence API")),
                        Matchers.<Book>hasProperty("unitPrice", is(40.84)),
                        Matchers.<Book>hasProperty("editor", is("APress")),
                        Matchers.<Book>hasProperty("author", hasProperty("id", is(2)))
                )
        ));
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