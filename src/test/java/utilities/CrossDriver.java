package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    public CrossDriver() {

    }

    static WebDriver driver;


    public static WebDriver getDriver(String browser) {

        //Eger browsera bir deger atanmamissa properties dosyasindaki browser calissin
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        //Testlerimizi xml file'dan farkli browser'lar ile calistirabilmek icin
        //getDriver() methoduna parametre atamamiz gerekir.

        if (driver == null) {
            switch (browser) {

                //CrossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
                //buraya parametre olarak girdigimiz degeri yazdik.

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome": //chrom'u acmadan testleri calistirir.
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
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
        if (driver != null) { // driver'a değer atanmışsa kapat
            driver.close();
            driver = null; // Kapandıktan sonra sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }
    }

    public static void quitDriver() {
        if (driver != null) driver.quit();
        driver = null;
    }
}
