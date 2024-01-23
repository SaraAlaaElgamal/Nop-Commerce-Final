package testcases;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;

import static testcases.TC01_Register.email;
import static util.Utility.generateRandomInt;
import static util.Utility.getExcelData;
@Feature("Switch Currencies Feature")
@Epic("Switch Currencies Epic")
public class TC05_SwitchCurrencies extends TestBase {
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    int index = generateRandomInt(2);
    //Test Cases
    @Description("Switch Currencies")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Switch Currencies")
    @Test(priority = 1, description = "Switch Currency")
    public void switchCurrency_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).switchCurrency(index);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P05_HomePage(driver).validateSwitchCurrencySuccessfully(index));
        softAssert.assertAll();
    }
}