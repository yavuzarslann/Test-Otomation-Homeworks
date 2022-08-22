package pageobjects;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;
    Helper elementHelper;
    By myAccount = By.xpath("//button[@data-tooltip='My account']");
    By singIn = By.xpath("//div[@class='tt-dropdown-inner']//a[normalize-space()='Sign in']");
    By register = By.xpath("//div[@class='tt-dropdown-inner']//a[normalize-space()='Register']");
    By singOut = By.xpath("//a[normalize-space()='Sign out']");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void clickMyAccount(){
        driver.findElement(myAccount).click();
    }

    public void clickSingIn(){
        driver.findElement(singIn).click();
    }

    public void clickRegister(){
        driver.findElement(register).click();
    }

    public boolean checkSingOut(){
       return driver.findElement(singOut).isDisplayed();
    }

}
