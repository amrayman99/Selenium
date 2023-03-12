package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class ValidatePages extends BaseTest {

    public ValidatePages(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(partialLinkText = "About TOWN TEAM")
    public WebElement About_TOWN_TEAM;

    @FindBy(partialLinkText = "Promotions ")
    public WebElement Promotions;

    @FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[2]/div/div/div[2]/div/div/nav/ul/li[4]/div/div/div/ul/li[1]/a/span")
    public WebElement Today_Deals;

    @FindBy(partialLinkText = "Contact Us")
    public WebElement Contact_Us;

    @FindBy(partialLinkText = "TOWN TEAM Privacy Policy")
    public WebElement Privacy_Policy;

    public void title_assertion(String expected_title){

        String actual_title = driver.getTitle();
        Assert.assertEquals(actual_title, expected_title);
    }

}
