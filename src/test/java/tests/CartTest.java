package tests;

import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    @Test(description = "Проверка, что продукт может быть добавлен в корзину")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
    }


}