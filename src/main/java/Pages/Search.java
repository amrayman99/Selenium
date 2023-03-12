package Pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Search extends BaseTest {

    public Search(WebDriver driver) throws IOException {
        super();

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    @FindBy(xpath = "//button[@data-tooltip='Search']")
    public WebElement SearchButton;

    @FindBy (xpath = "//input[@class='tt-search-input']")
    public WebElement SearchField;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement SearchButtonAfterText;

    //@FindBy (xpath = "//*[text()='EN']")
    //public WebElement LanguageButton;

    @FindBy (xpath = "//*[text()='Your Search Returns No Result.']")
    public WebElement NoResults;

    @FindBy(xpath = "//button[@class='ly-custom-dropdown-list-element-right']")
    public WebElement ArabicButton;


    public void search(String word) throws IOException {

        SearchButton.click();
        SearchField.sendKeys(word);
        SearchButtonAfterText.click();

        List<WebElement> resultsTitles = driver .findElements(By.xpath("//*[@class='text-uppercase']"));
        for (WebElement resultTitle : resultsTitles) {
            String titleText = resultTitle .getText();
            System.out.println(titleText);

            if (!titleText .contains(word)) {
                System.out.println("Result title does not contain "+word+ ":"+ titleText);
            }
        }


    }
}
