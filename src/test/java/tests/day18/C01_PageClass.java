package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClass {



    @Test (groups = "grup1")
    public void test01() {

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com");

        //2 POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        FacebookPage facebookPage=new FacebookPage();

        //3 Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();

        //4 Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadi.isDisplayed());

        Driver.closeDriver();
    }
}
