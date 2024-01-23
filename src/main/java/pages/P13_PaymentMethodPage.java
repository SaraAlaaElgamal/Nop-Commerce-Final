package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P13_PaymentMethodPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P13_PaymentMethodPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By creditCard = By.id("paymentmethod_1");
    private final By continueBtn = By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]");
    //4- Define the Action Methods
    public P13_PaymentMethodPage selectCreditCard (){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.creditCard));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.creditCard).click();
        return this;
    }
    public P13_PaymentMethodPage clickContinueBtn (){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }

}
