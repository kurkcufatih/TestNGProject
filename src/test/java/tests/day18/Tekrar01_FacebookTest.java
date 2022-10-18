package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tekrar01_FacebookTest {
    @Test
    public void test01() {
        //https://www.facebook.com/ adresine gidin
        String facebookUrl = ConfigReader.getProperty("faceUrl");
        Driver.getDriver().get(facebookUrl);

        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookies.click();

        //Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin
        Faker faker = new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.login.click();

        //Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());

    }
}
