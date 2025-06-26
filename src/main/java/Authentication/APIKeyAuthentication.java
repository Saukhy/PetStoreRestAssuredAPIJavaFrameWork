package Authentication;

import io.restassured.specification.RequestSpecification;

public class APIKeyAuthentication implements Authentication
{

        private String headerName;
        private String api_key;

        public APIKeyAuthentication(String headerName,String api_key)
        {
            this.headerName=headerName;
            this.api_key=api_key;
        }

    @Override
    public RequestSpecification apply(RequestSpecification request) {
        return request.header(headerName,api_key);
    }
}
