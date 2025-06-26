package Tests;



import Endpoints.PetEndpoints;
import PayLoads.PetPayloadUsingPOJO;

import io.restassured.response.ResponseBody;
import org.testng.annotations.Listeners;
import reportManager.SetUp;
import restUtils.RestUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

@Listeners(SetUp.class)
public class CreateTest extends PetEndpoints {


    // test using basic utility class where payload and endpoint is hardcoded
    @Test
    public void createPet()
    {

        String endPoint ="https://petstore.swagger.io/v2/pet";
        Response response = RestUtils.performPost(endPoint, PetPayloadUsingPOJO.createPayLoad(),new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
       System.out.println("Basic Test");

    }


        //using Base class
    @Test
    public void createPetEnvEndpoint()

    {
        

        String payload = """
                {
                    "id": 165,
                    "category": {
                        "id": 10,
                        "name": "Dog"
                    },
                    "name": "Bruno",
                    "photoUrls": [],
                    "tags": [
                        {
                            "id": "1",
                            "name": "Bruno"
                        }
                    ],
                    "status": "available"
                }""";

        Response response = createPet(payload);
        ResponseBody responseBody = response.getBody();
        String responseString = responseBody.asString();

        System.out.println("json is " + responseString);
//        Object s = response.jsonPath().get("id");
//        Assert.assertEquals(response.statusCode(),200);
//        System.out.println(s);

    }

@Test
    public void createPetUsingPOJO()
    {

        String endPoint ="https://petstore.swagger.io/v2/pet";
//        String payload = """
//                {
//                    "id": 1265,
//                    "category": {
//                        "id": 10,
//                        "name": "Dog"
//                    },
//                    "name": "Bruno",
//                    "photoUrls": [https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/,https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/],
//                    "tags": [
//                        {
//                            "id": "1",
//                            "name": "Bruno"
//                        }
//                    ],
//                    "status": "available"
//                }""";
        Response response = RestUtils.performPost(endPoint, PetPayloadUsingPOJO.createPayLoad(),new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
        System.out.println("This has used POJO for payload");




    }
}
