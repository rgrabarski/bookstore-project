package com.bookstore.service.database;

import com.bookstore.web.util.EMFListener;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAOTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDAOTestCase.class);

    protected static EntityManagerFactory emf;

    @BeforeClass
    public static void initClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("BookstorePU");
        EMFListener.setEmf(emf);
    }

    @AfterClass
    public static void closeClass() {
        emf.close();
        TestUtils.closeJDBCConnection();
    }

    @Before
    public void initTest() throws Exception {
        //ask dbUnit to store them in db
        TestUtils.reloadDbUnitData();
        LOGGER.debug("BEFORE TEST");
    }

    @After
    public void closeTest() {
        LOGGER.debug("AFTER TEST");
    }
}
