package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class Tekrar03_Priority extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test (priority = 1)
    public void test02() {
    driver.get("https://www.techproeducation.com");
    }

    @Test (priority = 3)
    public void test03() {
    driver.get("https://trendyol.com");
    }

    @Test (priority = 2)
    public void test04() {
    driver.get("https://www.youtube.com");
    }
}
