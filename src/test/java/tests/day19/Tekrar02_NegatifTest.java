package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tekrar02_NegatifTest {
    @Test
    public void test01() {
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //test data username: manager1 ,  test data password : manager1!
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
        Driver.closeDriver();

    }
}
