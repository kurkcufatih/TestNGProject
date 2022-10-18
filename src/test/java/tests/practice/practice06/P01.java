package tests.practice.practice06;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class P01 {
    @Test
    public void test01() {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        // Fill in capitals by country.

        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());

        /*
        actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.cophenhagen, dhtmlgoodiesPage.denmark).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.soutKorea).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden).perform();
        */

        actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway).
                dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain).
                dragAndDrop(dhtmlgoodiesPage.cophenhagen, dhtmlgoodiesPage.denmark).
                dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy).
                dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.soutKorea).
                dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates).
                dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden).perform();

        Driver.closeDriver();
    }


        /*
         * Frameworkler büyüdükçe yeni classlar yeni test methodları yeni webelementler olusturdukça içinden çıkılmaz
         * anlasılmaz, tekrar bakımı yapılamaz, güncellemesi çok zor hatta imkansız bir hal alır
         *
         * uzmanlar reusable maintainable, rahat manipule edilebilir bir framwork için bir design pattern olarak
         * POM PAGE OBJECT MODEL de karar vermisler
         * olmazsa olmazlar
         * 1) driver class
         * 2) PAGE class
         * 3) test class
         * utilities
         *
         * Aradığımız bir web elementi yada bir metohdu kolaylıkla bulabilmek ve güncelleyebilmek için
         * javadan öğrenmis olduğumuz oop concept selenium ile page object model de birlesitirilmis oluyuor
         *
         */
    /*
    PageFactory bizlere nesne deposu oluşturmaya imkan veren, sürdürülebilir,
    yeniden kullanılabilir ve elementleri tek bir yerden yönetmeyi sağlayan bir Page object model konseptidir.
    Page Factory’i kullanımına bakacak olursak PageFactory model, Web elementlerini
    @FindBy annotionu ile algılar. How kalıbı ile birlikte elementlerin ayırt edici
    locator’ından hangisini kullanacaksak belirtilir. Sonrasında ise o ayırt edici
    locator’ın adı tanımlanır. Public WebElement ile birlikte test senaryolarında
    kullanmak üzere isimlendirmesi yaparız. Burada isimlendirme daha sonra baktığında
    anlayabilmek için önemlidir, okunaklı olmalıdır.
     */
}
