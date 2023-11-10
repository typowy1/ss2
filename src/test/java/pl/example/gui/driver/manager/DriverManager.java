package pl.example.gui.driver.manager;

import org.openqa.selenium.WebDriver;
import pl.example.gui.driver.browser.BrowserFactory;
import pl.example.gui.driver.browser.Browser;
import propertiesConfig.ConfigurationProperties;

import static pl.example.gui.driver.browser.Browser.FIREFOX;

public class DriverManager {
    private static WebDriver driver;
    private static boolean remoteRun = Boolean.parseBoolean(ConfigurationProperties.getProperty("grid", "is.remote.run"));
    private static Browser browser = Browser.valueOf(ConfigurationProperties.getProperty("gui", "browser"));
//  wzorzec projektowy gwarantujący istnienie tylko jednego obiektu danego rodzaju.

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new BrowserFactory(browser, remoteRun).getBrowser();
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!browser.equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
