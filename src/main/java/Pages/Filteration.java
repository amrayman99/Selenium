package Pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class Filteration extends BaseTest {

    public Filteration(WebDriver driver) throws IOException {
        super();

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    @FindBy(xpath="//*[@id='tt-pageContent']/div/div/div/div[1]/div[5]/div/ul")
    public WebElement ProductTypeList;

    @FindBy(xpath = "//*[@class='btn-link-02 filtres-remove-js clear_all']")
    public WebElement ClearAll;

    @FindBy(partialLinkText = "SOCKS")
    public WebElement SockButton;

    public void Filter_by(String product_type) throws InterruptedException {
        WebElement filter=driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/div/div[1]/div[5]/div/ul"));
        filter.findElement(By.partialLinkText(product_type)).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='NO MORE PRODUCTS']")));

        List<WebElement> resultsTitles = driver .findElements(By.xpath("//*[@class='text-uppercase']"));
        for (WebElement resultTitle : resultsTitles) {
            String titleText = resultTitle .getText();
            System.out.println(titleText);

            if (!titleText .contains(product_type)) {
                System.out.println("Result title does not contain this product: " + titleText);
            }
        }
    }
}
