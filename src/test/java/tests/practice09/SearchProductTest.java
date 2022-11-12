package tests.practice09;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class SearchProductTest extends TestBaseRapor {

    SearchProductPage searchProductPage;
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void searchProductPage() throws InterruptedException {
        extentTest=extentReports.createTest("automationexcercise","Web automation");

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get("http://automationexercise.com");
        extentTest.info("Tarayici baslatildi");
        extentTest.info("'http://automationexercise.com' url'ine gidildi");
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        //TODO: Test case bizden hangi sayafayi dogrulammizi istiyorsa
        // TODO: o sayfadan unique olan bir seyi locate etmemiz lazim.(url olabilir.)
        String homeUrl = "https://automationexercise.com/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), homeUrl);
        extentTest.info("Ana sayfanın başarıyla görünür olduğu doğrulandi");

        searchProductPage = new SearchProductPage();

        // 4. 'Ürünler' butonuna tıklayın
        searchProductPage.productPageUrl.click();
        extentTest.info(" 'Ürünler' butonuna tıklandi");

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın]
        Assert.assertTrue(searchProductPage.allProductTitle.isDisplayed());

        //   String productPageUrl="https://automationexercise.com/products";
        //   Assert.assertEquals(Driver.getDriver().getCurrentUrl(),productPageUrl);
        extentTest.info(" Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiği doğrulandi");

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        searchProductPage.searchBox.sendKeys("blue top");
        searchProductPage.searchButton.click();
        //  actions.click(searchProductPage.searchButton).click().perform();  boyle de olur!!!!!
        extentTest.info(" Arama girişine ürün adı girildi ve ara düğmesine tıklandi");

        // 7. 'ARANAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(searchProductPage.searchProductTitle.isDisplayed());
       List<WebElement> urunListesi= searchProductPage.searchProductList;
        for (WebElement each : urunListesi
        ) {
            Assert.assertTrue(each.isDisplayed());
            Thread.sleep(500);
        }
        extentTest.info(" ARANAN ÜRÜNLER'in görünür olduğunu doğrulandi");
         //8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
          actions.click(searchProductPage.viewProduct).perform();
           Assert.assertTrue(searchProductPage.blueTop.isDisplayed());
        extentTest.pass("Aramayla ilgili ürünün (\"blue top\") görünür olduğu doğrulandı");

    }
}