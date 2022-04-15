package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By USER_NAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.name("login-button");

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By FIRST_NAME = By.cssSelector("#first-name");
    public static final By LAST_NAME = By.cssSelector("#last-name");
    public static final By ZIP_CODE = By.cssSelector("#postal-code");
    public static final By CONTINUE_BUTTON = By.name("continue");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening checkout page")
    public void open() {
        driver.get(baseUrl + "/checkout-step-one.html");
    }

    @Step("Filling in the login information: username - '{username}', password - '{password}' ")
    public void login(String user, String password) {
        driver.findElement(USER_NAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("\"Filling checkout information: First Name - '{firstName}', Last Name - '{lastName}', Zip code - '{ZipCode}'\"")
    public void loginToCheckout(String first_name, String last_name, String zip_code) {
        driver.findElement(FIRST_NAME).sendKeys(first_name);
        driver.findElement(LAST_NAME).sendKeys(last_name);
        driver.findElement(ZIP_CODE).sendKeys(zip_code);
        driver.findElement(CONTINUE_BUTTON).click();

    }

    @Step("Getting error message")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}