import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final static By loginLkLink = By.xpath(".//p[text()='Личный Кабинет']");
    private final static By loginLkButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final static By bulkiButton = By.xpath(".//span[text()='Булки']/..");

    private final static By souseButton = By.xpath(".//span[text()='Соусы']/..");

    private final static By nachinkiButton = By.xpath(".//span[text()='Начинки']/..");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(PAGE_URL);
    }
    public void clickLoginLkLink(){
        driver.findElement(loginLkLink).click();
    }
    public void clickLoginLkButton(){
        driver.findElement(loginLkButton).click();
    }
    public void clickBulkiButton(){
        driver.findElement(bulkiButton).click();
    }
    public void clickSouseButton(){
        driver.findElement(souseButton).click();
    }
    public void clickNachinkiButton(){
        driver.findElement(nachinkiButton).click();
    }

}
