package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
public class LogIn extends BaseTest {

    public LogIn(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Sign In")
    public WebElement RegisterButton;

    @FindBy(partialLinkText = "Log Out")
    public WebElement LogOutButton;

    @FindBy(id = "loginInputName")
    public WebElement LoginEmailField;

    @FindBy(id = "loginInputEmail")
    public WebElement LoginPassField;

    @FindBy (xpath = "//button[@class='btn btn-border']")
    public WebElement LogInButton;

    @FindBy (xpath = "//*[text()='Incorrect email or password.']")
    public WebElement InCorrectEmailOrPassMessage;

    @FindBy (xpath = "//*[text()='Email can't be blank and has already been taken.']")
    public WebElement Email_can_not_be_blank_Message;

    @FindBy (xpath = "//*[text()='MY ACCOUNT']")
    public WebElement MyAccAfterLogInText;


}