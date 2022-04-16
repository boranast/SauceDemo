package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CheckoutTest extends BaseTest {


    @DataProvider(name = "Incoming data for checkout test")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", "test", "12345", "Error: First Name is required"},
                {"test", "", "12345", "Error: Last Name is required"},
                {"test", "test", "", "Error: Postal Code is required"}
        };
    }

    @Test(description = "Проверка необходимости ввода всех персональных данных во время чекаута", dataProvider = "Incoming data for checkout test")
    public void allDataShouldBeRequiredDuringCheckout(String firstName, String lastName, String postalCode, String error) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        driver.get(baseUrl + "/checkout-step-one.html");
        checkoutPage.loginToCheckout(firstName, lastName, postalCode);
        assertEquals(checkoutPage.getError(), error, "Error didn't occurred");
    }
}