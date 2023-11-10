package pl.example.gui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pl.example.gui.driver.manager.DriverManager;

import java.time.Duration;

public class Waits {

    WebDriver driver = DriverManager.getWebDriver();

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10), Duration.ofMillis(250));
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsLocated(By locator) {
        WebDriverWait webDriverWait = getWebDriverWait();
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail();
        }
    }

    public static void waitUntilElementIsLocatedInDom(By locator) {
        WebDriverWait webDriverWait = getWebDriverWait();
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static void waitUntilElementWillBeInvisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void pageLoadTimeout(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    public static void waitUntilElementIsClickableAndClickOnElement(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //#### StaleElementReferenceException ####
//    Trzeba zaincjalizować jeszcze raz element, zastosowanie ponniższej metody waitIfStaleElementReferenceException przy drugim inicjalizowaniu web elementu
//    WebElement element = driver.findElement(By.id("id"));
//    element = waitIfStaleElementReferenceException(By.id("id"));

    public static WebElement waitIfStaleElementReferenceException(By by) {
        WebDriverWait webDriverWait = getWebDriverWait();
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
