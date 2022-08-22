package testScenarios;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import utility.DeviceFarmUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ContactManager {
    //required variables
    public static AppiumDriver Driver;
    HomePage homePage;
    AddContactPage addContactPage;
    String pixel2;
    DesiredCapabilities cap;

    public ContactManager() {
        pixel2 = DeviceFarm.ANDROID_OREO.path;
    }

    //method that initilizes th aplication before all
    @BeforeClass
    public void initApplication() throws MalformedURLException {

        try {
            cap = new DesiredCapabilities();
            cap = DeviceFarmUtility.pathToDesiredCapabilitites(this.pixel2);//setting capabilities from json file
            cap.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
            URL url = new URL("http://0.0.0.0:2327/wd/hub");
            Driver = new AndroidDriver(url, cap);
            homePage = new HomePage();
            addContactPage = new AddContactPage();
        }catch (Exception exp){
            System.out.println("**Hatanın sebebi: "+exp.getCause());
            System.out.println("**Hata mesajı: "+exp.getMessage());
            exp.printStackTrace();
        }
    }

    //method that opens add contact page
    @Test(priority = 0)
    public void openAddContactPage() throws InterruptedException {
        homePage.getAddContactBtn().click();
        Thread.sleep(4000);
    }

    //User checks required fields for add account page
    @Test(priority = 1)
    public void checkRequiredFields(){
        Assert.assertTrue(addContactPage.getContactSaveBtn().isEnabled());
    }

    //User checks title whether it is "Add Contact"
    @Test(priority = 2)
    public void verifyTitle(){
        Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
    }

    //User adds a home account successfully
    @Test(priority = 3)
    public void checkHomeAccount(){
        addContactPage.getContactPhoneDrop().click();
        Assert.assertTrue(addContactPage.getContactPhoneHome().isDisplayed());
        addContactPage.getContactPhoneHome().click();
    }

    //User adds a work account successfully
    @Test(priority = 4)
    public void checkWorkAccount(){
        addContactPage.getContactPhoneDrop().click();
        Assert.assertTrue(addContactPage.getContactPhoneWork().isDisplayed());
        addContactPage.getContactPhoneWork().click();
    }

    //User adds a mobile account successfully
    @Test(priority = 5)
    public void checkMobileAccount(){
        addContactPage.getContactPhoneDrop().click();
        Assert.assertTrue(addContactPage.getContactPhoneMobile().isDisplayed());
        addContactPage.getContactPhoneMobile().click();
    }

    //User adds a home account with home email successfully
    @Test(priority = 6)
    public void checkHomeAccountEmail(){
        addContactPage.getContactPhoneDrop().click();
        Assert.assertTrue(addContactPage.getContactPhoneHome().isDisplayed());
        addContactPage.getContactPhoneHome().click();

        addContactPage.getContactEmailDrop().click();
        Assert.assertTrue(addContactPage.getContactEmailHome().isDisplayed());
        addContactPage.getContactEmailHome().click();
    }

    //User checks number limit for contact phone field
    @Test(priority = 7)
    public void checkNumberLimit(){
        addContactPage.getContactPhoneField().sendKeys("055544433226666777");
        Assert.assertEquals(addContactPage.getContactPhoneField().getText().length(),11);
    }

    //User checks whether contact name accepts number and digit
    @Test(priority = 8)
    public void checkContactNameAcceptsNumberDigit(){
        addContactPage.getContactNameField().sendKeys("Ahmet12345");
        Assert.assertEquals(addContactPage.getContactNameField().getText(),"Ahmet12345");
    }

    //User checks special characters limit for contact name field
    @Test(priority = 9)
    public void checkSpecialCharacterLimitContactName(){
        addContactPage.getContactNameField().sendKeys("₺₺₺₺%%%&&^^^!!!???");
        //there is no limit for special character for name field
    }

    //User checks special characters limit for contact phone field
    @Test(priority = 10)
    public void checkSpecialCharacterLimitContactPhone(){
        addContactPage.getContactPhoneField().sendKeys("₺₺₺₺%%%&&^^^!!!???");
        //there is no limit for special character for phone field
    }

}
