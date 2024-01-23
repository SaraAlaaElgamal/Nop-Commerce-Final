package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P03_LoginPage {
    //1- Define Web Driver
    WebDriver driver;
    //2- Define Constructor and Initialize the driver
    public P03_LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By email = By.id("Email");
    private final By password = By.id ("Password");
    private final By rememberMe = By.id("RememberMe");
    private final By loginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");
    private final By forgotPasswordBtn = By.xpath("//a[@href=\"/passwordrecovery\"]");
    private final By loginFailedMessage = By.xpath("//div[@class=\"message-error validation-summary-errors\"]");
    private final By logoutBtn = By.xpath("//a[@href=\"/logout\"]");
    //4- Define the Action Methods
    public P03_LoginPage enterEmail(String email) {
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.email));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public P03_LoginPage enterPassword(String password) {
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P03_LoginPage clickRememberMe() {
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.rememberMe));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.rememberMe).click();
        return this;
    }
    public P03_LoginPage clickForgotPassword() {
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.rememberMe));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.forgotPasswordBtn).click();
        return this;
    }
    public P03_LoginPage clickLoginBtn() {
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.loginBtn).click();
        return this;
    }
    public Boolean verifyFailedLogin(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.loginFailedMessage));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.loginFailedMessage).getText().equals("Login was unsuccessful. Please correct the errors and try again.");
    }
    public Boolean verifySuccessLogin(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.logoutBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.logoutBtn).getText().equals("Log out");
    }
}
