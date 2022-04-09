package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CartPage extends BasePage{

    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    public static final By PRODUCT_IN_CART = By.cssSelector(".cart_item");
    String removeProductFromCart = "//div[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";
    String removeButton = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Test
    public void open() {
        driver.get(baseUrl + "/cart.html");
    }

    @Test
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Removing a product {nameProduct} from the shopping cart")
    public void removeProductFromCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(removeButton, nameProduct))).click();
    }

        @Test
    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Test
    public int getProductsCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }
}
