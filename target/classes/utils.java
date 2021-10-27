package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class utils {
    AndroidDriver<AndroidElement> driver;
    TouchAction tc;
    public utils(AndroidDriver<AndroidElement> driver){
        this.driver=driver;

    }

    public void swipeUsingAutomator(WebElement source,WebElement destination){
        tc=new TouchAction(driver);
        tc.longPress(longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(2))).moveTo(element(destination)).release().perform();
    }
}
