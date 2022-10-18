package tests.day21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.log4J.Log4JTest2;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenshotReusableMethod {
    private static Logger logger = LogManager.getLogger(C01_ScreenshotReusableMethod.class.getName());

    @Test
    public void test01() throws IOException {
        logger.info("Hepsiburada sitesine gidilir");
        //hepsiburada sayfasina gidelim
        Driver.getDriver().get("https://hepsiburada.com");

        logger.info("Ekran goruntusu alinir");
        //sayfanin resmini aliniz
        ReusableMethods.getScreenshot("hepsiburada");

        logger.warn("driver kapatilir");
        //sayfayi kapatiniz
        Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        //amazon sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage amazonPage = new AmazonPage();

        //Nutella aratiniz
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisi Webelementinin resmini aliniz
        ReusableMethods.getScreenshotWebElement("AramaSonucWE", amazonPage.aramaSonucWE);
    }
}