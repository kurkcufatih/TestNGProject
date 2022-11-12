package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    @Test
    public void test01() throws IOException {

        //Hepsiburada web sayfasina gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        //Sayfanin resmini aliniz
        ReusableMethods.getScreenshot("hepsiburada");

        //sayfayi kapat
        Driver.closeDriver();

    }

    @Test
    public void test02() throws IOException {
        //Amazon web sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        //Nutella arat
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisi Webelementinin resmini al
        ReusableMethods.getScreenshotWebElement("aramaSonucWebElementi", amazonPage.aramaSonucWebElementi);


    }
}
