import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //testleri istediğimiz sırada gerçekleştirebilmek için kullanılan notasyon
public class PetStoreRestAssuredTests {
    Response response;
    Pets pet;

    //place order API si (POST) için gerekli parametreleri tanımlıyoruz
    int id = 9;
    String petId = "2";
    String quantity = "37";
    String shipDate = "22";
    String status = "placed";
    boolean complete = true;

    //yapıcıda Pets sınıfında nesen oluşturuyoruz
    public PetStoreRestAssuredTests() {
        pet = new Pets();
    }

    @Test // POST (Place an order for a pet)
    @Order(1)
    public void verifySuccessfulPlaceOrderByRestAssured() throws JsonProcessingException {
        //Pets sınıfından oluşturdupumuz nesneye gerekli değerleri atıyoruz
        pet.setId(id);
        pet.setPetId(petId);
        pet.setQuantity(quantity);
        pet.setComplete(complete);
        pet.setShipDate(shipDate);
        pet.setStatus(status);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(pet);//bodye göndereceğimiz parametreleri bir araya topluyoruz

        response = given()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        JsonPath getOrderJson =  response.jsonPath();

        //testin başarılı olduğunu anlamak için 200 OK ve complete değerini true bekliyoruz
        assertEquals(200, response.statusCode());
        assertEquals(true, getOrderJson.get("complete"));
    }

    @Test // GET (Find purchase order by ID)
    @Order(2)
    public void verifySuccessfulGetOrderByRestAssured(){
        response = given()
                .get("https://petstore.swagger.io/v2/store/order/"+id)
                .then()
                .statusCode(200)
                .extract().response();

        JsonPath getOrderJson =  response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals(true, getOrderJson.get("complete"));
    }

    @Test // DELETE (Delete purchase order by ID)
    @Order(3)
    public void verifySuccessfulDeleteOrderByRestAssured(){
        response= when()
                .delete("https://petstore.swagger.io/v2/store/order/"+id)
                .then()
                .statusCode(200)
                .extract().response();

        JsonPath getOrderJson =  response.jsonPath();
        //testin başarılı olduğunu anlamak için 200 OK ve message değerini silinen id olarak bekliyoruz
        assertEquals(200,response.getStatusCode());
        assertEquals(Integer.toString(id), getOrderJson.get("message"));
    }

    @Test //GET (Returns pet inventories by status)
    @Order(4)
    public void verifyGetStoreInventoryByRestAssured() {
        response = given()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200)
                .extract().response();
        //testin başarılı olup olmadığını anlamak için 200 OK u bekliyoruz
        assertEquals(200, response.statusCode());
    }
}
