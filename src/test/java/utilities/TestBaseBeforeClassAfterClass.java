package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {
    protected WebDriver driver;

    /*
    @BeforeClass ve @AfterClass notasyonlarini TestNG'de
    kullanirken JUnitteki gibi static yapmaya gerek yok.
     */
    @BeforeClass (groups = "group 1")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass (groups = "group 1")
    public void tearDown() {
        //driver.quit();
    }
}