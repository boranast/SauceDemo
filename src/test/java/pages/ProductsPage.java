package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    String productLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    By sort = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening products page")
    public void open() {
        driver.get(baseUrl + "/inventory.html");
    }

    @Step("Adding product {nameProduct} to shopping cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    @Step("Sorting products by {sort}")
    public void sort(String sorting) {
        WebElement sortingElement = driver.findElement(sort);
        new Select(sortingElement).selectByVisibleText(sorting);
    }
}