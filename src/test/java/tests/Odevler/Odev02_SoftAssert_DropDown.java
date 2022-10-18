package tests.Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Odev02_SoftAssert_DropDown extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() throws InterruptedException {
        //Yeni bir Class Olusturun :C03_SoftAssert
        //1.“http://zero.webappsecurity.com/”Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2.Sign in butonunabasin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3.Login kutusuna “username”yazin
        //4.Password kutusuna “password”yazin
        //5.Sign in tusunabasin
        WebElement userLogin = driver.findElement(By.xpath("//*[@id='user_login']"));
        actions.click(userLogin).sendKeys("username").sendKeys(Keys.TAB).sendKeys("password");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //6.Online banking menusu icinde Pay Bills sayfasina gidin

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //NOT: site hatali pay bill'e tiklayinca login sayfafina donuyor

        //7.“Purchase Foreign Currency” tusunabasin


        //8.“Currency” drop down menusunden Eurozone’usecin


        //9.soft assert kullanarak "Eurozone (Euro)" secildigini testedin


        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand(baht)"
    }
}
