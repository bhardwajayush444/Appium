package testCases;

import Pages.uiAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.base;
import utilities.utils;

import java.io.IOException;
import java.net.MalformedURLException;

public class uiAuotmatorTest extends base {
    AndroidDriver<AndroidElement> driver;
    public static AppiumDriverLocalService service;
    uiAutomator automatorPage;
    utils myUtilities;
//    @BeforeTest
//    public void startAndSetup() throws MalformedURLException {
//        service=startServer();
//        driver=capabilities("myApp.apk");
//        automatorPage=new uiAutomator(driver);
//        myUtilities=new utils(driver);
//    }

    @Test
    public void uiAutomatorSwipeTest() throws IOException, InterruptedException {
        service=startServer();
        driver=capabilities("myApp.apk");
        automatorPage=new uiAutomator(driver);
        myUtilities=new utils(driver);
        automatorPage.viewsButton.click();
        automatorPage.dateWidgestButton.click();
        automatorPage.inline.click();
        automatorPage.description9.click();
        myUtilities.swipeUsingAutomator(automatorPage.sourceSwipe,automatorPage.destinationSwipe);
        service.stop();
    }

//    @AfterTest
//    public void stopService(){
//        service.stop();
//    }


}
