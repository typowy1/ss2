package pl.example.gui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.example.gui.configuration.AppProperties;
import pl.example.gui.driver.manager.DriverManager;
import pl.example.gui.driver.manager.DriverUtils;

public class BaseTest {
    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(AppProperties.getUrl());
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
