package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethod extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        //amazon anasayfasina gidelim
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //sonuc yazisinin amazon icerdigini test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
}
