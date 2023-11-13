package pl.example.gui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.example.gui.driver.manager.DriverManager;
import pl.example.gui.waits.Waits;
import propertiesConfig.ConfigurationProperties;

import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", ConfigurationProperties.getProperty("gui", "chrome.driver.location"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to(ConfigurationProperties.getProperty("gui", "app.url"));

        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("google");
        driver.findElement(By.name("btnK")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("google"));
    }

    @Test
    public void myFirstTest2() {
        driver.navigate().to(ConfigurationProperties.getProperty("gui", "app.url"));

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
