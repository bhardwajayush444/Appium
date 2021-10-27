package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class formPage {
    AndroidDriver<AndroidElement> driver;
    public formPage(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleField;

    @AndroidFindBy(id="android:id/text1")
    public WebElement countriesDrop;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement letsSHopbtn;

    public void scrollTillCountry(String country){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));");

    }
    public void clickCountry(String country){
        String finalXpath="//*[@text='"+country+"']";
        driver.findElementByXPath(finalXpath).click();

    }

    public void fillForm(String name,String country){
        nameField.sendKeys(name);
        driver.hideKeyboard();
        femaleField.click();
        countriesDrop.click();
        scrollTillCountry(country);
        clickCountry(country);
        letsSHopbtn.click();
    }

}
