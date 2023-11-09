package pl.example.gui.driver.manager;

import org.openqa.selenium.WebDriver;
import pl.example.gui.configuration.LocalWebDriverProperties;
import pl.example.gui.driver.browser.BrowserFactory;
import pl.example.gui.driver.browser.BrowserType;

public class DriverManager {
    private static WebDriver driver;
//  wzorzec projektowy gwarantujący istnienie tylko jednego obiektu danego rodzaju.

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();

        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
