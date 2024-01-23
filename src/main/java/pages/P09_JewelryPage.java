package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static util.Utility.generateRandomInt;

public class P09_JewelryPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P09_JewelryPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By randomAddToCompareListBtn = By.xpath("//div[@class=\"item-grid\"]/div["+generateRandomInt(3)+"]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 add-to-compare-list-button\"]");
    private final By notificationBarCompareList = By.xpath("//p[@class='content']");

    //4- Define Action Methods
    public P09_JewelryPage clickAddToCompareList(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.randomAddToCompareListBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.randomAddToCompareListBtn).click();
        return this;
    }
    public Boolean verifyAddToCompareListSuccessfully(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.notificationBarCompareList));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.notificationBarCompareList).getText().equals("The product has been added to your product comparison");
    }
}
