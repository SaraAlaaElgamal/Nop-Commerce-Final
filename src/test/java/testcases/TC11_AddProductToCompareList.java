package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;
import pages.P09_JewelryPage;

import static testcases.TC01_Register.email;
import static util.Utility.getExcelData;
@Feature("Add Product To Compare List Feature")
@Epic("Add Product To Compare List Epic")
public class TC11_AddProductToCompareList extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    //Test Cases
    @Description("Add Product To Compare List")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Product To Compare List")
    @Test(priority = 1, description = "Add Product To Compare List")
    public void addProductToCompareList_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).hoverAndClickOnJewelry();
        new P09_JewelryPage(driver).clickAddToCompareList();
        Assert.assertTrue(new P09_JewelryPage(driver).verifyAddToCompareListSuccessfully());
    }
}
