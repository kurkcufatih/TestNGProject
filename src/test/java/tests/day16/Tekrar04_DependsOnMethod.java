package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class Tekrar04_DependsOnMethod extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        driver.get("https://trendyol.com");
    }

    @Test (dependsOnMethods = "test03")
    public void test04() {
        driver.get("https://www.youtube.com");
    }
}

