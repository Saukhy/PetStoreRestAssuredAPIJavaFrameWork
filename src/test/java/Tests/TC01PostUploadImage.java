package Tests;

import Endpoints.PetEndpoints;
import PayLoads.PetPayloadUsingPOJO;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportManager.SetUp;
import restUtils.RestUtils;
import java.util.HashMap;


//@Listeners(SetUp.class)
public class TC01PostUploadImage extends PetEndpoints {

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
    @Test(priority = 2)
    public void uploadImage() {


        Response response = postUploadImage(String.valueOf(petId));
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Pet id" + petId + "is deleted");


    }


}
