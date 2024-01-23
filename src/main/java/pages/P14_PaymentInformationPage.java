package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P14_PaymentInformationPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P14_PaymentInformationPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By creditCardType = By.id("CreditCardType");
    private final By cardHolderName = By.id("CardholderName");
    private final By cardNumber = By.id("CardNumber");
    private final By expirationMonth = By.id("ExpireMonth");
    private final By expirationYear = By.id("ExpireYear");
    private final By cardCode = By.id("CardCode");
    private final By continueBtn = By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]");

    //4- Define the Action Methods
    public P14_PaymentInformationPage selectCreditCardType (int index){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.creditCardType));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select cCType = new Select(driver.findElement(this.creditCardType));
        cCType.selectByIndex(index);
        return this;
    }
    public P14_PaymentInformationPage enterCardHolderName (String cardHolderName){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardHolderName));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.cardHolderName).sendKeys(cardHolderName);
        return this;
    }
    public P14_PaymentInformationPage enterCardNumber (String cardNumber){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardNumber));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.cardNumber).sendKeys(cardNumber);
        return this;
    }
    public P14_PaymentInformationPage selectExpirationMonth (int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.expirationMonth));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select expirationMonth = new Select(driver.findElement(this.expirationMonth));
        expirationMonth.selectByIndex(index);
        return this;
    }
    public P14_PaymentInformationPage selectExpirationYear (int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.expirationYear));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select expirationYear = new Select(driver.findElement(this.expirationYear));
        expirationYear.selectByIndex(index);
        return this;
    }
    public P14_PaymentInformationPage enterCardCode (String cardCode){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardCode));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.cardCode).sendKeys(cardCode);
        return this;
    }
    public P14_PaymentInformationPage clickContinueBtn (){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }

}
