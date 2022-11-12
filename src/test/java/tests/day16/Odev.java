package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Odev extends TestBaseBeforeMethodAfterMethod {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin

    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    @Test (groups = "grup2")
    public void test01() {
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");


    }
}
