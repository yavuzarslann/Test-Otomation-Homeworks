package tets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utilities.DriverSetup;


public class LoginPageTest extends DriverSetup{

    //login test
    @Test
    public void login(){
        DriverSetup.initDrivers("chrome");//initializing browser
        String url = "https://www.enuygun.com";
        driver.get(url);//going the web site

        //login processes
        LoginPage.openLoginPage();
        LoginPage.enterEmail("test@tester.com");
        LoginPage.enterPassword("1234abcd");
        LoginPage.clickLogin();

    }

}
