package com.umishra.tests;

import com.umishra.tests.pages.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testProgressBarPercentage(){
         progressBarPage = homePage.clickBootstrapProgressBar();
         progressBarPage.clickStartDownloadButton();

         String actualMessage = progressBarPage.getCompletedMessage();
         String actualPercentage = progressBarPage.getProgressBarPercentage();

         String expectedMessage = "Download completed!";
         String expectedPercentage = "100%";
         softAssert.assertEquals(actualMessage, expectedMessage, "\n  The message is not correct \n");
         softAssert.assertEquals(actualPercentage, expectedPercentage, "\n Percentage is not 100% \n");

         softAssert.assertAll();
    }
}
