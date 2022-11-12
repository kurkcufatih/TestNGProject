package tests.day20_smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegatifTest {

    @Test
    public void yanlisKullanici() { //1. senaryo: yanlis kullanici dogru sifre


        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        // https://www.hotelmycamp.com/ adresine git

        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HMCPage hmcPage=new HMCPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
    }

    @Test
    public void yanlisSifre() { // 2. senaryo: dogru kullanici yanlis sifre
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HMCPage hmcPage=new HMCPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
    }


    @Test
    public void yanlisKullaniciSifre() { //3. senaryo : yanlis kullanici, yanlis sifre
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HMCPage hmcPage=new HMCPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
    }
}
