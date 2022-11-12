package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class W03_SoftAssert extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {


        //1-"https://zero.webappsecurity.com/" adresine gidin
        driver.get(" http://zero.webappsecurity.com/");

        //2-sign in butonuna basın
        driver.findElement(By.id("signin_button")).click();

        //3-Login kutusuna "username" yazın
        WebElement loginKutusu=driver.findElement(By.xpath("//input[@name='user_login']"));
        loginKutusu.sendKeys("username");

        //4-Password kutusuna "password" yazın
        WebElement passKutusu=driver.findElement(By.xpath("//input[@id='user_password']"));
        passKutusu.sendKeys("password");

        //5-sign in tusuna basın
        driver.findElement(By.xpath("input[@name='submit']")).click();
        driver.navigate().back();

        //6-Online banking menusu içinde Pay Bills sayfasına gidin
        driver.findElement(By.xpath("//strong[@name='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7-"Purchase Foreing Currency" tusuna basın
        driver.findElement(By.xpath("//*[@text='Purchase Foreing Currency']")).click();

        //8-"Currency" drop down menusunden Eurozone 'u secin
        WebElement ddo = driver.findElement(By.xpath("//select[@name='currency']"));
        Select select = new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");

        //9-softassert kullanarak "Eurozone (Euro)" secildiğini test edin
        SoftAssert softAssert = new SoftAssert();
        String secilenOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (Euro)";
        softAssert.assertEquals( secilenOption,expectedOption,"secilen option uygun değil");

        //10-soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)",
        // "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand  (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"
        List<WebElement> optionList = select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China  (yuan)","Denmark (krone)","Eurozone (euro)",
                "Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));

        for (int i = 0; i <optionList.size() ; i++) {
            softAssert.assertEquals(optionList.get(i).getText(), expectedList.get(i),
                    "Listler birbirine esit degil");

        }
        softAssert.assertAll();

    }
    }

