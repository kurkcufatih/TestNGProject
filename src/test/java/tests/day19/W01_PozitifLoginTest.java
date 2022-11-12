package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class W01_PozitifLoginTest {
    BrcPage brcPage=new BrcPage();
    @Test
    public void positiveLoginTest() throws InterruptedException {

        //1 ) Bir Class olustur : PositiveTest
        //2) Bir test method olustur positiveLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna bas
        brcPage.brcilkLoginButonu.click();

        //test data user email: customer@blurentalcars.com ,
        brcPage.brcemailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 12345
        brcPage.brcpasswordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login butonuna tikla
        Thread.sleep(2000);
        brcPage.brcikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    }
}
