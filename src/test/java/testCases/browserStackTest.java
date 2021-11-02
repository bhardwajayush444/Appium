package testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.base;

import java.net.MalformedURLException;

public class browserStackTest extends base {
    @Test(description = "Running my tests on browserstack")
    public void firstBrowserstacktest() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=browserStackDriver();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Julie");
        driver.hideKeyboard();

        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
        driver.findElementByXPath("//*[@text='Brazil']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        int size=driver.findElementsById("com.androidsample.generalstore:id/productAddCart").size();
        for(int i=0;i<size;i++){
            driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        int priceSize=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
        float sum=0;
        for(int i=0;i<priceSize;i++){
            String price=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
            sum+=Float.valueOf(price.substring(1));
        }
        String totalAmount=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        float Total=Float.valueOf(totalAmount.substring(2));
        Assert.assertEquals(sum,Total);
        driver.quit();


    }



}
