package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PozitifTest {

    @Test
    public void pozitifTest() {


        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        HMCPage hmcPage=new HMCPage();
        //Page class'indaki locate'lerimize ulasabilmek icin Page class'imizdan bir obje olusturarak, olusturmus oldugumuz
        //obje ile page class'imizdaki locate'lerimize ulasbiliriz.
        hmcPage.login.click();

        //test data username: manager ,
        //test data password : Manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());

        Driver.closeDriver();
    }
}
