
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    private final static By emailField = By.xpath(".//input[@type='text']");
    private final static By passwordField = By.xpath(".//input[@type='password']");
    private final static By loginButton = By.xpath(".//button[text()='Войти']");
    public final static By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final static By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void clickForgotPassword(){
        driver.findElement(forgotPasswordButton).click();
    }
    public void clickRegister(){
        driver.findElement(registerButton).click();
    }
    public void open() {
        driver.get(PAGE_URL);
    }
}
