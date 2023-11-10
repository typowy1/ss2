package pl.example.gui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.example.gui.driver.manager.DriverManager;
import propertiesConfig.ConfigurationProperties;

public class BaseTest {
    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverManager.getWebDriver().manage().window().maximize();
        DriverManager.getWebDriver().navigate().to(ConfigurationProperties.getProperty("gui", "app.url"));
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
