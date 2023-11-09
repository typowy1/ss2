import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("https://www.google.pl/?hl=pl");

        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("google");
        driver.findElement(By.name("btnK")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("google"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
