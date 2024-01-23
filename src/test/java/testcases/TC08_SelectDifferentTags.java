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

@Feature("Select Different Tags Feature")
@Epic("Select Different Tags Epic")
public class TC08_SelectDifferentTags extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    int index = generateRandomInt(3);
    String randomTagName;
    //Test Cases
    @Description("Select Different Tags")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Select Different Tags")
    @Test(priority = 1, description = "Select Random Tag")
    public void selectTag_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        randomTagName = new P05_HomePage(driver).hoverOnComputers().selectComputersRandomTag(index);
        Assert.assertTrue(new P05_HomePage(driver).validateHoverOnComputerRandomTagSuccessfully(randomTagName));
    }
}
