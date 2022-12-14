package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebstaurantStorePage {
    private WebDriver driver;

    public WebstaurantStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //find below all WebElements needed for the test
    @FindBy(id = "searchval")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='paging']//li")
    public List<WebElement> searchPages;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> allSearchResults;

    @FindBy(xpath = "//li[@class='inline-block leading-4 align-top rounded-r-md']")
    public WebElement nextPageBtn;

    @FindBy(xpath = "//input[@type='submit']")
    public List<WebElement> allFoundItems;

    @FindBy(xpath = "//select[@name='accessories']")
    public List<WebElement> selectClasses;

    @FindBy(xpath = "//*[text()='Add To Cart']")
    public WebElement lastFoundItem;

    @FindBy(xpath = "//*[(text()='View Cart')]")
    public WebElement cartIcon;

    @FindBy(xpath = "//span[@id='cartItemCountSpan']")
    public WebElement countOfItemsInTheCart;

    @FindBy(xpath = "//*[contains(@class,'empty')]")
    public WebElement emptyCartIcon;

    @FindBy(xpath = "//footer/button[1]")
    public WebElement confirmAddToCartBtn;

    @FindBy(xpath = "//div[@class='empty-cart__text']")
    public List<WebElement> emptyCartMessage;
}
