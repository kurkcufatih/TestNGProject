package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_SoftAssert extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {
        /*
        SoftAssert baslangic ve bitis satirlari arasindaki tu m assrtion'lari yaparak
        bitis olarak belirtmemiz gereken assretAll() methoduyla test methodumuzdaki butun assertionlari kontrol eder.
        Failed olan olursa assertion yaptigimiz method'un sonuna yazdigimiz mesaji bize consdolda verir.
         */
        SoftAssert softAssert=new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"girilen kelimeyi icermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "WE erisilemez");

        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"Sonuc WE goruntulenemedi");

        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor");
        softAssert.assertAll();

        System.out.println("Hata varsa burasi calismaz");
    }
}
