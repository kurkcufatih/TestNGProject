package tests.practice.Practice09;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.TestBaseReport;

import java.util.List;

public class SearchProductTest extends TestBaseReport {
    // 1. Tarayıcıyı başlat
    // 2. 'http://automationexercise.com' url'sine gidin
    // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    // 4. 'Ürünler' butonuna tıklayın
    // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
    // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
    // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
    // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın

    @Test
    public void searchProductTest() throws InterruptedException {
        extentTest = extentReports.createTest("automationexercise", "web automation");

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin

        extentTest.info("   // 1. Tarayıcıyı başlat\n" +
                "        // 2. 'http://automationexercise.com' url'sine gidin");

        Driver.getDriver().get("https://automationexercise.com/");


        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String homeUrl = "https://automationexercise.com/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), homeUrl);
        extentTest.info("3. Ana sayfanın başarıyla görünür olduğunu doğrulayın");

        //NOT: her sayfanin kendine has linki ve title'i vardir
        // sayfa linki ve title'ni kullanarak dogrulama yapilabilir.

        // 4. 'Ürünler' butonuna tıklayın
        SearchProductPage searchProductPage = new SearchProductPage();
        searchProductPage.products.click();
        extentTest.info("4. 'Ürünler' butonuna tıklayın");

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(searchProductPage.allProductsTitle.isDisplayed());
        //Veya
        String productPageUrl = "https://automationexercise.com/products";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), productPageUrl);
        extentTest.info("5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın");


        // 6. Arama girişine ürün adını (blue top) girin ve ara düğmesine tıklayın
        searchProductPage.searchBox.sendKeys("blue");
        searchProductPage.searchButton.click();

        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(searchProductPage.searchedProducts.isDisplayed());
        List<WebElement> ürünlistesi = searchProductPage.searchedProductList;
        for (WebElement w:   ürünlistesi      ) {
            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(500);
        }

        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
        extentTest.pass("Aramayla ilgili ürünün (\"blue top\") görünür olduğu doğrulandı");
        Actions actions = new Actions(Driver.getDriver());
        actions.click(searchProductPage.viewProduct).perform();
        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());


    }
}
