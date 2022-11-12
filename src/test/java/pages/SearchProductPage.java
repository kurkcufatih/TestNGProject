package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchProductPage {
    public SearchProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//*[text()=' Products']")
    public WebElement productPageUrl;

    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProductTitle;


    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchBox;


    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchProductTitle;

    @FindBy(linkText = "View Product")
    public WebElement  viewProduct;


    @FindBy(xpath = "(//h2)[3]")
    public WebElement blueTop;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public List<WebElement> searchProductList;
}
