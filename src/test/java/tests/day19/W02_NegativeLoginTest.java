package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class W02_NegativeLoginTest {
    BrcPage brcPage=new BrcPage();

    @Test
    public void yanlisSifre() {

        //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna bas
        brcPage.brcilkLoginButonu.click();

        //test data user email: customer@blurentalcars.com ,
        brcPage.brcemailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //test data password : 12345
        brcPage.brcpasswordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //login butonuna tikla
        brcPage.brcikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.brcikinciLoginButonu.isDisplayed());

    }

    @Test
    public void testName() {
    }
}
