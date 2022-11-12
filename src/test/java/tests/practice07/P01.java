package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    @Test
    public void test01() throws InterruptedException {

        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebDUniversityPage webDUniversityPage=new WebDUniversityPage();
        //TODO:Buradaki listeyi yapilacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak
        //TODO: gonderebilmek amaciyla biz olusturduk.
        List<String> workList=new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla","Bulaşıkları yıka","Bebekle ilgilen","Çocuğunun ödevine yardım et","Selenyum çalış","Uyu"));
        Actions actions=new Actions(Driver.getDriver());
        for (String each:workList    ) {
            webDUniversityPage.adNewTodo.click();
            actions.click(webDUniversityPage.adNewTodo).sendKeys(each).sendKeys(Keys.ENTER).perform();
        }

        //Tüm yapılacakların üzerini çiz.
        List<WebElement> todos=webDUniversityPage.todosWebElement;
        for (WebElement each:todos ) {
            each.click();

        }
        //Tüm yapılacakları sil.
        List <WebElement> silButonu=webDUniversityPage.silButonuWebElement;
        for (WebElement eac:silButonu  ) {
            eac.click();
        }

        //Tüm yapılacakların silindiğini doğrulayın.
        Thread.sleep(2000);

        List<WebElement> newTodos=webDUniversityPage.newtodosWebElement;
        Assert.assertEquals(0,newTodos.size());

        //EXPLORATORY TESTING (kesif testi) :
    }
}
