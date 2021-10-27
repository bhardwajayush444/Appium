package utilities;

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
}
