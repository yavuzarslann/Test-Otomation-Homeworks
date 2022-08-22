package pageobjects;

import com.github.javafaker.Faker;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;
    Helper elementHelper;
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String number = faker.address().buildingNumber();
    String mail = faker.name().firstName();
    String mail2 = faker.name().lastName();
    By nameField = By.xpath("//input[@id='loginInputName']");
    By emailField = By.cssSelector("#loginInputEmail");
    By passwordField = By.cssSelector("#loginInputPassword");
    By passwordConfirmField = By.cssSelector("#loginInputPasswordConfirm");
    By createBtn = By.xpath("//button[normalize-space()='CREATE']");

    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void enterName(){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(mail.toLowerCase()+mail2.toLowerCase()+"@gmail.com");
    }

    public void enterPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(number+number+number);
    }

    public void enterPasswordConfirm(){
        driver.findElement(passwordConfirmField).click();
        driver.findElement(passwordConfirmField).sendKeys(number+number+number);
    }

    public void clickSubmit(){
        driver.findElement(createBtn).click();
    }
}
