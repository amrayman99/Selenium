package PagesTestCases;

import Pages.AddToCart;
import Pages.Filteration;
import Util.TestNG_Listener;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilterationTests extends BaseTest {
    Filteration filteration;
    AddToCart addToCart;

    public FilterationTests() throws IOException {
    }

    @Test(priority = 10, groups = {"E2E"})
    public void Filter_products() throws InterruptedException, IOException {

        filteration=new Filteration(driver);
        addToCart=new AddToCart(driver);

        addToCart.WinterLinkText.click();
       filteration.Filter_by("SOCKS");

    }
    @Test(priority = 11, groups = {"E2E"})
    public void Clear_Filter() throws InterruptedException, IOException {

        filteration=new Filteration(driver);
        addToCart=new AddToCart(driver);

        addToCart.WinterLinkText.click();
        filteration.SockButton.click();
        filteration.ClearAll.click();
        wait.until(ExpectedConditions.invisibilityOf(filteration.ClearAll));

    }
}
