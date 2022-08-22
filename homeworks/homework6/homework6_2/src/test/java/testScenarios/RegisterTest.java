package testScenarios;

import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import pageobjects.SingInPage;

public class RegisterTest {
    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeClass
    public void setup(){
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    //başarılı register testi
    @Test
    public void verifySuccessfulRegister(){
        homePage.clickMyAccount();
        homePage.clickRegister();
        registerPage.enterName();
        registerPage.enterEmail();
        registerPage.enterPassword();
        registerPage.enterPasswordConfirm();
        registerPage.clickSubmit();
        homePage.clickMyAccount();
        //burada sing out yazısı çıkıp çıkmadığını kontrol ederek testi doğruluyoruz
        Assert.assertTrue(homePage.checkSingOut());
    }
}
