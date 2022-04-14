package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CheckoutTest extends BaseTest{

    @Test
    public void lastNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get(baseUrl + "/checkout-step-one.html");
        checkoutPage.loginToCheckout("Anastasiya","","1234");
        assertEquals(checkoutPage.getError(),"Error: Last Name is required");
    }
    @Test
    public void firstNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get(baseUrl + "/checkout-step-one.html");
        checkoutPage.loginToCheckout("","","");
        assertEquals(checkoutPage.getError(),"Error: First Name is required");
    }
    @Test
    public void postalCodeShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get(baseUrl + "/checkout-step-one.html");
        checkoutPage.loginToCheckout("Anastasiya","Borisova","");
        assertEquals(checkoutPage.getError(),"Error: Postal Code is required");
    }
}
