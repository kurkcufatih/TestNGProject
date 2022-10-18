package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentaCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;


public class C01_RaporluTest extends TestBaseReport {
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
        extentTest = extentReports.createTest("Pozitif Test", "Geçerli kullanıcı adı ve password ile giriş yapıldı");


        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentacarUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");


        //-login butonuna bas
        BlueRentaCarPage blueRentaCarPage = new BlueRentaCarPage();
        blueRentaCarPage.anaSayfaLogin.click();
        extentTest.info("login butonuna basıldı");


        //-test data user email: customer@bluerentalcars.com ,
        //-test data password : 12345 dataları girip login e basın
        //-login butonuna tiklayin
        blueRentaCarPage.email.sendKeys(ConfigReader.getProperty("blueRentaCarUserEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("blueRentaCarpassword"))
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Doğru kullanıcı email ve password girildi");
        extentTest.info("Ikinci login butonuna basıldı");


        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = blueRentaCarPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName, actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");

    }
}