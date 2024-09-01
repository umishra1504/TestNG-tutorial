package DemoTestNG;

import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {
    public void test1_BootstrapListBox(){
        System.out.println("Test Method 3: Bootstrap List Box");
    }

    public void test2_JQueryListBox(){
        System.out.println("Test Method 4: JQuery List Box");
    }

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
        System.out.println("Execute BEFORE CLASS: List Box");
    }

    // runs only once after everything
    @AfterClass
    public void afterClass(){
        System.out.println("Execute AFTER CLASS: List Box");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Execute BEFORE each TEST");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Execute AFTER each TEST");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Execute BEFORE the SUITE");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Execute AFTER the SUITE");
    }

    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups(){
        System.out.println("Execute BEFORE GROUP:");
    }

    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups(){
        System.out.println("Execute AFTER GROUP:");
    }
}
