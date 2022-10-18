package tests.practice.Practice07;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    @Test
    public void test01() throws InterruptedException {

        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webUniUrl"));

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        //Buradaki listeyi yapilacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak
        //gorebilmek amaciyla biz olusturduk.
        List<String> workList = new ArrayList<>(Arrays.asList("Kahvaltiyi Hazirla", "Bulasiklari Yika", "Bebekle Ilgilen", "Cocugun Odevlerine Yardim Et", "Selenium'a Calis", "Uyu"));
        Actions actions = new Actions(Driver.getDriver());
        for (String each : workList) {
            actions.click(webUniversityPage.adNewTodo).sendKeys(each).sendKeys(Keys.ENTER).perform();
        }

        //Tüm yapılacakların üzerini çiz.
        Thread.sleep(3000);
        List<WebElement> drawButtons = webUniversityPage.drawButtons;
        for (WebElement each : drawButtons) {
            each.click();
        }

        //Tüm yapılacakları sil.
        Thread.sleep(3000);
        List<WebElement> deleteButtons = webUniversityPage.deleteButtons;
        for (WebElement each : deleteButtons) {
            each.click();
        }

        //Tüm yapılacakların silindiğini doğrulayın.
        Assert.assertTrue(webUniversityPage.adNewTodo.getText().isEmpty());

    }
}
