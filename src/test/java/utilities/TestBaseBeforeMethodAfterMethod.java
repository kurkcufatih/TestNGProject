package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {
    protected WebDriver driver;
    protected Actions actions;
    protected String tarih;
        /*
        TestNG framework'unde @Before ve @After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
        Çalışma prensibi JUnit deki Before,After ile aynıdır
         */
    @BeforeMethod (groups = "group 1")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih =date.format(formatter);
    }
    @AfterMethod (groups = "group 1")
    public void tearDown() {
        //driver.quit();
    }
}