package pl.example.gui.driver.browser;

import io.qameta.allure.Step;
import pl.example.gui.driver.manager.DriverSetup;

public class PageUrl {

    @Step("Navigating to URL: {pageUrl}")
    public static void goToPage(String pageUrl) {
        DriverSetup.getWebDriver().navigate().to(pageUrl);
    }
}
