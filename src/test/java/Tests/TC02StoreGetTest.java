package Tests;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Endpoints.StoreEndpointsUsingRoutesProperties;
import reportManager.SetUp;

import static restUtils.RestUtils.getGeneric;
@Listeners(SetUp.class)
public class TC02StoreGetTest extends StoreEndpointsUsingRoutesProperties {

    @Test
    public void  deepti ()
    {

        Response response = getInventory();
        Assert.assertEquals(response.statusCode(),200);
        JsonPath json   = response.jsonPath();
        int  c = json.getInt("available");
        Assert.assertTrue(c>0,"available stock is greater than 0");
        System.out.println(c);





    }

}
