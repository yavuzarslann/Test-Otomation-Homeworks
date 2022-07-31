import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PetStoreHttpEntityTests {
    Pets pet;
    HttpHeaders headers;
    RestTemplate restTemplate;

    public PetStoreHttpEntityTests() {
        //yapıcıda Pets, HttpHeaders ve RestTemplate sınıfında nesen oluşturuyoruz
        pet = new Pets();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate = new RestTemplate();
    }

    @Test
    public void verifySuccessfulPlaceOrderByHttpEntity() throws JsonProcessingException {
        //place order API si (POST) için gerekli parametreleri tanımlıyoruz
        int id = 9;
        String petId = "2";
        String quantity = "37";
        String shipDate = "22";
        String status = "placed";
        boolean complete = true;
        pet.setId(id);
        pet.setPetId(petId);
        pet.setQuantity(quantity);
        pet.setComplete(complete);
        pet.setShipDate(shipDate);
        pet.setStatus(status);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(pet);

        HttpEntity<String> request =
                new HttpEntity<String>(jsonString, headers);

        String orderResultAsJsonStr =
                restTemplate.postForObject("https://petstore.swagger.io/v2/store/order", request, String.class);
        com.fasterxml.jackson.databind.JsonNode root = mapper.readTree(orderResultAsJsonStr);

        assertNotNull(orderResultAsJsonStr);
        assertNotNull(root);
        assertNotNull(root.path("complete").asText());
        assertEquals(true, root.path("complete").asBoolean());

    }

}
