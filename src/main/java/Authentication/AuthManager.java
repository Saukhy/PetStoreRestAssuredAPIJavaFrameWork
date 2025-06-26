package Authentication;

import io.restassured.specification.RequestSpecification;

public class AuthManager {

    private Authentication finalAuthentication;

        public AuthManager(Authentication finalAuthentication)
        {
            this.finalAuthentication =finalAuthentication;
        }
    public RequestSpecification applyAuth(RequestSpecification request) {
        return finalAuthentication.apply(request);
    }
}

