package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;
    SearchResultsPage searchResultsPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitVisibilityOfElement(30, homePage.getSearchByKeyword());
    }

    @When("User makes search by keyword {string}")
    public void clickSearchByKeywordKeyword(final String searchKeyword) {
        homePage.searchByKeyword(searchKeyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks search results page visibility")
    public void checkSearchResultsPageVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
    }

    @When("User makes search by brand {string}")
    public void clickSearchByBrandKeyword(final String brandKeyword) {
        searchResultsPage.searchByBrand(brandKeyword);
    }

    @And("User clicks brand button")
    public void clickBrandButton() throws InterruptedException {
        searchResultsPage.waitForPageLoadComplete(30);
        searchResultsPage.clickOnBrandButton();
    }

    @And("User clicks filter button")
    public void clickFilterButton() {
        searchResultsPage.waitForPageLoadComplete(30);
        searchResultsPage.clickOnFilterButton();
    }

    @And("User clicks expensive button")
    public void clickExpensiveButton() {
        searchResultsPage.clickOnExpensiveFilterButton();
    }

    @And("User click on product")
    public void clickOnProduct() {
        searchResultsPage.waitForPageLoadComplete(30);
        searchResultsPage.clickOnProductButton();
    }

    @And("User checks product page visibility")
    public void checkProductPageVisibility() {
        productPage = pageFactoryManager.getProductPage();
    }

    @And("User clicks 'Add to cart' button")
    public void clickOnAddToCart() {
        productPage.implicitWait(30);
        productPage.clickOnAddToCartButton();
    }

    @And("User checks cart pop-up visibility")
    public void checkPopUpVisibility() {
        productPage.checkPopUp();
    }

    @Then("User checks that total price in cart is not equals to {string}")
    public void checkThatTotalPriceNotEquals(final String totalPrice) {
        productPage.waitForPageLoadComplete(30);
        Assert.assertFalse(totalPrice, productPage.getTotalPriceText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}