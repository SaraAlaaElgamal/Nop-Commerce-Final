package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P02_RegistrationPage {
    //1- Define the Webdriver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P02_RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By day = By.xpath("//select[@name =\"DateOfBirthDay\"]");
    private final By month = By.xpath("//select[@name =\"DateOfBirthMonth\"]");
    private final By year = By.xpath("//select[@name =\"DateOfBirthYear\"]");
    private final By email = By.xpath("(//input)[7]");
    private final By companyName = By.xpath("(//input)[8]");
    private final By newSleter = By.xpath("(//input)[9]");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerBtn = By.xpath("(//button)[2]");
    private final By registrationSuccessMessage = By.xpath("//div[@class=\"result\"]");
    //4- Define the Action Methods
    public P02_RegistrationPage chooseGender() {
        final By gender = By.xpath("(//input[@type=\"radio\"])["+generateRandomInt(2)+"]");
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(gender));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(gender).click();
        return this;
    }
    public P02_RegistrationPage enterFirstName(String firstName){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstName));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.firstName).sendKeys(firstName);
        return this;
    }
    public P02_RegistrationPage enterLastName(String lastName){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lastName));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.lastName).sendKeys(lastName);
        return this;
    }
    public P02_RegistrationPage selectDay(int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.day));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select day= new Select(driver.findElement(this.day));
        day.selectByIndex(index);
        return this;
    }
    public P02_RegistrationPage selectMonth(int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.month));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select month = new Select(driver.findElement(this.month));
        month.selectByIndex(index);
        return this;
    }
    public P02_RegistrationPage selectYear(int index){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.year));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select year = new Select(driver.findElement(this.year));
        year.selectByIndex(index);
        return this;
    }
    public P02_RegistrationPage enterEmail(String email){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.email));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public P02_RegistrationPage enterCompanyName(String companyName){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.companyName));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.companyName).sendKeys(companyName);
        return this;
    }
    public P02_RegistrationPage enterPassword(String password){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P02_RegistrationPage enterConfirmPassword(String confirmPassword){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmPassword));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
        return this;
    }
    public P02_RegistrationPage clickRegisterBtn(){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.registerBtn).click();
        return this;
    }
    public Boolean verifyRegistrationSuccessfully(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.registrationSuccessMessage));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.registrationSuccessMessage).getText().equals("Your registration completed");
    }
}

