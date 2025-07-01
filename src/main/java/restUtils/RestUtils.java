package restUtils;

import Authentication.APIKeyAuthentication;
import Authentication.Authentication;
import Authentication.AuthManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reportManager.ExtentReportManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, Map<String, Object> headers) {
        return RestAssured
                .given()
                .log().all()
                .baseUri(endpoint)
                .headers(headers) //use as map
                .contentType(ContentType.JSON);

    }

    private static RequestSpecification getRequestSpecification(Map<String, Object> headers) {
        return RestAssured
                .given()
                .log().all()
                .headers(headers)
                .log().all();


    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.LogInfoDetails("Details " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.LogInfoDetails("Methods " + queryableRequestSpecification.getMethod());
        ExtentReportManager.LogInfoDetails("Headers ");
        ExtentReportManager.printHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.LogInfoDetails("Request Body " + queryableRequestSpecification.getBody());

    }


    public static Response performPost(String endpoint, String requestPayload, Map<String, Object> headers) {

        Authentication auth;
        auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);

        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
        requestSpecification = authManger.applyAuth(requestSpecification);
        Response response = requestSpecification
                .body(requestPayload)
                .post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;


    }

    //Request specification can be used for both GET and POSt


    private static void printResponseLogInReport(Response response) {

        ExtentReportManager.LogInfoDetails("Details " + response.getStatusCode());
        ExtentReportManager.LogInfoDetails("Headers ");
        ExtentReportManager.printHeaders(response.getHeaders().asList());
        ExtentReportManager.LogInfoDetails("Response Body ");
        ExtentReportManager.logJson(response.getBody().asPrettyString());
        String apikeyValue = response.getCookie("api_key");
        if (apikeyValue != null) {
            ExtentReportManager.LogInfoDetails("api_key cookie: " + apikeyValue);
        } else {
            ExtentReportManager.LogInfoDetails("api_key cookie: <not present>");
        }
         ExtentReportManager.LogInfoDetails(apikeyValue);

    }
    //basic utility using payload as string


    public static Response performPost(String endpoint, Object requestPayload, Map<String, Object> headers) {

        Authentication auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);


        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
        requestSpecification = authManger.applyAuth(requestSpecification);
        Response response = requestSpecification
                .body(requestPayload)
                .post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response getPetByStatus(String endpoint, Map<String, Object> headers, String status) {
        Authentication auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);

        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
        requestSpecification = authManger.applyAuth(requestSpecification);

        Response response = requestSpecification
                .queryParam("status", status)
                .get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response updatePetById(String endpoint, Object requestPayload, Map<String, Object> headers) {
        Authentication auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);

        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
        requestSpecification = authManger.applyAuth(requestSpecification);
        Response response = requestSpecification
                .body(requestPayload)
                .put();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response deletePetById(String endpoint, Map<String, Object> headers, String petId) {
        Authentication auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);

        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
       requestSpecification = authManger.applyAuth(requestSpecification);
        Response response = requestSpecification

                .delete("/pet/" + petId);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response uploadImage(String endpoint, Map<String, Object> headers ,String petId , String path) {
        File file = new File("Dog.jpg");
        Authentication auth = new APIKeyAuthentication("api_key", "special-key");
        AuthManager authManger = new AuthManager(auth);


        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers);
        requestSpecification = authManger.applyAuth(requestSpecification);
        Response response = requestSpecification

                .multiPart("file",file)
                .post("/pet/" + petId);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response getGeneric(String endpoint ,Map<String, Object> headers)
    {

        RequestSpecification requestSpecification = getRequestSpecification(new HashMap<>());
        Response response = requestSpecification
                .get(endpoint);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;


    }
}




