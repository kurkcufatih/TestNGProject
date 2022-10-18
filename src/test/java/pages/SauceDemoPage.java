package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {

    public SauceDemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement userNameSD;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordSD;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginSD;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement filterSD;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement lowToHighVisible;

}
