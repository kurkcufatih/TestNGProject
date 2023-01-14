package tests.Tekrar.Part4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentaCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.io.ObjectInputFilter;

public class C18_ExtentTest_RaporluTest extends TestBaseReport {
    /*
   -https://www.bluerentalcars.com/ adresine git
   -login butonuna bas
   -test data user email: customer@bluerentalcars.com ,
   -test data password : 12345 dataları girip login e basın
   -login butonuna tiklayin
   -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    */
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Pozitif Test", "Gecerli kullanici adi ve sifre ile giris yapildi");

        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentacarUrl"));
        extentTest.info("Blue Rent a Car sitesine gidildi");

        //-login butonuna bas
        BlueRentaCarPage blueRentaCarPage = new BlueRentaCarPage();
        blueRentaCarPage.anaSayfaLogin.click();
        extentTest.info("Login butonuna basildi");

        //-test data user email: customer@bluerentalcars.com ,
        //-test data password : 12345 dataları girip login e basın
        //-login butonuna tiklayin
        blueRentaCarPage.email.sendKeys(ConfigReader.getProperty("blueRentaCarUserEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("blueRentaCarpassword"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanici email ve passwordlari girildi");
        extentTest.info("ikinci login butonuna basildi");

        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = blueRentaCarPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName, actualUserName);
        extentTest.pass("Sayfaya basarili sekilde giris yapildi");


    }
}
