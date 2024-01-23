package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;

public class P12_ShippingMethodPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P12_ShippingMethodPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By continueBtn = By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]");
    //4- Define the Action Methods
    public P12_ShippingMethodPage clickContinueBtn (){
        try{longWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
}
