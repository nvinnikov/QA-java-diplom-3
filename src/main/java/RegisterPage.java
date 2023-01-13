import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    private final static By nameField = By.xpath(".//label[text()='Имя']/../input");
    private final static By emailField = By.xpath(".//label[text()='Email']/../input");
    private final static By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final static By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public final static By loginButton = By.xpath(".//a[text()='Войти']");
    public final static By loginError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegister(){
        driver.findElement(registerButton).click();
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void open() {
        driver.get(PAGE_URL);
    }
    public boolean loginErrorDisplayed(){
        return driver.findElement(loginError).isDisplayed();
    }


}

