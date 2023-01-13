import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class AccountButtonTest {
    private WebDriver driver;
    private String email;
    private String password;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/nvinnikov/Downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        Random random = new Random();
        this.email = "something" + random.nextInt(10000000) + "@yandex.ru";
        this.password = "password" + random.nextInt(10000000);
        registerPage.inputName("Nikita");
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickRegister();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginLkButton();
        Assert.assertEquals(LoginPage.PAGE_URL, driver.getCurrentUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }
    @Test
    public void checkAccountButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLkLink();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        //Assert.assertEquals(AccountProfilePage.PAGE_URL, driver.getCurrentUrl());
    }
    @Test
    public void checkConstructorButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLkLink();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickConstructorButton();
        //Assert.assertEquals(MainPage.PAGE_URL, driver.getCurrentUrl());
    }
    @Test
    public void checkExitButton(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLkLink();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickExitButton();
        //Assert.assertEquals(LoginPage.PAGE_URL, driver.getCurrentUrl());
    }
}
