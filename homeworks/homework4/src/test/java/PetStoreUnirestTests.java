import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreUnirestTests {

    @Test
    @Order(1)
    public void verifySuccessfulPlaceOrderByUnirest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .body("{\n  \"id\": 1,\n  \"petId\": 2,\n  \"quantity\": 3,\n  \"shipDate\": \"2022-07-30T14:53:29.547Z\",\n  \"status\": \"placed\",\n  \"complete\": true\n}")
                .asString();
        //testin başarılı olup olmadığını anlamak için 200 OK u bekliyoruz
        assertEquals(200, response.getStatus());
    }

    @Test
    @Order(2)
    public void verifySuccessfulGetOrderByUnirest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/order/1")
                .asString();

        assertEquals(200,response.getStatus());
    }

    @Test
    public void verifySuccessfulDeleteOrderByUnirest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete("https://petstore.swagger.io/v2/store/order/1")
                .asString();

        assertEquals(200,response.getStatus());
    }

    @Test
    public void verifySuccessfulGetStoreInventoryByUnirest() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/inventory")
                .asString();

        //testin başarılı olup olmadığını anlamak için 200 OK u bekliyoruz
        assertEquals(200,response.getStatus());
    }
}
