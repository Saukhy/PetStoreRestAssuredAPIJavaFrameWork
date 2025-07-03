package Tests;

import Endpoints.UserEndpointsUsingRoutes;
import POJO.UserDetails;
import PayLoads.PetPayloadUsingPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportManager.SetUp;


import static PayLoads.createUserPayload.createUserPayloadUsingPojo;

//@Listeners(SetUp.class)
public class TC03CreateUser extends UserEndpointsUsingRoutes {


@Test
    public void userCreation() throws JsonProcessingException {
        Response response = createUser(createUserPayloadUsingPojo());
        String resp = response.getBody().asPrettyString();

        Assert.assertEquals(response.statusCode(),200);



//        ObjectMapper objectmapper = new ObjectMapper();
//        UserDetails UserDetailsobj = objectmapper.readValue(resp ,UserDetails.class);
//        System.out.println(UserDetailsobj.getId() + "- " + "Id");
//        System.out.println(UserDetailsobj.getFirstname() + " - " + "Firstname");
    }
}
