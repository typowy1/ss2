package pl.example.gui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.example.gui.waits.Waits;

public class AboutUsPage extends BasePage {

    @FindBy(css = ".et_pb_text_0 .et_pb_text_inner h1")
    private WebElement headingH1;

    public String getTextFromHeadingH1() {
        Waits.waitUntilElementIsClickable(headingH1);
        String headingH1Text = headingH1.getText();
        log().info("Returned warning text was: {}", headingH1Text);
        return headingH1Text;
    }
}
