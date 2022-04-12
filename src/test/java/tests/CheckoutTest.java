package tests;

import org.testng.annotations.Test;



public class CheckoutTest extends BaseTest{

    @Test(description = "Проверка функциональности покупки товара", retryAnalyzer = Retry.class)
    public void checkout() {
        loginPage.open();
        loginPage.login("user", "password");
        productsPage.addToCart("Sauce Labs Backpack");
        /*
        cartPage.clickCart();
        cartPage.checkout();
        cartPage.fillInCheckoutInfo("test", "test", "12345");
        assertEquals(cartPage.getTotalPrice(), "32.39");
        cartPage.finish();
        assertEquals(cartPage.getCompleteTitle(), "CHECKOUT: COMPLETE!");
         */

    }
}
