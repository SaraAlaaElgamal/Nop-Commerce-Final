package testcases;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;

import static testcases.TC01_Register.email;
import static util.Utility.getExcelData;
@Feature("Search For Product Feature")
@Epic("Search For Product Epic")
public class TC04_SearchForProduct extends TestBase {
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    String searchKeyword = "Laptop";
    //Test Cases
    @Description("Search For Product")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search For Product")
    @Test(priority = 1, description = "Search for product with matching results")
    public void searchProduct_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).enterSearchKeyword(searchKeyword).clickSearchBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P05_HomePage(driver).verifySearchResults(searchKeyword));
        softAssert.assertAll();
    }
}
