package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P05_HomePage {
    //1- Define the Webdriver
    WebDriver driver;
    //2- Define the constructor and initialize the driver
    public P05_HomePage (WebDriver driver){
        this.driver = driver;
    }
    //3- Define the Locators
    private final By searchField = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@type=\"submit\"]");
    private final By computers = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/computers\"]");
    private final By computerRandomTagTitle = By.xpath("//div/h1");
    private final By randomCategoryTitle = By.xpath("//div/h1");
    private final By desktops = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a");
    private final By notebooks = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");
    private final By software = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[3]/a");
    private final By electronics = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/electronics\"]");
    private final By cameraPhoto = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[1]/a");
    private final By cellPhones = By.xpath("///html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a");
    private final By others = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[3]/a");
    private final By apparel = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/apparel\"]");
    private final By shoes = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a");
    private final By clothing = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[2]/a");
    private final By accessories = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[3]/a");
    private final By digitalDownloads = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/digital-downloads\"]");
    private final By books = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/books\"]");
    private final By jewelry = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/jewelry\"]");
    private final By giftCards = By.xpath("(//div/ul[@class=\"top-menu notmobile\"]/li/a)[@href=\"/gift-cards\"]");
    private final By shoppingCart = By.xpath("//li[@id=\"topcartlink\"]/a[@href=\"/cart\"]");
    private final By searchTitle = By.xpath("//div[@class=\"page-title\"]/h1");
    //4- Define the action Methods
    public P05_HomePage enterSearchKeyword (String searchKeyword){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.searchField));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.searchField).sendKeys(searchKeyword);
        return this;
    }
    public P05_HomePage clickSearchBtn (){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.searchBtn));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.searchBtn).click();
        return this;
    }
    public P05_HomePage switchCurrency(int index) {
        final By currency = By.xpath("//select[@id=\"customerCurrency\"]/option["+generateRandomInt(2)+"]");
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(currency));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(currency).click();
        return this;
    }
    public Boolean validateSwitchCurrencySuccessfully(int index) {
        final By currency = By.xpath("//select[@id=\"customerCurrency\"]/option["+generateRandomInt(2)+"]");
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(currency));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        System.out.println(currency);
        System.out.println(driver.findElement(currency).isSelected());
        return driver.findElement(currency).isSelected();
    }
    public P05_HomePage hoverOnComputers(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.computers));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(this.computers)).build().perform();
        return this;
    }
    public String selectComputersRandomTag(int index){
        final By randomTag = By.xpath("//html/body/div[6]/div[2]/ul[1]/li[1]/ul/li["+index+"]/a");
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(randomTag));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        String randomTagName = driver.findElement(randomTag).getText();
        driver.findElement(randomTag).click();
        return randomTagName;
    }
    public Boolean validateHoverOnComputerRandomTagSuccessfully(String randomTagName){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.computerRandomTagTitle));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(computerRandomTagTitle).getText().equals(randomTagName);
    }
    public P05_HomePage hoverOnApparels(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.apparel));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(this.apparel)).build().perform();
        return this;
    }
    public P05_HomePage selectShoesTag(){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.shoes));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.shoes).click();
        return this;
    }
    public P05_HomePage hoverAndClickOnBooks(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.books));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(this.books)).build().perform();
        driver.findElement(this.books).click();
        return this;
    }
    public P05_HomePage hoverAndClickOnJewelry(){
        try{shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.jewelry));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(this.jewelry)).build().perform();
        driver.findElement(this.jewelry).click();
        return this;
    }
    public P05_HomePage clickShoppingCart (){

        try{longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.shoppingCart));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        driver.findElement(this.shoppingCart).click();
        return this;
    }
    public String hoverOnRandomCategory(int index){
        final By randomCategory = By.xpath("//html/body/div[6]/div[2]/ul[1]/li["+index+"]/a");
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(randomCategory));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(randomCategory)).build().perform();
        String randomCategoryName = driver.findElement(randomCategory).getText();
        driver.findElement(randomCategory).click();
        return randomCategoryName;
    }
    public Boolean validateHoverOnRandomCategorySuccessfully(String randomCategoryName){
        try{shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.randomCategoryTitle));
        }catch (TimeoutException ex){
            ex.printStackTrace();
            System.out.println("The error is " + ex.getMessage());
        }
        return driver.findElement(randomCategoryTitle).getText().equals(randomCategoryName);
    }
    public Boolean verifySearchResults (String searchKeyWord){
        Boolean[] verifySearch = new Boolean[2];
        for(int i=1;i<=2;i++){
            verifySearch [i-1] = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])["+i+"]")).getText().contains(searchKeyWord);
        }
        return (verifySearch[0] && verifySearch[1]);
    }


//    public Boolean verifySelectCategorySuccessfully(int index){
//        return driver.findElement(By.xpath("//html/body/div[6]/div[2]/ul[1]/li["+index+"]/a")).getText()
//    }

}
