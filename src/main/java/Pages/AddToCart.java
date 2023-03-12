package Pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class AddToCart extends BaseTest {

    public AddToCart(WebDriver driver) throws IOException {
        super();

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    WebDriver driver;

    @FindBy (partialLinkText = "WINTER COLLECTION ")
    public WebElement WinterLinkText;

    @FindBy (linkText="SWS22WCAH79762RM1")
    public WebElement ProductLinkText;

    @FindBy(xpath = "//*[@data-tooltip='Red']")
    public WebElement RedButton;

    @FindBy(xpath = "//*[@data-value='M']")
    public WebElement SizeButton;

    @FindBy(xpath = "//*[@class='btn btn-lg btn-addtocart addtocart-js']")
    public WebElement AddToCartButton;

    @FindBy (linkText="VIEW CART")
    public WebElement ViewCart;

    @FindBy(xpath = "//*[@class='tt-modal-messages']")
    public WebElement Added_Sucessfully;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/a[1]//*[name()='svg']")
    public WebElement delete;

    @FindBy(xpath = "//*[@class='tt-title']")
    public WebElement CartIsEmptyText;


    public void text_test(String text){
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue(list.size() > 0,"Text not found!");
    }

}
