package pl.example.gui.commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pl.example.gui.driver.listeners.DriverEventListener;
import pl.example.gui.driver.manager.DriverManager;
import pl.example.gui.waits.Waits;

import java.util.List;
import java.util.Random;



public class CommonMethods {
    WebDriver driver = DriverManager.getWebDriver();
    private static Logger logger = LogManager.getLogger(CommonMethods.class);

    public static void clickCheckBox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public static String replaceUnnecessaryNumber(WebElement element, int startFrom, int quantity) {
        String correctNumber = element.getText().replace(" ", "")
                .substring(startFrom, element.getText().length() - quantity).trim();
        return correctNumber;
    }

    public List<WebElement> getElementsListByLocator(By by) {
        List<WebElement> listOfElements = driver.findElements(by);
        logger.info("Elements list size = " + listOfElements.size());
        return listOfElements;
    }

    public WebElement getRandomElement(WebElement element, By locator) {
        Waits.waitUntilElementIsVisible(element);
        List<WebElement> elementsList = driver.findElements(locator);
        Assert.assertTrue(elementsList.size() > 0, "Elements list is not found");
        logger.info("Size of the elements list: " + elementsList.size());
        Random random = new Random();
        int randomValue = random.nextInt(elementsList.size());
        WebElement rootItem = elementsList.get(randomValue);
        return rootItem;
    }
}
