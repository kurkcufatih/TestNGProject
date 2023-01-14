package tests.Tekrar.Part1;

import org.testng.annotations.Test;
import tests.Tekrar.utils.TestBase_BeforeClass_AfterClass;

public class C03_Priority extends TestBase_BeforeClass_AfterClass {
    /*
    Testlerimizi calistirirken istedigimiz siraya gore
    calistirmak istersek priority metodunu kullaniriz.
    Kullanmazsak muhtemelen alfabetik siralamaya gore
    calisacaktir.Priority kullanmazsak default olarak 0 alir.
     */

    //ucuncu olarak bunu acti
    @Test(priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }

    //ikinci olarak bunu acti
    @Test
    public void bestBuy() {
        driver.get("https://www.bestbuy.com");
    }
    //son olarak bunu acti
    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    //ilk bunu acti
    @Test(priority = -1, groups = "group 16")
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");
    }
}
