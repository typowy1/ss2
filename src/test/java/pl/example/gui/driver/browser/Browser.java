package pl.example.gui.driver.browser;

public enum Browser {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    private final String browser;
    Browser(String browser) {
        this.browser = browser;
    }
}
