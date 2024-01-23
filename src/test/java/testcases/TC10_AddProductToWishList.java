package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;
import pages.P08_BooksPage;

import static testcases.TC01_Register.email;
import static util.Utility.getExcelData;
@Feature("Add Product To Wishlist Feature")
@Epic("Add Product To Wishlist Epic")
public class TC10_AddProductToWishList extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    //Test Cases
    @Description("Add Product To Wishlist")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Product To Wishlist")
    @Test(priority = 1, description = "Add Product To Wishlist")
    public void addProductToWishList_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).hoverAndClickOnBooks();
        new P08_BooksPage(driver).clickAddToWishList();
        Assert.assertTrue(new P08_BooksPage(driver).verifyAddToWishlistSuccessfully());
    }
}
