import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private final WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private final static By exitButton = By.xpath(".//button[text()='Выход']");
    private final static By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}
