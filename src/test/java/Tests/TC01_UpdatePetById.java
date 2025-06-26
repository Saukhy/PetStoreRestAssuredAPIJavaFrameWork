package Tests;

import PayLoads.PetPayloadUsingPOJO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import reportManager.SetUp;
import restUtils.RestUtils;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Endpoints.PetEndpoints;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


//@Listeners(SetUp.class)

public class TC01_UpdatePetById extends PetEndpoints{
    static Integer petId;

    @Test(priority = 1)
    public void createUserWithPost() {

        String endPoint = "https://petstore.swagger.io/v2/pet";
        String payload = """
                {
                    "id": 1265,
                    "category": {
                        "id": 10,
                        "name": "Dog"
                    },
                    "name": "Bruno",
                    "photoUrls": [https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/,https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/],
                    "tags": [
                        {
                            "id": "1",
                            "name": "Bruno"
                        }
                    ],
                    "status": "available"
                }""";
        Response response = RestUtils.performPost(endPoint, PetPayloadUsingPOJO.createPayLoad(), new HashMap<>());

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("This has used POJO for payload");

        ResponseBody responsebody = response.getBody();

        JsonPath json = response.jsonPath();
        petId = json.get("id");
//        String responseString = responsebody.asString();
//        JsonPath jsonPathView  = responsebody.jsonPath();
//        Object id = jsonPathView.getString(".id");
        System.out.println(petId);


    }

    @Test(priority = 2, dependsOnMethods = "createUserWithPost")
    public void updateUserWithPut() {
        String putBody = "{\n" +
                "  \"id\":" + petId + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}";

        Response response = updatePet(putBody);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Updated status,name,category");
    }
}
//        given()
//                .header("Content-Type", "application/json")
//                .body(PetPayloadUsingPOJO.createPayLoad())
//                .when()
//                .put("/pet" + createdId)
//                .then()
//                .statusCode(200)
//                .body("status", equalTo("sold"));
//    @Test
//    public void createPet() throws InterruptedException {
//
//        String payload = "{\n" +
//                "  \"id\": 100,\n" +
//                "  \"category\": {\n" +
//                "    \"id\": 0,\n" +
//                "    \"name\": \"string\"\n" +
//                "  },\n" +
//                "  \"name\": \"doggie\",\n" +
//                "  \"photoUrls\": [\n" +
//                "    \"string\"\n" +
//                "  ],\n" +
//                "  \"tags\": [\n" +
//                "    {\n" +
//                "      \"id\": 0,\n" +
//                "      \"name\": \"string\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"status\": \"available\"\n" +
//                "}";
//        Response response = createPet(payload);
//        //String a = response.jsonPath().getString("id");
//        System.out.println(response +"this is the new id");
//        Assert.assertEquals(response.statusCode(), 200);
//
//        wait();
////
////        Response resp = RestAssured
////                .given()
////                .log().all()
////                .get("https://petstore.swagger.io/v2/pet/a");
//
//
//
//       // Response res = updatePet(json);
//
//
//    }}
