package testCases;

import Pages.hybridApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class chromeBrowserTest extends base {
    public static AppiumDriverLocalService service;
    AndroidDriver<AndroidElement> driver;
    @Test
    public void chromeBrowsertest() throws IOException, InterruptedException {
        service=startServer();
        driver=hybridAppBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hybridApp hyApp=new hybridApp(driver);
        driver.context(hybridApp.webContext);
        hyApp.menuButton.click();
        hyApp.productsLink.click();
        hyApp.scrollIntoView(hyApp.devopsProduct);
        hyApp.devopsProduct.click();
        hyApp.addToCart.click();
        hyApp.scrollIntoView(hyApp.cartButton);
        hyApp.cartButton.click();
        hyApp.scrollIntoView(hyApp.checkout);
        hyApp.javascriptClick(hyApp.checkout);

        hyApp.inputName.sendKeys("ayush");
        hyApp.hideKeybord();
        hyApp.lastName.sendKeys("Bhardwaj");
        hyApp.hideKeybord();
        hyApp.email.clear();
        hyApp.email.sendKeys("ayush@gmail.com");
        hyApp.hideKeybord();
        hyApp.password.sendKeys("ayush@1");
        hyApp.hideKeybord();
        hyApp.checkbox.click();
        hyApp.successButton.click();
        String success=driver.switchTo().alert().getText();
        Assert.assertTrue(success.contains("Cart is successfully Submitted"));
        service.stop();
    }
}
