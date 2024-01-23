package testcases;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P04_ForgotPasswordPage;

import static testcases.TC01_Register.email;

@Feature("Forgot Password Feature")
@Epic("Forgot Password Epic")
public class TC03_ForgotPassword extends TestBase{
    //Declarations
    //Test Cases
    @Description("Forgot Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Forgot Password")
    @Test(priority = 1, description = "Forgot Password")
    public void forgotPassword_P() throws InterruptedException {
        //ToDo: Define Pages
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).clickForgotPassword();
        new P04_ForgotPasswordPage(driver).enterEmail(email).clickRecoverBtn();
        Assert.assertTrue(new P04_ForgotPasswordPage(driver).verifySuccessForgotPassword());
    }
}
