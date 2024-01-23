package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P02_RegistrationPage;

import static util.Utility.generateRandomInt;
import static util.Utility.getExcelData;

@Feature("Register Feature")
@Epic("Register Epic")
public class TC01_Register extends TestBase{
    //Declaration
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    int day = generateRandomInt(28);
    int month = generateRandomInt(12);
    int year = generateRandomInt(20);
    static String email = faker.internet().emailAddress();
    String companyName = faker.name().title();
    String password = getExcelData(0,0,"Password_Positive");
    String confirmPassword = getExcelData(0,1,"Password_Positive");
    //Test Cases
    @Description("Register with Valid Data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register")
    @Test(priority = 1, description = "Register new user with Valid Data")
    public void registerNewUserWithValidData_P() throws InterruptedException {
        //Test Scenario
        new P01_LandingPage(driver).clickRegisterTab();
        new P02_RegistrationPage(driver).chooseGender().enterFirstName(firstName).enterLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).enterEmail(email).enterCompanyName(companyName).enterPassword(password).enterConfirmPassword(confirmPassword).clickRegisterBtn();
        Assert.assertTrue(new P02_RegistrationPage(driver).verifyRegistrationSuccessfully());
    }
}
