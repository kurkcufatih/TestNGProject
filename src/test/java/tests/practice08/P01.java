package tests.practice08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuTestPage;
import utilities.Driver;

import java.util.List;

public class P01 {




    HerokuTestPage herokuTestPage;
    Actions actions;

    @Test
    public void test01() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        herokuTestPage=new HerokuTestPage();
        actions=new Actions(Driver.getDriver());
        //Kodlarimizi yazarken clean kod kapsaminda daha sade kod yazabilmek amaci ile her test methodu
        //icerisinde ayri bir object create etmektense bu object'i class seviyesinde instance olarak create edip
        //test method'larinda buna deger atamak ve kullanmak daha uygun bir yontemdir.

        herokuTestPage.onBlur.click();
        herokuTestPage.onClick.click();
        herokuTestPage.onClick.click();
        actions.contextClick(herokuTestPage.onContextMenu)
                .doubleClick(herokuTestPage.onDoubleClick)
                .click(herokuTestPage.onFocus)
                .click(herokuTestPage.onFocus)
                .click(herokuTestPage.onKeydown)
                .sendKeys(Keys.ENTER)
                .click(herokuTestPage.onKeyUp).sendKeys(Keys.ENTER)
                .click(herokuTestPage.onKeyPress).sendKeys(Keys.ENTER)
                .moveToElement(herokuTestPage.onMouseOver)
                .moveToElement(herokuTestPage.onMouseLeave)
                .moveToElement(herokuTestPage.onMouseOver)
                .click(herokuTestPage.onMouseDown).perform();

        Thread.sleep(2000);


    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        List< WebElement> clicked=herokuTestPage.evenTriggered;
        Assert.assertEquals(clicked.size(),11);

    }
}
