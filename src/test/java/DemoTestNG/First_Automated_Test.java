package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class First_Automated_Test {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:/www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }

    @Test
    public void testTableSortAndSearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//div[@id=\"example_filter\"]//input[@type=\"search\"]"))
                .sendKeys("B. Greer");
    }

    @Test
    public void testBootstrapDatePicker(){
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.id("birthday")).sendKeys("15/04/2001");
    }
}
