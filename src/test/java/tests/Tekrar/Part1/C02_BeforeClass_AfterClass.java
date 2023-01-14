package tests.Tekrar.Part1;

import org.testng.annotations.Test;
import tests.Tekrar.utils.TestBase_BeforeClass_AfterClass;

public class C02_BeforeClass_AfterClass extends TestBase_BeforeClass_AfterClass {
    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void testBuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void testTechpro() {
        driver.get("https://www.techproeducation.com");
    }
}
