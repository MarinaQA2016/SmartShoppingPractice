package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    AppiumDriver driver;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        //capabilities.setCapability("platformVersion", "9.0");
        //-----AndroidStudio emulator---------------------
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("appPackage", "club.conim.hahamim");
        capabilities.setCapability("appActivity",".activities.MainActivity");
        capabilities.setCapability("automationName","Uiautomator2");
        capabilities.setCapability("app",
                "C:/Marina/TelRan/Auto/Practice/SmartShopping/SmartShoppingPractice/apk/konim-hahamim-v0.9.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
