package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Priority extends TestBaseBeforeClassAfterClass {
    /*
    Testlerimizi calistirirken istedigimiz siraya gore
    calistirmak istersek priority metodunu kullaniriz.
    Kullanmazsak muhtemelen alfabetik siralamaya gore
    calisacaktir.Priority kullanmazsak default olarak 0 alir.
     */

    @Test(priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }

    @Test // Burayı 0 kabul eder
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test(priority = -1, groups = "group 1")
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");
    }
}
