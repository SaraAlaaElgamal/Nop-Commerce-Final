package testcases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static testcases.TC01_Register.email;
import static util.Utility.generateRandomInt2;
import static util.Utility.getExcelData;
@Feature("Add Product To Shopping Cart Feature")
@Epic("Add Product To Shopping Cart Epic")
public class TC09_AddProductToShoppingCart extends TestBase{
    //Declaration
    String password = getExcelData(0,0,"Password_Positive");
    int index = generateRandomInt2(3);
    //Test Cases
    @Description("Add Product To Shopping Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Product To Shopping Cart")
    @Test(priority = 1, description = "Add Product To Shopping Cart")
    public void addProductToShoppingCard_P() throws InterruptedException {
        new P01_LandingPage(driver).clickLoginTab();
        new P03_LoginPage(driver).enterEmail(email).enterPassword(password).clickRememberMe().clickLoginBtn();
        new P05_HomePage(driver).hoverOnApparels().selectShoesTag();
        Assert.assertTrue(new P06_Apparels_ShoesPage(driver).verifyNavigateToShoesPage());
        new P06_Apparels_ShoesPage(driver).addShoesToCart();
        Assert.assertTrue(new P07_Apparels_ShoesInternalPage(driver).verifyNavigateToShoesInternalPage());
        new P07_Apparels_ShoesInternalPage(driver).selectSize(index).selectColor().clickAddToCartBtn();
        Assert.assertTrue(new P07_Apparels_ShoesInternalPage(driver).verifyAddToShoppingCartSuccessfully());
    }
}
