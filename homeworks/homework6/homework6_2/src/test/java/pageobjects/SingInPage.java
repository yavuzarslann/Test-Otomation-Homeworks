package pageobjects;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage {

    WebDriver driver;
    Helper elementHelper;
    By emailField = By.cssSelector("#loginEmail");
    By passwordField = By.cssSelector("#loginPass");
    By loginBtn = By.xpath("//button[normalize-space()='LOGIN']");
    By myAccount = By.xpath("//button[@data-tooltip='My account']");
    By profile = By.xpath("//a[@href='/profile'][normalize-space()='tester']");

    public SingInPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void enterEmail(){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys("hattusasdede@gmail.com");
    }

    public void enterPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys("12345678");
    }

    public void clickSubmit(){
        driver.findElement(loginBtn).click();
    }

    public void clickMyAccount(){
        driver.findElement(myAccount).click();
    }

    public boolean checkProfile(){
       return driver.findElement(profile).isDisplayed();
    }
}
