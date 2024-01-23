package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;

public class P01_LandingPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P01_LandingPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By loginTab = By.xpath("(//a)[2]");
    private final By registerTab = By.xpath("(//a)[1]");
    //4- Define the action methods
    public P01_LandingPage clickRegisterTab(){
        try{longWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerTab));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.registerTab).click();
        return this;
    }
    public P01_LandingPage clickLoginTab (){
        try{longWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginTab));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.loginTab).click();
        return this;
    }
}
