package tests.Odevler;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Test;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;


public class TrendyolPozitifTest implements ITestListener {
    @Test
    public void test01() throws InterruptedException {

        // https://www.trendyol.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("trdyUrl"));
        TrendyolPage trendyolPage = new TrendyolPage();

        // login butonuna bas
        trendyolPage.user.click();

        //Kisisel bilgileriniz ile giris yapin
        trendyolPage.emailLogin.sendKeys(ConfigReader.getProperty("trdylUserName"));
        trendyolPage.passwordLogin.sendKeys(ConfigReader.getProperty("trdylPassword"), Keys.ENTER);
        Thread.sleep(3000);
        trendyolPage.user.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(trendyolPage.myOrdersText.isDisplayed());

        // pant aratiniz
        Thread.sleep(3000);
        trendyolPage.trendyolLogo.click();
        trendyolPage.aramaKutusu.sendKeys("pant", Keys.ENTER);

        // ilk siradaki urunu sepete ekleyin
        trendyolPage.ilkUrun.click();
        Thread.sleep(3000);
        trendyolPage.kisisellestirmeButonu.click();
        trendyolPage.sepeteEkleButtonu.click();
        Thread.sleep(3000);

        // sepete gidip urunun sepete eklendigini test edin
        trendyolPage.sepetLogosu.click();
        Assert.assertTrue(trendyolPage.checkOutButtonu.isDisplayed());

    }
}
