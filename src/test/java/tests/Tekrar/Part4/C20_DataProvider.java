package tests.Tekrar.Part4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentaCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C20_DataProvider {
    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"fthkrkc@hotmail.com", "12345"},
                {"fatihhkurkcuu@gmail.com", "45678"}, {"erol@gmail.com", "6789"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String userEmail, String password) {
        //https://www.bluerentalcars.com/ adresine git
        BlueRentaCarPage blueRentaCarPage = new BlueRentaCarPage();
        Driver.getDriver().get(ConfigReader.getProperty("bluerentacarUrl"));

        //login butonuna bas
        blueRentaCarPage.anaSayfaLogin.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        //login butonuna tiklayin
        blueRentaCarPage.email.sendKeys(userEmail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentaCarPage.login.isDisplayed());
    }
}
