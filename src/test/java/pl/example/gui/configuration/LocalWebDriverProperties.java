package pl.example.gui.configuration;

import pl.example.gui.driver.browser.BrowserType;
import properties.ConfigurationProperties;

public class LocalWebDriverProperties {

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperty("gui", "local.browser"));
    }

    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperty("gui", "chrome.driver.location");
    }

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperty("gui", "firefox.driver.location");
    }

    public static String getInternetExplorerWebDriverLocation() {
        return ConfigurationProperties.getProperty("gui", "ie.driver.location");
    }
}
