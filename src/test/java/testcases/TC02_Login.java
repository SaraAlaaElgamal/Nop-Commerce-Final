package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import retryTest.Retry;

import static testcases.TC01_Register.email;
import static util.Utility.getExcelData;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC02_Login extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    //Test Cases
    @Description("Login with Valid Data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    @Test(priority = 1, description = "Login with Valid Data",retryAnalyzer = Retry.class)
    public void loginWithValidData_P() throws InterruptedException {
         new P01_LandingPage(driver).clickLoginTab();
         new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        Assert.assertTrue(new P03_LoginPage(driver).verifySuccessLogin());
    }
    @Test(priority = 2, description = "Login with Valid Email and Invalid Password")
    public void loginWithValidEmail_N() throws InterruptedException {
        password = getExcelData(0,0,"Password_Negative");
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        Assert.assertTrue(new P03_LoginPage(driver).verifyFailedLogin());

    }
    @Test(priority = 3, description = "Login with Invalid Email and Valid Password")
    public void loginWithValidPassword_N() throws InterruptedException {
        email = "wrong@mail.com";
        password = getExcelData(0,0,"Password_Positive");
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        Assert.assertTrue(new P03_LoginPage(driver).verifyFailedLogin());
    }

    @Test(priority = 1, description = "Login with Invalid Data")
    public void loginWithInvalidData_N() throws InterruptedException {
        email = "wrong@mail.com";
        password = getExcelData(0,0,"Password_Negative");
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        Assert.assertTrue(new P03_LoginPage(driver).verifyFailedLogin());
    }
}
