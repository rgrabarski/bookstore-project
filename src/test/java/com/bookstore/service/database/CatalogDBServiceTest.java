package com.bookstore.service.database;

import com.bookstore.entities.Book;
import com.bookstore.service.ICatalogService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CatalogDBServiceTest extends AbstractDAOTestCase {

    private ICatalogService catalogService = new CatalogDBService();

    @Test
    public void testFindAll() throws Exception {
        //TODO
//        List<Book> books = catalogService.findAll();
//
//        assertThat(books, hasItems(
//                        allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-1932394887")),
//                                Matchers.<Book>hasProperty("title", is("Java Persistence with Hibernate")),
//                                Matchers.<Book>hasProperty("unitPrice", is(47.03)),
//                                Matchers.<Book>hasProperty("editor", is("")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(1)))
//                        ), allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-1430219569")),
//                                Matchers.<Book>hasProperty("title", is("Pro JPA 2: Mastering the Java Persistence API")),
//                                Matchers.<Book>hasProperty("unitPrice", is(40.84)),
//                                Matchers.<Book>hasProperty("editor", is("APress")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(2)))
//                        ),  allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-2070415731")),
//                                Matchers.<Book>hasProperty("title", is("Fahrenheit 451")),
//                                Matchers.<Book>hasProperty("unitPrice", is(5.04)),
//                                Matchers.<Book>hasProperty("editor", is("Gallimard")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(3)))
//                        ), allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-2841030385")),
//                                Matchers.<Book>hasProperty("title", is("Le Corbeau")),
//                                Matchers.<Book>hasProperty("unitPrice", is(14.0)),
//                                Matchers.<Book>hasProperty("editor", is("William Blake")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(4)))
//                        ), allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-2290340868")),
//                                Matchers.<Book>hasProperty("title", is("Le Spleen de Paris")),
//                                Matchers.<Book>hasProperty("unitPrice", is(1.9)),
//                                Matchers.<Book>hasProperty("editor", is("Librio")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(5)))
//                        ), allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-2035861566")),
//                                Matchers.<Book>hasProperty("title", is("Les fleurs du mal")),
//                                Matchers.<Book>hasProperty("unitPrice", is(3.33)),
//                                Matchers.<Book>hasProperty("editor", is("Larousse")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(5)))
//                        ), allOf(
//                                Matchers.<Book>hasProperty("isbn", is("978-2746054646")),
//                                Matchers.<Book>hasProperty("title", is("JSF mis en pratique avec Eclipse")),
//                                Matchers.<Book>hasProperty("unitPrice", is(32.76)),
//                                Matchers.<Book>hasProperty("editor", is("Editions ENI")),
//                                Matchers.<Book>hasProperty("author", hasProperty("id", is(6)))
//                        )
//                )
//        );
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