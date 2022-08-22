package testScenarios;

import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SingInPage;

public class SingInTest {
    static WebDriver driver;
    HomePage homePage;
    SingInPage singInPage;

    @BeforeClass
    public void setup(){
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new HomePage(driver);
        singInPage = new SingInPage(driver);
    }

    //başarılı bir şekilde login olmayı test ediyoruz
    @Test
    public void verifySuccessFulSingIn(){
        homePage.clickMyAccount();
        homePage.clickSingIn();
        singInPage.enterEmail();
        singInPage.enterPassword();
        singInPage.clickSubmit();
        singInPage.clickMyAccount();
        //profile kısmında kullanıcı adının çıkıp çıkmadığına bakıp testi doğruluyoruz
        Assert.assertTrue(singInPage.checkProfile());
    }

}
