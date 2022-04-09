package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("test", "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginPage.open();
        loginPage.login("standart_user", "test");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginWithInCorrectPassword() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service");

    }
}