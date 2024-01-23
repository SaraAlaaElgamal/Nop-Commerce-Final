package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P11_BillingAddressPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P11_BillingAddressPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By country = By.id("BillingNewAddress_CountryId");
    private final By state = By.id("aria-invalid");
    private final By city = By.id("BillingNewAddress_City");
    private final By address1 = By.id("BillingNewAddress_Address1");
    private final By address2 = By.id("BillingNewAddress_Address2");
    private final By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private final By continueBtn = By.xpath("//div[@id=\"billing-buttons-container\"]/button[4]");

    //4- Define the Action Methods
    public P11_BillingAddressPage selectCountry (int index){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.country));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select country= new Select(driver.findElement(this.country));
        country.selectByIndex(index);
        return this;
    }
    public P11_BillingAddressPage selectState (int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.state));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select state= new Select(driver.findElement(this.state));
        state.selectByIndex(index);
        return this;
    }
    public P11_BillingAddressPage enterCity (String city){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.city));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.city).sendKeys(city);
        return this;
    }
    public P11_BillingAddressPage enterAddress1 (String address1){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.address1));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.address1).sendKeys(address1);
        return this;
    }
    public P11_BillingAddressPage enterAddress2 (String address2){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.address2));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.address2).sendKeys(address2);
        return this;
    }
    public P11_BillingAddressPage enterZipCode (String zipCode){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.zipCode));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.zipCode).sendKeys(zipCode);
        return this;
    }
    public P11_BillingAddressPage enterPhoneNumber (String phoneNumber){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.phoneNumber));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
        return this;
    }
    public P11_BillingAddressPage clickContinueBtn (){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
}
