import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private final WebDriver driver;
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
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
