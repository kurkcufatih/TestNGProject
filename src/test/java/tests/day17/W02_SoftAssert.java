package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class W02_SoftAssert extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        /*
        Sofassertion baslangic ve bitis satirlari arasaindaki tum assertionlari yapip bitis satirina geldiginde
        bize buldugu tum hatalari rapor eder.
         */
        //Softassert'in baslangici obje olusturmaktir.
        SoftAssert softAssert=new SoftAssert();

        //1-Amazon anadayfaya git
        driver.get("https://www.amazon.com");

        //2-title'in Amazon icerdigini test et
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        //3-Arma kutusunun erisilebilir oldugunu test et
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "arama kutusuna erisilemiyor");

        //4-arama kutusuna Nutella yazip aratin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(), "arama yapilamadi");

        //6-arama sonucunun Nutella icerdigini test et
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Nutella"), "sonuc yazisi Kutella icermiyor.");


        //softAssert'e bitis satirini soylemek icin assertAll() kullanilir.
        //Bu satir yazilmazsa assertion gorevi yapilmamis olur.
        softAssert.assertAll();

        /*
        Softassert'un hata bulsa bile calsimaya devam etme ozelligi assertAll()'a kadardir.
        Eger assrtAll()'da failed rapor edilirse calisma durur ve class'in kalan kismi calistirilmaz.
        Yani assertAll() hardAssert'teki herbir assert gibidir, hatayi yakalarsa calisma durur.
         */

        System.out.println("Assertion'larda fail olan olursa burasi calismaz");


    }
}
