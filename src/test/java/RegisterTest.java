import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nvinnikov/Downloads/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
    }

    @Test
    public void checkRegister() {
        Random random = new Random();
        String email = "something" + random.nextInt(10000000) + "@yandex.ru";
        String password = "password" + random.nextInt(10000000);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputName("Nikita");
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickRegister();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(LoginPage.forgotPasswordButton));
        Assert.assertEquals(LoginPage.PAGE_URL, driver.getCurrentUrl());
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        api.LoginUser loginUser = new api.LoginUser(email, password);
        Response response = api.UserClient.postApiAuthLogin(loginUser);
        response.then().assertThat().body("success", equalTo(true))
                .and()
                .statusCode(200);
        String responseString = response.body().asString();
        Gson gson = new Gson();
        api.LoginUserResponse loginUserResponse = gson.fromJson(responseString, api.LoginUserResponse.class);
        String accessToken = loginUserResponse.getAccessToken();
        api.UserClient.deleteApiAuthUser(accessToken).then().assertThat().body("success", equalTo(true))
                .and()
                .body("message", equalTo("User successfully removed"))
                .and()
                .statusCode(202);

    }

    @Test
    public void checkRegisterWrongPassword() {
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
