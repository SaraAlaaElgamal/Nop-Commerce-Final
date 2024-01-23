package testcases;


import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P03_LoginPage;
import pages.P05_HomePage;
import pages.P06_Apparels_ShoesPage;

import static testcases.TC01_Register.email;
import static util.Utility.generateRandomInt;
import static util.Utility.getExcelData;
@Feature("Filter With Color Feature")
@Epic("Filter With Color Epic")
public class TC07_FilterWithColor extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    int index = generateRandomInt(3) + 1;
    //Test Cases
    @Description("Filter With Color")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Filter With Color")
    @Test(priority = 1, description = "Filter With Color")
    public void filterWithColor_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).hoverOnApparels().selectShoesTag();
        new P06_Apparels_ShoesPage(driver).filterByColor(index);
    }

}
