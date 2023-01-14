package tests.Tekrar.Part4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Tekrar.utils.Driver;
import utilities.ReusableMethods;

public class C17_WindowHandle_ReusableMethods {
    @Test
    public void test01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();

        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "The Internet";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Driver.closeDriver();
    }
}
