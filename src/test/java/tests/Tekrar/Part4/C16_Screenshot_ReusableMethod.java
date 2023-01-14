package tests.Tekrar.Part4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.day21.C01_ScreenshotReusableMethod;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C16_Screenshot_ReusableMethod {
    private static Logger logger = LogManager.getLogger(C01_ScreenshotReusableMethod.class.getName());

    @Test
    public void test01() throws IOException {
        logger.info("Hepsiburada sitesine gidilir");
        //hepsiburada sayfasina gidelim
        utilities.Driver.getDriver().get("https://www.hepsiburada.com");

        logger.info("Ekran goruntusu alinir");
        //sayfanin resmini aliniz
        ReusableMethods.getScreenshot("hepsiburada");

        logger.warn("driver kapatilir");
        //sayfayi kapatiniz
        utilities.Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        //amazon sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        pages.AmazonPage amazonPage = new AmazonPage();

        //Nutella aratiniz
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisi Webelementinin resmini aliniz
        ReusableMethods.getScreenshotWebElement("AramaSonucWE", amazonPage.aramaSonucWE);
    }
}