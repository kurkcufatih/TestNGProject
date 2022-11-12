package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement brcilkLoginButonu;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement brcemailTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement brcpasswordTextBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement brcikinciLoginButonu;

    @FindBy(id = "dropdown-basic-button']")
    public WebElement kullaniciProfilIsmi;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement basariliGiris;



}
