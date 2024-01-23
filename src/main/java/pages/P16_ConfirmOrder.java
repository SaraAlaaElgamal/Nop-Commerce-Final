package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;

public class P16_ConfirmOrder {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P16_ConfirmOrder (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By continueBtn = By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]");
    private final By orderCompleted = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    //4- Define the Action Methods
    public P16_ConfirmOrder clickContinueBtn (){
        try{longWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
    public Boolean verifyOrderCompletedSuccessfully(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.orderCompleted));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.orderCompleted).getText().equals("Your order has been successfully processed!");
    }
}
