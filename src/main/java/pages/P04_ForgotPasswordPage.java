package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P04_ForgotPasswordPage {
    //1- Define Webdriver
    WebDriver driver;
    //2- Define Constructor and initialize the driver
    public P04_ForgotPasswordPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By email = By.id("Email");
    private final By recoverBtn = By.xpath("//button[@name=\"send-email\"]");
    private final By forgotPasswordSuccessMessage = By.xpath("//p[@class=\"content\"]");
    //4- Define the Action Methods
    public P04_ForgotPasswordPage enterEmail(String email){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.email));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public P04_ForgotPasswordPage clickRecoverBtn(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.recoverBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.recoverBtn).click();
        return this;
    }
    public Boolean verifySuccessForgotPassword(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.forgotPasswordSuccessMessage));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.forgotPasswordSuccessMessage).getText().equals("Email with instructions has been sent to you.");
    }
}
