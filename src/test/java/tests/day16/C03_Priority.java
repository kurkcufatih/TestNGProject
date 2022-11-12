package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    //Testlerimizi calistiriken istedigimiz siraya gore calismasini istersek priority methodunu kullaniriz.
    // Priority kullanmazsak default olarak 0(sifir) kabul eder.
    @Test(priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");

    }

    @Test(priority = 3)
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test(priority = -1)
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");

    }
    @Test (groups = "grup1")
    public void techproeducationTest() {
        driver.get("https://www.techproeducation.com");

    }
        //Burada methodlarin calismasi sirasi hepsiburada, techproeducation, amazon ve bestbuy seklinde olacaktir.
}