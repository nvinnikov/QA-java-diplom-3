import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nvinnikov/Downloads/WebDriver/bin/chromedriver");
    }

    @Test
    public void checkLoginLkButton() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickNachinkiButton();
        mainPage.clickBulkiButton();
        mainPage.clickNachinkiButton();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
