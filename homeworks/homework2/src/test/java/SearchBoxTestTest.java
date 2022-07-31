import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchBoxTestTest {
    //webdriver sınıfından bir nesne oluşturuyoruz
    static WebDriver driver;

    //test öncesi yapılacaklar
    @BeforeAll
    public static void initDriver(){
        WebDriverManager manager = null; //webdrivermanager sınıfından bir nesne oluşturuyoruz

        manager.chromedriver().setup();

        driver = new ChromeDriver(); //burada driver a chrome driver olduğunu söylüyoruz
        driver.manage().window().maximize(); //tarayıcıyı tam ekrana alıyoruz
        driver.get("https://demoqa.com/webtables"); //testi yapacağımız web sitesine gidiyoruz
    }

    //searchbox ın görüntülendiğini kontrol eden test
    @Test
    void isDisplayed(){
        assertTrue(driver.findElement(By.xpath("//*[@id=\"searchBox\"]")).isDisplayed());
    }

    //test bittikten sonra yapılacaklar
    @AfterAll
    public static void shotDown(){
        driver.quit(); //test bittikten sonra tarayıcıyı kapatma
    }


}