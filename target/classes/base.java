package utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    private static configReader confReader;
    static Properties prop;
    public static AppiumDriverLocalService service;
    static AndroidDriver<AndroidElement> driver;

    public static void startEmualtor() throws IOException, InterruptedException {
        //String cmd="runas /profile /user:Administrator \"cmd.exe /C \\\"certutil -addstore ROOT  ";
       Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\emulator.bat");
        Thread.sleep(6000);
    }
    public AppiumDriverLocalService startServer(){
        boolean flag=checkIfServerIsRunnning(4723);
        if(!flag){
        service=AppiumDriverLocalService.buildDefaultService();
        service.start();
        }

        return service;
    }
    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
    public static AndroidDriver<AndroidElement> hybridAppBrowser() throws IOException, InterruptedException {
        confReader=new configReader();
        prop=confReader.init_properties();
        //String appName=prop.getProperty("appName");
        String device=prop.getProperty("deviceName");
        startEmualtor();


        DesiredCapabilities Dc=new DesiredCapabilities();
        Dc.setCapability(MobileCapabilityType.DEVICE_NAME,"AyushEmulator");
        Dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        Dc.setCapability("appPackage","org.chromium.webview_shell");
        Dc.setCapability("appActivity","org.chromium.webview_shell.WebViewBrowserActivity");
       // Dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        Dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),Dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");



        return driver;

    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
        confReader=new configReader();
        prop=confReader.init_properties();
        //String appName=prop.getProperty("appName");
        String device=prop.getProperty("deviceName");
        startEmualtor();

        File appDir=new File("src\\main\\resources");
        File app=new File(appDir,appName);
        DesiredCapabilities Dc=new DesiredCapabilities();
        Dc.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        Dc.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        Dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        Dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),Dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }

    public static void getScreenshot(String screenShotName) throws IOException {
        File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\"+screenShotName+".png"));

    }
    public static AndroidDriver<AndroidElement> browserStackDriver() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("browserstack.user", "ayushbhardwaj_l2S83W");
        caps.setCapability("browserstack.key", "cPP6Qba4epyGp7Bsq89X");

        // Set URL of the application under test
        caps.setCapability("app", "bs://0b91913a48cc9906f2302d5a781f3343377cff60");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy Note 10 Plus");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "Samsung test cases");
        caps.setCapability("build", "my appium build");
        caps.setCapability("name", "first_test");
        driver=new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        return driver;
    }


}
