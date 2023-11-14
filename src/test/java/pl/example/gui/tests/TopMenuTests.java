package pl.example.gui.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pl.example.gui.pages.AboutUsPage;
import pl.example.gui.pages.TopMenuPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TopMenuTests extends BaseTest {

    TopMenuPage topMenuPage;
    AboutUsPage aboutUsPage;

    @Issue("Bug 1") //id defektu, przekieruje do defektu
    @TmsLink("ID333") // id przypadku testowego, przekieruje do testu
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    @Description("Check if the About As tab will return the correct page")
    public void isAboutUsLinkClickable() {
        topMenuPage = new TopMenuPage();
        topMenuPage.clickOnAboutUsLink();
        aboutUsPage = new AboutUsPage();
        assertThat(aboutUsPage.getTextFromHeadingH1()).isEqualTo("WE DELIVER\n" + "YOUR IDEAS");
    }

    @Issue("Bug 2") //id defektu, przekieruje do defektu
    @TmsLink("ID444") // id przypadku testowego, przekieruje do testu
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    @Description("Check if the About As tab will return the correct page")
    public void isAboutUsLinkClickableNegative() {
        topMenuPage = new TopMenuPage();
        topMenuPage.clickOnAboutUsLink();
        aboutUsPage = new AboutUsPage();
        assertThat(aboutUsPage.getTextFromHeadingH1()).isEqualTo("WE DELIVER");
    }
}
