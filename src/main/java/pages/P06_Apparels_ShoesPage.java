package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt2;

public class P06_Apparels_ShoesPage {
    //1- Define the Driver
    WebDriver driver;
    //2- Define the Constructor and initialize the driver
    public P06_Apparels_ShoesPage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the locators
    private final By grey = By.xpath("//html/body/div[6]/div[3]/div/div[2]/div/div/div[2]/ul/li[2]/input");
    private final By red = By.xpath("//html/body/div[6]/div[3]/div/div[2]/div/div/div[2]/ul/li[3]/input");
    private final By blue = By.xpath("//html/body/div[6]/div[3]/div/div[2]/div/div/div[2]/ul/li[4]/input");
    private final By addToCartBtn = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]");
    private final By shoesTitle = By.xpath("//h1[normalize-space()='Shoes']");
    //4- Define Action Methods
    public P06_Apparels_ShoesPage filterByColor(int index){
        final By randomColor = By.xpath("//html/body/div[6]/div[3]/div/div[2]/div/div/div[2]/ul/li["+index+"]/input");
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(randomColor));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(randomColor).click();
        return this;
    }
    public P06_Apparels_ShoesPage addShoesToCart(){
        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.addToCartBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.addToCartBtn).click();
        return this;
    }
    public Boolean verifyNavigateToShoesPage(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.shoesTitle));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(this.shoesTitle).getText().equals("Shoes");
    }
}
