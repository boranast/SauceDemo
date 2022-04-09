package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] loginData() {
        return new Object[][]{
                {"standart_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"test", "secret_sauce","Epic sadface: Username and password do not match any user in this service"},
                {"standart_user", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Входящие данные для негативных тестов на логин")
    public void passwordShouldBeRequired(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error, "Сообщение об ошибке при логине некорректное");
    }


    @Test(description = "Проверка на правильность пароля")
    public void loginWithIncorrectPassword() {
        loginPage.open();
        loginPage.login("standart_user", "test");
        assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service");

    }


}