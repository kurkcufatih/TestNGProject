package tests.Tekrar.Part2;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tests.pages.AmazonPage;
import utilities.Driver;

public class C09_AmazonClass {
    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);
    }
}
