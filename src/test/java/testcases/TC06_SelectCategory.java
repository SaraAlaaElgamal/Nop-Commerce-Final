package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;

import static testcases.TC01_Register.email;
import static util.Utility.generateRandomInt;
import static util.Utility.getExcelData;
@Feature("Select Category Feature")
@Epic("Select Category Epic")
public class TC06_SelectCategory extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    int index = generateRandomInt(3);
    String randomCategoryName;
    //Test Cases
    @Description("Select Category")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Select Category")
    @Test(priority = 1, description = "Select Random Category")
    public void selectCategory_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        randomCategoryName = new P05_HomePage(driver).hoverOnRandomCategory(index);
        Assert.assertTrue(new P05_HomePage(driver).validateHoverOnRandomCategorySuccessfully(randomCategoryName));

    }
}
