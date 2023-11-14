package pl.example.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import pl.example.gui.driver.manager.DriverSetup;

public abstract class BasePage {
    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverSetup.getWebDriver(), this);
    }

    protected Logger log() {
        return logger;
    }
}
