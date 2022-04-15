package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(description = "Проверка, что продукт может быть добавлен в корзину")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        /*
        productsPage.removeProductFromCart("Sauce Labs Backpack");
        cartPage.clickCart();
        assertEquals(cartPage.getProductCount(), 2);
        */

    }


}