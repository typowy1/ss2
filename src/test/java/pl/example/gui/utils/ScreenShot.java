package pl.example.gui.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pl.example.gui.driver.manager.DriverSetup;

public class ScreenShot {
    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public static byte[] takeScreenShot() {
        byte[] screenshotFile = ((TakesScreenshot) DriverSetup.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }
}
