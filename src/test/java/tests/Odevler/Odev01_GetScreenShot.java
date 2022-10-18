package tests.Odevler;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;


import java.io.File;
import java.io.IOException;

public class Odev01_GetScreenShot {


    @Test
    public void test01() throws IOException {
        //1-Amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //2-Amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        //3-Nutella icin aramayapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //4-sonucun Nutella icerdigini test edin ve ilk urunun goruntusunualin
        File amazonNutellaAramaSonucuUrun1 = amazonPage.NutellaUrunSonucu1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(amazonNutellaAramaSonucuUrun1,new File("target/ekranGoruntusu/NutellaAramaSonucuIlkUrun.jpeg"));
    }
}
