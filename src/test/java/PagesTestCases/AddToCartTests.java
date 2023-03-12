package PagesTestCases;

import Pages.AddToCart;
import Util.TestNG_Listener;
import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTests extends BaseTest {

    AddToCart addToCart;

    public AddToCartTests() throws IOException {
    }
    @Test(priority = 12, groups = {"E2E"})
    public void add_product_to_cart() throws IOException {

        addToCart= new AddToCart(driver);

        addToCart.WinterLinkText.click();
        addToCart.ProductLinkText.click();
        addToCart.RedButton.click();
        addToCart.SizeButton.click();
        addToCart.AddToCartButton.click();
        addToCart.Added_Sucessfully.isDisplayed();
        addToCart.ViewCart.click();
        addToCart.ProductLinkText.isDisplayed();
    }

    @Test(priority = 13, groups = {"E2E"})
    public void delete_product_from_cart() throws IOException {

        addToCart= new AddToCart(driver);

        add_product_to_cart();
        addToCart.delete.click();
        addToCart.CartIsEmptyText.isDisplayed();
    }
}
