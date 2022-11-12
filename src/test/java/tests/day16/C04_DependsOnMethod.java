package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethod extends TestBaseBeforeClassAfterClass{
    /*
    DependsOn Method test methodlarinin calisma siralamasina karismaz.
    SAdece bagli olan test, baglandigi testin sonucuna bakar, baglandigi test PASSED olmazsa,
    baglana test hic calismaz(ignore)
     */
    //TODO: dendsOnMethods'ta test adindan sonra virgul konularak priority ve sirasi yazilabilir.

    @Test
    public void test01() {
        //amazon ana sayfasina git.
        driver.get("https://www.Wamazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        //nutella arat
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        //sonuc yazisinin amazon icerdigini test et.
        assert !driver.findElement(By.cssSelector("div[class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText().contains("amazon");

    }

    @Test (groups = {"grup1, grup2"})
    public void test04() {
        System.out.println("Bak bu calisti");
    }
}
