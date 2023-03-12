package PagesTestCases;

import Pages.SignUp;
import Util.TestNG_Listener;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpTests extends BaseTest {
    SignUp signup;

    public SignUpTests() throws IOException {
    }

    @Test(priority = 1, groups = {"E2E"})
    public void sign_up_with_valid_data() throws IOException {
        signup=new SignUp(driver);

        signup.open_sign_up_page();
        signup.FnameField.sendKeys("Ahmed");
        signup.LnameField.sendKeys("Mohamed");
        signup.EmailField.sendKeys("amrayman19909@gmail.com");
        signup.PasswordField.sendKeys("1234567891z");
        signup.CreateButton.click();
        wait.until(ExpectedConditions.titleIs("TOWN TEAM – Town Team"));
           }

    @Test(priority = 2, groups = {"E2E"})
    public void sign_up_with_valid_data_and_invalid_password() throws IOException {
        signup=new SignUp(driver);

        signup.open_sign_up_page();
        signup.FnameField.sendKeys("Ahmed");
        signup.LnameField.sendKeys("Mohamed");
        signup.EmailField.sendKeys("ahmedmohamed123@gmail.com");
        signup.PasswordField.sendKeys("1");
        signup.CreateButton.click();
        wait.until(ExpectedConditions.visibilityOf(signup.ShortPassMsg));
    }

}
