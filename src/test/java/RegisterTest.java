import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;
public class RegisterTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/nvinnikov/Downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
    }
    @Test
    public void checkRegister(){
        Random random = new Random();
        String email = "something" + random.nextInt(10000000) + "@yandex.ru";
        String password = "password" + random.nextInt(10000000);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputName("Nikita");
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickRegister();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String newUrl = driver.getCurrentUrl();
        //Assert.assertEquals(LoginPage.PAGE_URL,newUrl);

    }
    @Test
    public void checkRegisterWrongPassword(){
        Random random = new Random();
        String email = "something" + random.nextInt(10000000) + "@yandex.ru";
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputName("Nikita");
        registerPage.inputEmail(email);
        registerPage.inputPassword("123");
        registerPage.clickRegister();
        Assert.assertTrue(registerPage.loginErrorDisplayed());
    }
    @After
    public void cleanUp() {
        driver.quit();
    }

}
