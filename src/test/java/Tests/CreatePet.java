package Tests;



import POJO.PetDetails;
import PayLoads.PetPayloadUsingPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class CreatePet {

    @Test

    public void createPetPost() throws JsonProcessingException {

        PetDetails payload  = PetPayloadUsingPOJO.createPayLoad();
        Response response = RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2/user/pet")
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post();

        ObjectMapper objectmapper = new ObjectMapper();

        String resp = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);

        Assert.assertEquals(response.statusCode(),200);

    }
}