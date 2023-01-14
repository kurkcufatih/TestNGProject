package tests.Tekrar.Part3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C14_NegatifTest {
    //Bir test method olustur NegativeLoginTest()
    //https://www.hotelmycamp.com/ adresine git
    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).
                sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
        Driver.closeDriver();

    }
}
