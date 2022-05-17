package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//li[contains(@class,'buttons__item ng')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal__content']")
    private WebElement popUpContent;

    @FindBy(xpath = "//rz-cart//button[@opencart]")
    private WebElement cartButton;

    @FindBy(xpath = "//button[contains(@class,'ng-star-inserted buy-button_state')]")
    private WebElement inCartButton;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement popUpClose;

    @FindBy(xpath = "//li[contains(@class,'buttons__item ng')]")
    private WebElement totalPrice;

    Actions actions = new Actions(driver);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        actions.moveToElement(addToCartButton).perform();
        addToCartButton.click();
    }

    public boolean getTotalPriceText() {
        totalPrice.getText();
        return false;
    }
    public void checkPopUp() {
        if (popUpContent.isDisplayed()) {
            popUpClose.click();
            cartButton.click();
        } else {
            inCartButton.click();
        }
    }
}