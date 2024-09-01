package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GeoLocation_SeleniumGrid {
    public WebDriver driver;
    private String username = "<username />";
    private String hub = "@hub.lambdatest.com/wd/hub";
    private String accssKey = "<access-key />";

    DesiredCapabilities caps = new DesiredCapabilities();

    @BeforeClass
    public void setUp(){
        caps.setCapability("build", "3.1");
        caps.setCapability("name", "Test GeoLocation");
        caps.setCapability("geoLocation", "IN");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "128.0");
        caps.setCapability("name", "Windows 11");

        caps.setCapability("network", true);
        caps.setCapability("network", true);
        caps.setCapability("network", true);

        try{
            driver = new RemoteWebDriver(new URL("https://"+
                    username+":"+accssKey+hub), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver.get("https://where-am-i.org/");
    }

    @Test
    public void testGeoLocation(){
        WebElement address = driver.findElement(By.id("address"));
        System.out.println("Address: "+address.getText());
    }
}
