package pages;

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

    public void open() {
        driver.get(baseUrl + "/inventory.html");
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    public void sort(String sorting) {
        WebElement sortingElement = driver.findElement(sort);
        new Select(sortingElement).selectByVisibleText(sorting);
    }
}