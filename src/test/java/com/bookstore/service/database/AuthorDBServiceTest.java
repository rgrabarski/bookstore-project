package com.bookstore.service.database;

import com.bookstore.entities.Author;
import com.bookstore.service.IAuthorService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AuthorDBServiceTest extends AbstractDAOTestCase {

    private IAuthorService authorService = new AuthorDBService();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        List<Author> authors = authorService.findAll();

        assertThat(authors, hasItems(
                        allOf(
                                Matchers.<Author>hasProperty("firstName", is("Merick")),
                                Matchers.<Author>hasProperty("lastName", is("Schincariol")),
                                Matchers.<Author>hasProperty("birthDate",
                                        comparesEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse("1981-12-28"))),
                                Matchers.<Author>hasProperty("id", is(1))
                        ),
                        allOf(
                                Matchers.<Author>hasProperty("firstName", is("Mike")),
                                Matchers.<Author>hasProperty("lastName", is("Keith")),
                                Matchers.<Author>hasProperty("birthDate",
                                        comparesEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse("1978-01-01"))),
                                Matchers.<Author>hasProperty("id", is(2))
                        )
                )
        );
    }
}