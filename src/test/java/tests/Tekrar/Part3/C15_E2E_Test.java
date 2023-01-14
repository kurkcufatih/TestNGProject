package tests.Tekrar.Part3;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Tekrar.utils.ConfigReader;
import tests.pages.HmcPage;
import utilities.Driver;

public class C15_E2E_Test {
    @Test
    public void E2ETest() throws InterruptedException {
        // https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager
        //b. Password : Manager1!
        //5. Login butonuna tıklayın.

        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).
                sendKeys(Keys.ENTER).perform();

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin

        hmcPage.hotelManagement.click();
        Thread.sleep(2000);
        hmcPage.roomReservation.click();
        Thread.sleep(2000);
        hmcPage.addRoom.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8. Save butonuna tıklayın.
        Faker faker = new Faker();
        hmcPage.idUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").
                sendKeys(Keys.TAB).sendKeys("10/02/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("13/02/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").
                sendKeys(Keys.TAB).sendKeys("2").
                sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys("asdfghjk").
                sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(2000);
        Assert.assertTrue(hmcPage.roomReservationText.isDisplayed());

        //10. OK butonuna tıklayın.
        hmcPage.okButton.click();

    }
}
