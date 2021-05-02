package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/fldLogin")
    WebElement loginInput;
    @FindBy(id = "club.conim.hahamim:id/fldEditPassword")
    WebElement passwordInput;
    @FindBy(id = "club.conim.hahamim:id/linkComeIn")
    WebElement comeIn;
    @FindBy(id = "android:id/message")
    WebElement incorrectAuthMessage;


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginInput,10);
        waitUntilElementIsClickable(passwordInput,10);
    }

    public void loginToAppl(String login, String password) {
        this.editField(loginInput,login);
        this.editField(passwordInput,password);
        comeIn.click();
    }

    public String getIncorrectAuthMessage() {
        this.waitUntilElementIsVisible(incorrectAuthMessage,10);
        return incorrectAuthMessage.getText();
    }
}
