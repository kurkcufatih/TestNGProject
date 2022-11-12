package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test01() {
        //Amazon ve facebook web sayfasina git
        String urlamazon=ConfigReader.getProperty("amazonUrl");
        String urlFacebook=ConfigReader.getProperty("facebookUrl");
        Driver.getDriver().get(urlamazon);
        Driver.getDriver().get(urlFacebook);
        Driver.closeDriver();


    }
}
