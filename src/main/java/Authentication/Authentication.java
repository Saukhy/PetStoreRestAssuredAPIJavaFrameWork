package Authentication;

import io.restassured.specification.RequestSpecification;

public interface Authentication {

    RequestSpecification apply(RequestSpecification request);
}
