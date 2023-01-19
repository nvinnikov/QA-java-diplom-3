import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final WebDriver driver;
    private final static By exitButton = By.xpath(".//button[text()='Выход']");
    private final static By constructorButton = By.xpath(".//p[text()='Конструктор']");
    final static By profileLink = By.xpath(".//a[text()='Профиль']");
    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}
