package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test", "Gecerli kullanici adi ve password ile giris yapildi");

//-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("BlueRentalCar sitesine gidildi");

// -login butonuna bas
        BrcPage brc=new BrcPage();
        brc.brcilkLoginButonu.click();
        extentTest.info("Login butonuna basildi");

// -test data user email: customer@bluerentalcars.com ,

// -test data password : 12345 dataları girip login e basın
// -login butonuna tiklayin
        brc.brcemailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("brcValidPassword"))
                        .sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanici email ve user password girildi.");
        extentTest.info("Ikinci login butonuna basildi");

// -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=brc.basariliGiris.getText();
        String expectedUserName="John Walker";
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi.");
}
}
/*
Hatanin resmini RAPORDA görmek istersek  target altinda Rapor icinde yazdirilan resmin uzernie sag tiklayin --->
Open in --> uzerine gelin -->  Explorer tiklayin bilgisayardaki dosyaninzin icine yönleneceksiniz
oradan raporu cift tiklayin acilan yeni sayfada alta kucuk resim var uzerini tiklayin
ve karsimiza resim cikmis olacak .

 */