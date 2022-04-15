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

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening shopping cart")
    public void open() {
        driver.get(baseUrl + "/cart.html");
    }

    @Step("Click on the Continue shopping button")
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Click on the Checkout button")
    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Getting the count of products in the shopping cart")
    public int getProductsCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }

    @Step("Removing  a product {nameProduct} from the shopping cart")
    public void removeProductFromCart(String product) {
        driver.findElement(By.xpath(String.format(removeProductFromCart, product))).click();
    }


}
