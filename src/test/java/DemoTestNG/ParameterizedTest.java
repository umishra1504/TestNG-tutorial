package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
    WebDriver driver;

    @Parameters({"URL"})
    @BeforeClass
    public void setUp(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // step: 1 - Load the AUT
        driver.get(url);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Testing is done!!");
    }

    @Test
    @Parameters({"Task", "TestResult"})
    public void testFileDownload(String task, String testResult){
        // step: 2 - Click the file download link
        driver.findElement(By.linkText("File Download")).click();

        // step: 3 - Enter data
        driver.findElement(By.id("textbox")).sendKeys(task +" Execution: " + testResult);

        // step: 4 - Click the generate file button
        driver.findElement(By.id("create")).click();

        // step: 5 - Click the download link
        driver.findElement(By.id("link-to-download")).click();
    }
}
