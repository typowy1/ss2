package pl.example.gui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pl.example.gui.driver.browser.Browser;
import pl.example.gui.driver.manager.DriverManager;
import propertiesConfig.ConfigurationProperties;

public class BaseTest {

    static final String APPLICATION_URL = ConfigurationProperties.getProperty("gui", "app.url");

    @Parameters("browser")
    //browserparametr z pliku gui_test_suite.xml, jeśli go nie będzie to testy uruchomia sie na przgladarcepodanej w propertiesach
    @BeforeMethod
    public void beforeTest(@Optional Browser browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverManager.getWebDriver().manage().window().maximize();
        DriverManager.getWebDriver().navigate().to(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
