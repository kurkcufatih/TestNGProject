package tests.practice06;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class P01 {

        // Fill in capitals by country.


    @Test
    public void test01() {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage dhtmlgoodiesPage=new DhtmlgoodiesPage();
        Actions actions=new Actions(Driver.getDriver());

        //actions.dragAndDrop(dhtmlgoodiesPage.oslo,dhtmlgoodiesPage.norway).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.stockholm,dhtmlgoodiesPage.sweden).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.copenhagen,dhtmlgoodiesPage.denmark).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.rome,dhtmlgoodiesPage.italy).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.madrid,dhtmlgoodiesPage.spain).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.seoul,dhtmlgoodiesPage.southKorea).perform();
        //actions.dragAndDrop(dhtmlgoodiesPage.washington,dhtmlgoodiesPage.unitedStates).perform();

        actions.dragAndDrop(dhtmlgoodiesPage.oslo,dhtmlgoodiesPage.norway).
                dragAndDrop(dhtmlgoodiesPage.stockholm,dhtmlgoodiesPage.sweden).
                dragAndDrop(dhtmlgoodiesPage.copenhagen,dhtmlgoodiesPage.denmark).
                dragAndDrop(dhtmlgoodiesPage.rome,dhtmlgoodiesPage.italy).
                dragAndDrop(dhtmlgoodiesPage.madrid,dhtmlgoodiesPage.spain).
                dragAndDrop(dhtmlgoodiesPage.seoul,dhtmlgoodiesPage.southKorea).
                dragAndDrop(dhtmlgoodiesPage.washington,dhtmlgoodiesPage.unitedStates).perform();

        Driver.closeDriver();

        /*
        Framework'ler buyudukce yeni class'lar yeni test method'lari yeni webelementler olusturdukca
        icinden cikilmaz anlasilmaz, tekrar bakimi yapilamaz, guncellenmesi zor hatta imkfnsiz bir hal alir.

        Uzmanlar reusable maintainable, rahat manipule edilebilir bir framewoek icin bir design patterrn olarak
        POM PAGE OBJECT MODEL'de karar vermisler.

        1-driver class
        2-PAGE class
        3-test class
        4-utility class--

        Aradigimiz bir webelementi ya da bir method'u kolaylikla bulabilmek ve guncelleyebilmek icin
        javadan ogrenmis oldugumuz oop censept selenium ile page object model de birlestirilmis oluyor.
         */
    }
}
