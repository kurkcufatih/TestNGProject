package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'de Driver icin TestBase class'ina extends etmek yerine Driver class'indan static method'lar
    kullanilarak driver olusturup, ilgili ayarlarin yapilmasi ve en sonda driver'in kapatilmasi tercih edilmistir.

    POM'de Driver class'indaki getDriver()'in obje olusturularak kullanilmasini engellemek icin
    Singleton Pattern kullanimi benimsenmistir.

    Singleton PAttern: tekli kullanim, bir class'in farkli class'tan obje olusturularak kullanimini engellemek icin kullanilir.
    Bunu saglamak icin yapmamaiz gereken sey oldukca basit. Obje olusturmak icin kullanilan contructor'i
    private yaptigimizda baska class'larda Driver Class'indan obje olusturulmasi mumkun olmaz..
     */
    private Driver(){

    }

    static WebDriver driver;
    /*
    Testlerimizi calistirdigimizda her seferinde yeni driver olusturdugu icin her test methodu icin
    yeni bir pencere(driver) aciyor. Eger driver'a bir deger atanmamissa yani driver==null ise
    bir kere driver'i calistir diyerek bir kere if icini calistiracak ve driver artik bir kere
    calistigi icin ve deger atandigi icin null olmayacak ve direkt return edecek ve diger testlerimiz
    ayni pencere(driver) uzerinde calisacak.
     */

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {

        if (driver != null) {   // driver'a deger atanmissa
            driver.close();
            driver = null;   // kapandiktan sonraki acmalari garanti altina almak icin driver'i tekrar null yaptik.
        }
    }

    public static void quitDriver() {
        if (driver != null) {   // driver'a deger atanmissa
            driver.quit();
            driver = null;  // kapandiktan sonraki acmalari garanti altina almak icin driver'i tekrar null yaptik.
        }
    }

}