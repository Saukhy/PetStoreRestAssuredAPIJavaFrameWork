
package Endpoints;




import Base.BaseClass;
import restUtils.RestUtils;
import io.restassured.response.Response;
import java.util.HashMap;

public class PetEndpoints {

    public Response createPet(String requestPayLoad)
    {
        String endpoint = (String) BaseClass.dataFromJsonFile.get("createPetEndpoint");
        return RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
    }

    public Response getPet(String status)
    {
        String endpoint = (String) BaseClass.dataFromJsonFile.get("getPetEndPoint");
        return RestUtils.getPetByStatus(endpoint ,new HashMap<>(),status);
    }

    public Response updatePet(String requestPayLoad)
    {
        String endpoint = (String) BaseClass.dataFromJsonFile.get("updatePetEndpoint");
        return  RestUtils.updatePetById(endpoint,requestPayLoad,new HashMap<>());
    }


    public Response deletePet(String petId)
    {
        String endpoint = (String) BaseClass.dataFromJsonFile.get("deletePetEndpoint");
        return  RestUtils.deletePetById( endpoint,new HashMap<>() , petId );
    }


    public Response postUploadImage(String petId)
    {
        String endpoint = (String) BaseClass.dataFromJsonFile.get("postUploadImage");
        return  RestUtils.deletePetById( endpoint,new HashMap<>() , petId );
    }




}
