package pl.example.gui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.example.gui.waits.Waits;

public class TopMenuPage extends BasePage {

    @FindBy(css = "ul#top-menu .menu-item-11035")
    private WebElement aboutUsLink;

    @Step("Click on About Us Link")
    public void clickOnAboutUsLink() {
        Waits.waitUntilElementIsClickable(aboutUsLink);
        aboutUsLink.click();
        log().info("Clicked on aboutUsLink");
    }
}
