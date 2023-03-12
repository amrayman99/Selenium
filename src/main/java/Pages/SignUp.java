package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class SignUp extends BaseTest {
    public SignUp(WebDriver driver) throws IOException {
        super();

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@data-tooltip='My Account']")
    public WebElement MyAccountButton;

    @FindBy (linkText="Register")
    public WebElement RegistertButton;

    @FindBy (id="loginInputName")
    public WebElement FnameField;

    @FindBy (id="loginLastName")
    public WebElement LnameField;

    @FindBy (id="loginInputEmail")
    public WebElement EmailField;

    @FindBy (id="loginInputPassword")
    public WebElement PasswordField;

    @FindBy (xpath = "//*[text()='CREATE']")
    public WebElement CreateButton;

    @FindBy (xpath = "//*[text()='Password is too short (minimum is 5 characters)']")
    public WebElement ShortPassMsg;

    public void open_sign_up_page()  {
        MyAccountButton.click();
        RegistertButton.click();

    }
    public void url_assertion(){
        String actual_url= driver.getCurrentUrl();
        String expetced_url="https://townteam.com/";
        Assert.assertEquals(actual_url,expetced_url);
    }
}
