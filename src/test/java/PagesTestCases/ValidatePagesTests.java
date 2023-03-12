package PagesTestCases;

import Pages.ValidatePages;
import Util.TestNG_Listener;
import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidatePagesTests extends BaseTest {

    ValidatePages validatePages;
    public ValidatePagesTests() throws IOException {
    }
    @Test(priority = 14, groups = {"E2E"})
    public void validate_contact_us() throws IOException {

        validatePages= new ValidatePages(driver);

        validatePages.Contact_Us.click();
        validatePages.title_assertion("Contact Us – Town Team");
    }
    @Test(priority = 15, groups = {"E2E"})
    public void validate_About_TOWN_TEAM() throws IOException {

        validatePages= new ValidatePages(driver);

        validatePages.About_TOWN_TEAM.click();
        validatePages.title_assertion("About TOWN TEAM – Town Team");
    }
    @Test(priority = 16, groups = {"E2E"})
    public void validate_Privacy_Policy() throws IOException {

        validatePages= new ValidatePages(driver);

        validatePages.Privacy_Policy.click();
        validatePages.title_assertion("TOWN TEAM Privacy Policy – Town Team");
    }
    @Test(priority = 17, groups = {"E2E"})
    public void validate_Promotions () throws IOException, InterruptedException {

        validatePages= new ValidatePages(driver);

        actions.moveToElement(validatePages.Promotions).build().perform();
        actions.moveToElement(validatePages.Today_Deals).click().build().perform();
        validatePages.title_assertion("Today's Deal – Town Team");
    }
}
