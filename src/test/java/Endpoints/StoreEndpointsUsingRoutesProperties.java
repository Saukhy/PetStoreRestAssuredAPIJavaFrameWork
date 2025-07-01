package Endpoints;

import Base.BaseClass;
import Utils.RouteBundle;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.ResourceBundle;

import static Utils.RouteBundle.*;

//using urls from Routes.properties using Bundle
public class StoreEndpointsUsingRoutesProperties {


    public Response getInventory() {


        String endpoint = getURL().getString("get_StoreUrl"); // calling the ResourceBundle method from main>Utils>RouteBundle
        return RestUtils.getGeneric(endpoint, new HashMap<>());
    }

//    public Response placeAnOrderForPetFromStore()
//    {
//
//        return RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
//    }
//    public Response getPetByOrderIdFromStore()
//    {
//        String endpoint = (String) BaseClass.dataFromJsonFile.get("get_ByIdUrl");
//        return RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
//    }
//    public Response deletePurchadeOrdeByID()
//    {
//        String endpoint = (String) BaseClass.dataFromJsonFile.get("delete_byIdUrl");
//        return RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
//    }
}
