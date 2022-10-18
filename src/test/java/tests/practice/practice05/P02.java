package tests.practice.practice05;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class P02 extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        // 3. Açılır metni alın
        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        // 5. Açılır pencereyi kabul edin

        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//*[@id='button1']")).click();

        // 3. Açılır metni alın
        driver.switchTo().alert().getText();

        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedMessage = "I am an alert box!";
        Assert.assertEquals(expectedMessage, driver.switchTo().alert().getText());

        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();

    }
}
