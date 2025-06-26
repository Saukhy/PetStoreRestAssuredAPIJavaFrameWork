package Tests;

import Endpoints.PetEndpoints;
import Utils.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportManager.ExtentReportManager;
import reportManager.SetUp;

//@Listeners(SetUp.class)
public class TC01_GetPetByStatus extends PetEndpoints {

    @Test
    public void getPetByStatusAvailable() {

//
//        String response =  RestAssured.given()
//                .log()
//                .all()
//                .baseUri("https://petstore.swagger.io/v2/pet/findByStatus")
//                .queryParam("status","available")
//                .when()
//                .get()
//                .then()
//                 .log()
//                .all()
//                .extract()
//                .body() //not required if you remove you will get same response
//                .asPrettyString();
//
//    System.out.println(response);


        Response response = getPet(String.valueOf(Status.available));
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test
    public void getPetByStatusPending() {


        Response response = getPet(String.valueOf(Status.pending));
        Assert.assertEquals(response.statusCode(), 200);

    }


    @Test
    public void getPetByStatusSold() {


        Response response = getPet(String.valueOf(Status.sold));
        Assert.assertEquals(response.statusCode(), 200);


    }

}
