package Tests;



import Endpoints.PetEndpoints;
import PayLoads.PetPayloadUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import reportManager.SetUp;
import restUtils.RestUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

//@Listeners(SetUp.class)

public class TC01DeletePet extends PetEndpoints {


    static Integer petId;

    @Test(priority = 1)
    public void createPetUsingPOJO() {

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

    @Test(priority = 2)


    public void deletePet() {
//        Awaitility
//                .await()
//                .atMost(Duration.ofSeconds(10)) //for much u want to try or timespan
//                .pollInterval(Duration.ofSeconds(2));

        Response response = deletePet(String.valueOf(petId));
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Pet id" + petId + "is deleted");


    }
}
