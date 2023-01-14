package tests.Tekrar.Part4;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.Tekrar.utils.ConfigReader;
import tests.Tekrar.utils.Driver;
import tests.pages.AmazonPage;

public class C19_DataProvider {
    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();
        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //Nutella için arama yapalım
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);

        //sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.nutellaSearchResult.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        utilities.Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"Java"}, {"selenium"}, {"samsung"}, {"iphone"}};
    }

    @Test(dataProvider = "aranacakKelimeler")
    public void test02(String kelimeler) throws InterruptedException {
        //amazona gidelim
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //java, selenium, samsung ve iphone icin arama yapalim
        Thread.sleep(2000);
        amazonPage.searchBox.sendKeys(kelimeler, Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.nutellaSearchResult.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));

        //sayfayi kapatalim
        Driver.closeDriver();
    }
}
