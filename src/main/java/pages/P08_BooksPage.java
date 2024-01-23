package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static util.Utility.generateRandomInt;

public class P08_BooksPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P08_BooksPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By randomAddToWishListBtn = By.xpath("//div[@class=\"item-grid\"]/div["+generateRandomInt(3)+"]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 add-to-wishlist-button\"]");
    private final By notificationBarWishlist = By.xpath("//p[@class='content']");
    //4- Define Action Methods
    public P08_BooksPage clickAddToWishList(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.randomAddToWishListBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.randomAddToWishListBtn).click();
        return this;
    }
    public Boolean verifyAddToWishlistSuccessfully(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.notificationBarWishlist));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.notificationBarWishlist).getText().equals("The product has been added to your wishlist");
    }
}
