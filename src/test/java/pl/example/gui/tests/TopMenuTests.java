package pl.example.gui.tests;

import org.testng.annotations.Test;
import pl.example.gui.pages.AboutUsPage;
import pl.example.gui.pages.TopMenuPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TopMenuTests extends BaseTest {
    @Test
    public void isAboutUsLinkClickable() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnAboutUsLink();

        AboutUsPage aboutUsPage = new AboutUsPage();
        assertThat(aboutUsPage.getTextFromHeadingH1()).isEqualTo("WE DELIVER\n" + "YOUR IDEAS");
    }

    @Test
    public void isAboutUsLinkClickable2() {
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnAboutUsLink();

        AboutUsPage aboutUsPage = new AboutUsPage();
        assertThat(aboutUsPage.getTextFromHeadingH1()).isEqualTo("WE DELIVER\n" + "YOUR IDEAS");
    }

}
