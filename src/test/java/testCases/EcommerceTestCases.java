package testCases;

import Pages.formPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.base;

import java.io.IOException;
import java.net.MalformedURLException;

public class EcommerceTestCases extends base {
    AndroidDriver<AndroidElement> driver;
    public static AppiumDriverLocalService service;

//    @BeforeTest
//    public void getDriver() throws MalformedURLException {
//        service=startServer();
//        driver=capabilities("Ecom.apk");
//
//    }
    @Test
    public void PageObjecttestCase() throws IOException, InterruptedException {
        service=startServer();
        driver=capabilities("Ecom.apk");
        formPage form=new formPage(driver);
        form.fillForm("Ayush","Argentina");
        service.stop();
    }
//    @AfterTest
//    public void closeService(){
//        service.stop();
//    }


}
