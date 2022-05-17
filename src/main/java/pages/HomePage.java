package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//input[contains(@class,'search-form')]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) { super(driver);}

    public void openHomePage(String url) {driver.get(url);}

    public WebElement getSearchByKeyword() {
        return searchInput;
    }

    public void searchByKeyword(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}