package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

public class LoginPage extends DriverSetup {

    //defining locators
    private static String btnLogin = "ctx-LoginBtn";
    private static String emailName = "_email";
    private static String passwordName = "_password";

    //method that opens login page
    public static void openLoginPage(){
        WebElement login = driver.findElement(By.id(btnLogin));
        login.click();
    }

    //method that enters email
    public static void enterEmail(String email){
        WebElement emailBox = driver.findElement(By.name(emailName));
        emailBox.sendKeys(email);
    }

    //method that enters password
    public static void enterPassword(String password){
        WebElement passwordBox = driver.findElement(By.name(passwordName));
        passwordBox.sendKeys(password);
    }

    //method that click login button
    public static void clickLogin(){
        WebElement loginButton = driver.findElement(By.id(btnLogin));
        loginButton.click();
    }

}
