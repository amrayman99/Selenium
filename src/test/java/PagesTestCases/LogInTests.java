package PagesTestCases;

import Pages.LogIn;
import Pages.SignUp;
import Pages.ValidatePages;
import Util.ReadExcelFile;
import Util.TestNG_Listener;
import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInTests extends base.BaseTest{
    LogIn logIn;
    SignUp signUp;
    ValidatePages validatePages;

    public LogInTests() throws IOException {
    }

    @Test(priority = 3, groups = {"E2E"})
    public void invalid_email_invalid_password() throws InterruptedException, IOException {
        logIn=new LogIn(driver);
        signUp=new SignUp(driver);

        signUp.MyAccountButton.click();
        logIn.RegisterButton.click();
        logIn.LoginEmailField.sendKeys("hjfhjaj@gmail.com");
        logIn.LoginPassField.sendKeys("pass");
        logIn.LogInButton.click();
        wait.until(ExpectedConditions.visibilityOf(logIn.InCorrectEmailOrPassMessage));
    }

    //Fail Email can't be blank. message does not appear

    @Test(priority = 5, groups = {"E2E"})
    public void empty_email_valid_password() throws InterruptedException, IOException {
        logIn=new LogIn(driver);
        signUp=new SignUp(driver);

        signUp.MyAccountButton.click();
        logIn.RegisterButton.click();
        logIn.LoginEmailField.sendKeys("");
        logIn.LoginPassField.sendKeys("123456789@a");
        logIn.LogInButton.click();
        wait.until(ExpectedConditions.visibilityOf(logIn.Email_can_not_be_blank_Message));
    }
    @Test (priority = 4, dataProvider = "valid_testData", groups = {"E2E"})
    public void valid_email_valid_password(String email, String pass) throws InterruptedException, IOException {
        logIn=new LogIn(driver);
        signUp=new SignUp(driver);

        signUp.MyAccountButton.click();
        logIn.RegisterButton.click();
        logIn.LoginEmailField.sendKeys(email);
        logIn.LoginPassField.sendKeys(pass);
        logIn.LogInButton.click();
        wait.until(ExpectedConditions.visibilityOf(logIn.MyAccAfterLogInText));
    }
    @Test(priority = 6, groups = {"E2E"})
    public void Log_Out() throws IOException, InterruptedException {
        logIn=new LogIn(driver);
        signUp=new SignUp(driver);
        validatePages= new ValidatePages(driver);

        valid_email_valid_password("amrayman1999@gmail.com", "1234567891z");
        signUp.MyAccountButton.click();
        logIn.LogOutButton.click();
        validatePages.title_assertion("TOWN TEAM – Town Team");

    }

    @DataProvider(name = "valid_testData")
    public Object[][] testData() throws Exception {
        Object data [][] = ReadExcelFile.getDataFromExcel("valid_email_pass");
        return data;
    }


}
