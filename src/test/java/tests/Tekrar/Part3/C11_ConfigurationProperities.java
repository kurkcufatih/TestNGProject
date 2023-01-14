package tests.Tekrar.Part3;

import org.testng.annotations.Test;
import tests.Tekrar.utils.ConfigReader;
import tests.Tekrar.utils.Driver;

public class C11_ConfigurationProperities {
    @Test
    public void test01() {
        //Amazon sayfasına ve facebook sayfasına gidiniz
        String urlAmazon = ConfigReader.getProperty("amznUrl");
        String urlFacebook = ConfigReader.getProperty("faceUrl");

        Driver.getDriver().get(urlAmazon);
        Driver.getDriver().get(urlFacebook);
        Driver.closeDriver();
    }
}
