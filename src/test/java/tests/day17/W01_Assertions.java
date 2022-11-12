package tests.day17;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class W01_Assertions extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {
        //1-Amazon anadayfaya git
        driver.get("https://www.amazon.com");

        //2-title'in Amazon icerdigini test et
        String expectedTitle="amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //3-Arma kutusunun erisilebilir oldugunu test et
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        //4-arama kutusuna Nutella yazip aratin
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-samll a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        //6-arama sonucunun Nutella icerdigini test et
        Assert.assertTrue(sonucYaziElementi.getText().contains("Kutella"));



    }
}
