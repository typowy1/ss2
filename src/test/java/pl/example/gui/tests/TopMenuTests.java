package pl.example.gui.tests;

import org.testng.annotations.Test;
import pl.example.gui.pages.AboutUsPage;
import pl.example.gui.pages.TopMenuPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TopMenuTests extends BaseTest {

    TopMenuPage topMenuPage;
    AboutUsPage aboutUsPage;

    @Test
    public void isAboutUsLinkClickable() {
        topMenuPage = new TopMenuPage();
        topMenuPage.clickOnAboutUsLink();

        aboutUsPage = new AboutUsPage();
        assertThat(aboutUsPage.getTextFromHeadingH1()).isEqualTo("WE DELIVER\n" + "YOUR IDEAS");
    }
}
