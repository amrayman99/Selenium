package PagesTestCases;

import Pages.Search;
import Pages.SignUp;
import Util.TestNG_Listener;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SearchTests extends BaseTest {

    Search search;

    public SearchTests() throws IOException {
    }

    @Test(priority = 7, groups = {"E2E"})
    public void search() throws IOException {
        search = new Search(driver);

            search.SearchButton.click();
            search.SearchField.sendKeys(pro.getProperty("SearchWord"));
            search.SearchButtonAfterText.click();

            List<WebElement> resultsTitles = driver.findElements(By.xpath("//*[@class='text-uppercase']"));
            for (WebElement resultTitle : resultsTitles) {
                String titleText = resultTitle.getText();
                System.out.println(titleText);

                if (!titleText.contains(pro.getProperty("SearchWord"))) {
                    System.out.println("Result title does not contain :   " + pro.getProperty("SearchWord") + " But Actual is " + titleText);
                }
            }
    }
    @Test(priority = 9, groups = {"E2E"})
    public void search_for_item() throws IOException {
        search= new Search(driver);

        search.search("JACKET");
    }
    // FAIL
    @Test(priority = 8, groups = {"E2E"})
    public void search_with_unrelated_word() throws InterruptedException, IOException {

        search = new Search(driver);

        search.SearchButton.click();
        search.SearchField.sendKeys("Car");
        search.SearchButtonAfterText.click();
        search.NoResults.isDisplayed();

    }
}
