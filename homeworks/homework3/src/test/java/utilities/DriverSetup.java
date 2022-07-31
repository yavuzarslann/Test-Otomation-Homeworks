package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverSetup {

    public static WebDriver driver;

    //methods and options for initialize browser
    public static WebDriver initDrivers(String browser){
        //options and driver for google chrome
        if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            //code to start the browser with the desired profile
            options.addArguments("user-data-dir=/Users/yakuparslan/Library/Application Support/Google/Chrome");
            options.addArguments("--profile-directory=Profile 1");
            driver.manage().window().maximize();
            //driver for google chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        if (browser.equals("firefox")){
            //driver for firefox
            WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();
        }
        if (browser.equals("edge")){
            //driver for edge
            WebDriverManager.edgedriver().setup();
            //driver = new EdgeDriver();
        }

        return driver;
    }

}
