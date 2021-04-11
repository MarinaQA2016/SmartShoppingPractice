package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationTest {
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
                "C:/Marina/TelRan/Auto/Practice/SmartShopping/SmartShoppingPractice/apk/konim-hahamim-v0.8.4.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @Test
    public void applTets(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Text: " + driver
                .findElement(By.id("club.conim.hahamim:id/fldRememberMeCheck")).getText());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
