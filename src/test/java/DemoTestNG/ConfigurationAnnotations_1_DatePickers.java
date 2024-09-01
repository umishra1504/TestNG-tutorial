package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {
    @Test(groups = "smoke")
    public void test1_BootstrapDatePicker(){
        System.out.println("Test Method 1: Bootstrap Date Picker");
    }

    @Test(groups = {"regression", "e2e"})
    public void test2_JQueryDatePicker(){
        System.out.println("Test Method 2: JQuery Date Picker");
    }

    // runs each time before every test method
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Execute BEFORE each test METHOD");
    }

    // runs each time after every test method
    @AfterMethod
    public void afterMethod(){
        System.out.println("Execute AFTER each test METHOD");
    }


    // runs only once before any methods
    @BeforeClass
    public void beforeClass(){
        System.out.println("Execute BEFORE CLASS: Date Pickers");
    }

    // runs only once after everything
    @AfterClass
    public void afterClass(){
        System.out.println("Execute AFTER CLASS: Date Pickers");
    }
}
