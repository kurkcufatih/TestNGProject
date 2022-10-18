package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolPage {
    public TrendyolPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@class='user']")
    public WebElement user;

    @FindBy(xpath = "//*[@id='emaillogin']")
    public WebElement emailLogin;

    @FindBy(xpath = "//*[@id='passwordlogin']")
    public WebElement passwordLogin;

    @FindBy(xpath = "//h1[text()='MY ORDERS']")
    public WebElement myOrdersText;

    @FindBy(xpath = "//*[@class='trendyol-logo']")
    public WebElement trendyolLogo;
    @FindBy(xpath = "//*[@class='search-bar']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//div[@class='lazyload-wrapper '])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement kisisellestirmeButonu;
    @FindBy(xpath = "//*[@data-tracker='click:BasketImpression']")
    public WebElement sepeteEkleButtonu;

    @FindBy(xpath = "//*[@class='basket-preview-icon ']")
    public WebElement sepetLogosu;

    @FindBy(xpath = "//*[@class='checkout-btn']")
    public WebElement checkOutButtonu;




}
