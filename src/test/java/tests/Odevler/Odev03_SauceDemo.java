package tests.Odevler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Odev03_SauceDemo {
    @Test
    public void test01() {


        //1- Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        //2- Enter the username as standard_user
        SauceDemoPage sauceDemoPage = new SauceDemoPage();
        sauceDemoPage.userNameSD.sendKeys(ConfigReader.getProperty("userNameSD"));

        //3- Enter the password as   secret_sauce
        sauceDemoPage.passwordSD.sendKeys(ConfigReader.getProperty("passwordSD"));

        //4- Click on login button
        sauceDemoPage.loginSD.click();

        //5- Choose price low to high and verify that PRICE (LOW TO HIGH) is visible
        Select select = new Select(sauceDemoPage.filterSD);
        select.selectByVisibleText("Price (low to high)");
        Assert.assertTrue(sauceDemoPage.lowToHighVisible.isDisplayed());

    }
}

/*
-----Configuration.properities----

sauceDemoUrl=https://www.saucedemo.com/
userNameSD=standard_user
passwordSD=secret_sauce

----SauceDemoPage-----

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
 */