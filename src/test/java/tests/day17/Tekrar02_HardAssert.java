package tests.day17;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class Tekrar02_HardAssert extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() throws IOException {
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.isEnabled();
        //4-arama kutusuna Nuella yazıp aratın
        searchBox.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        driver.findElement(By.xpath("//*[text()='RESULTS']")).isEnabled();

        //6-arama sonucunun Nutella içerdigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Arama sonucu : " + aramaSonucu.getText());
        Assert.assertTrue(aramaSonucu.getText().contains("Nutella"));

        TakesScreenshot ts = (TakesScreenshot) driver;
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusu/Nutella.jpeg"));
    }
}
