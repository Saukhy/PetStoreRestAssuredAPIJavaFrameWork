package Endpoints;

import POJO.UserDetails;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;

public class UserEndpointsUsingRoutes {

    public Response createUser(UserDetails requestPayload) {


        String endpoint = UserRoutes.userRoutespost_url; // calling the ResourceBundle method from main>Utils>RouteBundle
        return RestUtils.performPost(endpoint,requestPayload, new HashMap<>());
    }
}
