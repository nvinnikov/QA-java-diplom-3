import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    final static By bulkiButton = By.xpath(".//span[text()='Булки']/..");
    final static By souseButton = By.xpath(".//span[text()='Соусы']/..");
    final static By nachinkiButton = By.xpath(".//span[text()='Начинки']/..");
    final static By bulkiHeader = By.xpath(".//h2[text()='Булки']");
    final static By souseHeader = By.xpath(".//h2[text()='Соусы']");
    final static By nachinkiHeader = By.xpath(".//h2[text()='Начинки']");
    private final static By loginLkLink = By.xpath(".//p[text()='Личный Кабинет']");
    private final static By loginLkButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    public void clickLoginLkLink() {
        driver.findElement(loginLkLink).click();
    }

    public void clickLoginLkButton() {
        driver.findElement(loginLkButton).click();
    }

    public void clickBulkiButton() {
        driver.findElement(bulkiButton).click();
    }

    public void clickSouseButton() {
        driver.findElement(souseButton).click();
    }

    public void clickNachinkiButton() {
        driver.findElement(nachinkiButton).click();
    }

    public void findBulkiHeader() {
        driver.findElement(bulkiHeader);
    }

    public void findSouseHeader() {
        driver.findElement(souseHeader);
    }

    public void findNachinkiHeader() {
        driver.findElement(nachinkiHeader);
    }

}
