package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P07_Apparels_ShoesInternalPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P07_Apparels_ShoesInternalPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By size = By.xpath("//select[@id=\"product_attribute_9\"]");
    private final By color = By.xpath("//label/span[@title=\"Red\"]");
    private final By addToCartBtn = By.xpath("//button[@id='add-to-cart-button-25']");
    private final By shoesInternalPage = By.xpath("//label[normalize-space()='Size']");
    private final By notificationBarShoppingCart = By.xpath("//p[@class='content']");
    private final By closeSuccessMessage = By.xpath("//span[@title='Close']");
    //4- Define Action Methods
    public P07_Apparels_ShoesInternalPage selectSize(int index){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.size));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Select size= new Select(driver.findElement(this.size));
        size.selectByIndex(index);
        return this;
    }
    public P07_Apparels_ShoesInternalPage selectColor(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.color));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.color).click();
        return this;
    }
    public P07_Apparels_ShoesInternalPage clickAddToCartBtn(){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addToCartBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.addToCartBtn).click();
        return this;
    }
    public P07_Apparels_ShoesInternalPage closeSuccessMessage(){
        try{longWait(driver).until(ExpectedConditions.elementToBeClickable(this.closeSuccessMessage));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.addToCartBtn).click();
        return this;
    }
    public Boolean verifyNavigateToShoesInternalPage(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.shoesInternalPage));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.shoesInternalPage).getText().equals("Size");
    }
    public Boolean verifyAddToShoppingCartSuccessfully(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.notificationBarShoppingCart));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.notificationBarShoppingCart).getText().equals("The product has been added to your shopping cart");
    }
    public P07_Apparels_ShoesInternalPage navigateBack(){
        driver.navigate().back();
        return this;
    }
}
