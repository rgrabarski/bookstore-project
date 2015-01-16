package com.bookstore.service.database;

import com.bookstore.entities.User;
import com.bookstore.service.IUserService;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserDBServiceTest extends AbstractDAOTestCase {

    private IUserService userService = new UserDBService();

    @Test
    public void testCreateUser() throws  Exception{
        User userToAdd = new User();
        userToAdd.setEmail("user@added.fr");
        userToAdd.setLogin("useradded");
        userToAdd.setPassword("useraddedp@ssw0rd");
        userService.createUser(userToAdd);

        User userFound = userService.findUserByLogin(userToAdd.getLogin());

        assertThat(userFound, allOf(
                Matchers.<User>hasProperty("email", is("user@added.fr")),
                Matchers.<User>hasProperty("login", is("useradded")),
                Matchers.<User>hasProperty("password", is("useraddedp@ssw0rd"))
        ));


    }

    @Test
    public void testFindUserByLogin() throws Exception {
        User userFound = userService.findUserByLogin("yhovart");

        assertThat(userFound, allOf(
                Matchers.<User>hasProperty("email", is("yhovart@gmail.com")),
                Matchers.<User>hasProperty("login", is("yhovart")),
                Matchers.<User>hasProperty("password", is("yhovartpwd"))
        ));
    }

    @Test
    public void testfindUserByLoginAndPwd() throws Exception {
        User userFound = userService.findUserByLoginAndPwd("yhovart", "yhovartpwd");

        assertThat(userFound, allOf(
                Matchers.<User>hasProperty("email", is("yhovart@gmail.com")),
                Matchers.<User>hasProperty("login", is("yhovart")),
                Matchers.<User>hasProperty("password", is("yhovartpwd"))
        ));
    }

}