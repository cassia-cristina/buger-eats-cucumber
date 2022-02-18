package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static boolean headless;

    public Driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void attToBeNotEmpty(WebElement element) {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
    }

    public static void visibilityElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
