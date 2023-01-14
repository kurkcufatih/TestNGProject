package tests.Tekrar.Part1;

import org.testng.annotations.Test;
import tests.Tekrar.utils.TestBase_BeforeMethod_AfterMethod;

public class C01_BeforeMethod_AfterMethod extends TestBase_BeforeMethod_AfterMethod {
    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproeducationTest() {
        driver.get("https://www.techproeducation.com");
    }
}
