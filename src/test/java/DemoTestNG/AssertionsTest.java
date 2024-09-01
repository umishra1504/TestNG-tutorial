package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Testing done!!");
    }

    @Test
    public void testSingleCheckBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMessage = driver.findElement(By.id("txtAge")).getText();

        Assert.assertTrue(actualMessage.contains("Checked"), "\n Message does not contain success \n");
    }

    @Test
    public void testRadioButton(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Other']")).click();
        driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();

        String actualGender = driver.findElement(By.xpath("//span[@class='genderbutton']")).getText();
        String actualAge = driver.findElement(By.xpath("//span[@class='groupradiobutton']")).getText();

        softAssert.assertEquals(actualGender,"Other" , "\n Actual Gender is not correct \n");
        softAssert.assertEquals(actualAge, "5 - 15","\n Actual Age is not correct \n");
        softAssert.assertAll("\n Test Soft Assert");
    }
}
