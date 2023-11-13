package pl.example.gui.driver.manager;

import org.openqa.selenium.WebDriver;
import pl.example.gui.driver.browser.Browser;
import pl.example.gui.driver.browser.BrowserFactory;
import propertiesConfig.ConfigurationProperties;

import static pl.example.gui.driver.browser.Browser.FIREFOX;

public class DriverManager {
    //  wzorzec projektowy gwarantujący istnienie tylko jednego obiektu danego rodzaju.
    private static WebDriver driver;
    private static boolean remoteRun = Boolean.parseBoolean(ConfigurationProperties.getProperty("grid", "is.remote.run"));
    private static Browser browser = Browser.valueOf(ConfigurationProperties.getProperty("gui", "browser"));

//    klasa do zarządzania zmiennymi, które mają być używane przez wiele wątków
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(browser, remoteRun).getBrowser());
        }

        //Zwrócenie instancji WebDrivera dla danego wątku
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if (!browser.equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}
