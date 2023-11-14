package pl.example.gui.driver.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.example.gui.driver.manager.DriverSetup;
import propertiesConfig.ConfigurationProperties;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSetup {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    //określające typ przeglądarki
    private Browser browser;

    //określające czy uruchomienie jest zdalne czy lokalne
    private boolean isRemoteRun;

    //wartości pól browserType or isRemoteRun
    public BrowserSetup(Browser browser, boolean isRemoteRun) {
        this.browser = browser;
        this.isRemoteRun = isRemoteRun;
    }

    //Metoda dostarcza obiekt WebDrivera
    public WebDriver getBrowser() {

        //Sprawdzamy czy uruchomienie jest zdalne, jeśli tak to kod wejdzie do warunku
        if (isRemoteRun) {

            //wymagany do wyboru przeglądarki
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            //Wybór przeglądarki w zależności od wartości pola browserType
            switch (browser) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge(firefoxOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case IE:
                    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                    desiredCapabilities.merge(internetExplorerOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }

            //Jeśli uruchomienie nie jest zdalne, kod wchodzi do else. Jest to uruchomienie lokalne
        } else {

            switch (browser) {
                case CHROME:
//                System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("gui", "chrome.driver.location"));
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case FIREFOX:
//                System.setProperty("webdriver.gecko.driver", ConfigurationProperties.getProperty("gui", "firefox.driver.location"));
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case IE:
//                System.setProperty("webdriver.ie.driver", ConfigurationProperties.getProperty("gui", "ie.driver.location"));
                    WebDriverManager.firefoxdriver().setup();
                    return new InternetExplorerDriver();
                default:
                    throw new IllegalStateException("Unknown browser type! Please check your configuration");
            }
        }

    }

    //Metoda zwraca nam obiekt RemoteWebDrivera na podstawie obiektu desiredCapabilities
    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;

        try { //pobieranie adresu selenium grid z propertiesów
            remoteWebDriver = new RemoteWebDriver(new URL(ConfigurationProperties.getProperty("grid", "grid.url")), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }
}
