package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class uiAutomator {
    AndroidDriver<AndroidElement> driver;
    public uiAutomator(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(uiAutomator = "text(\"Views\")")
    public WebElement viewsButton;
    @AndroidFindBy(uiAutomator = "text(\"Date Widgets\")")
    public WebElement dateWidgestButton;

    @AndroidFindBy(uiAutomator = "text(\"2. Inline\")")
    public WebElement inline;

    @AndroidFindBy(xpath = "//*[@content-desc='15']")
    public WebElement sourceSwipe;

    @AndroidFindBy(xpath = "//*[@content-desc='45']")
    public WebElement destinationSwipe;

    @AndroidFindBy(xpath = "//*[@content-desc='9']")
    public WebElement description9;

}
