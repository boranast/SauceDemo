package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    BasePage basePage;
    public static final String USER = "standart_user";
    public static final String PASSWORD = "secret_sauce";

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        if(System.getProperty("browser", "chrome").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (System.getProperty("headless").equals("true"))
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if(System.getProperty("browser", "chrome").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        basePage = new BasePage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }

    }
}