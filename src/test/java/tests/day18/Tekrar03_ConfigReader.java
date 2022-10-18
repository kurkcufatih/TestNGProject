package tests.day18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tekrar03_ConfigReader {
    @Test
    public void test01() {

        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //test data username: manager ,
        //test data password : Manager1!
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());
        Driver.closeDriver();

    }
}
