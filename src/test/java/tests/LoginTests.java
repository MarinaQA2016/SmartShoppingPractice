package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTests extends TestBase{
    LoginPageHelper loginPage;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void loginNegative(){
        loginPage.loginToAppl("aaa","123");
        Assert.assertEquals(loginPage.getIncorrectAuthMessage(), "Authentification server error");
    }

}
