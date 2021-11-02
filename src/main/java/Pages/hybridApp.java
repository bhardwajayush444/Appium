package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hybridApp {
    AndroidDriver<AndroidElement> driver;
    public hybridApp(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static String webContext="WEBVIEW_org.chromium.webview_shell";
    @FindBy(css = ".navbar-toggler-icon")
    public WebElement menuButton;

    @FindBy(css = "a[href='/angularAppdemo/products'][class='nav-link']")
    public WebElement productsLink;

    @FindBy(css="a[href='/angularAppdemo/products/3']")
    public WebElement devopsProduct;

    @FindBy(xpath = "//*[@class='add-to-cart btn btn-default']")
    public WebElement addToCart;

    @FindBy(css = "a[href='/angularAppdemo/cart']")
    public WebElement cartButton;

    @FindBy(css="button[class='btn btn-success']")
    public WebElement checkout;

    @FindBy(xpath = "//*[@id='InputName']")
    public WebElement inputName;

    @FindBy(xpath = "//*[@id='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='exampleInputEmail1']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='exampleInputPassword1']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='exampleCheck1']")
    public WebElement checkbox;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement successButton;

    public void hideKeybord(){
        driver.hideKeyboard();
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void javascriptClick(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }




}
