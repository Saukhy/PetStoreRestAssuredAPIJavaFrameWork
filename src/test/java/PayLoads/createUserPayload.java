package PayLoads;

import POJO.UserDetails;
import Utils.RandomDataGenerator;
import net.datafaker.Faker;

public class createUserPayload {

    public static UserDetails createUserPayloadUsingPojo()
    {
        Faker faker = new Faker();
        return UserDetails.builder()
                .id(faker.idNumber().hashCode())
                .username(faker.name().firstName())
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())

                .password(faker.internet().password())
            .build();


    }
}
