package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class HomePage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;
    By gdpr = By.cssSelector("#CookieAlert button");
    By fromForFlightSearch= By.id("OriginInput");
    By fromListForFlightSearch=By.xpath("//*/ul[@role='listbox']/li");
    //login page constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void searchForFlightTicket(String kw) throws InterruptedException {
        WebElement flightSearch =  this.elementHelper
                .findElement(fromForFlightSearch);
        try{
                elementHelper.findElement(gdpr).isEnabled();

                elementHelper.findElement(gdpr).click();

        }catch (NoSuchElementException e){
            System.out.println("gdpr is not visible");
        }


        this.elementHelper.typeForInput(kw,flightSearch);


    }

    public List<String> listForFlightTicketSearchByStream(){
      return  this
              .elementHelper
              .findElements(fromListForFlightSearch)
              .stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public List<String> listForFlightTicketSearch(){

       List<String> webElementText = new ArrayList<String>();
       List<WebElement> webElementList = this.elementHelper.findElements(fromListForFlightSearch);

       for(int i=0;i<webElementList.size();i++){
           webElementText.add(webElementList.get(i).getText());
       }
       return webElementText;

    }


}
