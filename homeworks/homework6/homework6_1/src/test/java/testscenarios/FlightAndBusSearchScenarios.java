package testscenarios;


import api.FlightTicketRequest;
import com.mashape.unirest.http.exceptions.UnirestException;
import framework.ConfigReader;
import framework.DriverSetup;
import model.Root;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FlightAndBusSearchScenarios {
    //gerekli değişkenleri tanımlıyoruz
    static WebDriver driver;
    static Properties properties;
    HomePage homePage;
    FlightTicketRequest flightTicketRequest;
    String keyword = "ada";

    //testten önce driver ı ayağa kaldırıyoruz
    @BeforeClass
    public void setup(){
          properties = ConfigReader.initialize_Properties();
          driver = DriverSetup.initialize_Driver("chrome");
          homePage = new HomePage(driver);
          flightTicketRequest = new FlightTicketRequest();
    }

    //arama kelimesi ile fligth ticket bölümünde arama yaptığımız test
    @Test(priority = 1)
    public void searchForKeyword() throws InterruptedException {
        homePage.searchForFlightTicket(keyword);//key parametrresini gönderiyoruz
    }

    //arama kelimesiyle gelen verilerin gerçekten Api den gelen veriler olup olmadığını kontrol eden test
    @Test(priority = 2)
    public void checkListForSearch() throws UnirestException, IOException {
        Map<String, Root> flightMap = new HashMap();//arama sonuçlarını Root modele map vasıtasıyla gönderiypruz
        Map<String, Root> flightMapAPi = new HashMap();

        //UI elementi ile arama sonuçlarını alıyoruz
        List< String > flightList = homePage.listForFlightTicketSearchByStream();

        //java stream kullanarak gerekli verileri map e gönderiyoruz
        flightList.stream().forEach(e -> {
            Root root = new Root();
            root.setAirport(e.split("\n")[1]);
            root.setCity_name(e.split(",")[0]);
            root.setCity_code(e.split("\n")[2]);
            flightMap.put(e.split("\n")[2],root);
        });

        //Api ile arama sonuçlarını alıyoruz
        List< String > flightListApi = flightTicketRequest.flightTicketFromList(keyword);

        //java stream kullanarak gerekli verileri map e gönderiyoruz
        flightListApi.stream().forEach(e -> {
            Root root = new Root();
            root.setAirport(e.split(":")[1]);
            root.setCity_name(e.split(":")[2]);
            root.setCity_code(e.split(",")[0]);
            flightMapAPi.put(e.split(",")[0],root);
        });

        //oluşturduğumuz Api mapi ile UI dan gelen mapi karşılatırıyoruz
        Assert.assertEquals(flightMap.get("ADA"),flightMapAPi.get("ADA"));
    }
}
