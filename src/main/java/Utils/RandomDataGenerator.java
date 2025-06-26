package Utils;

import Utils.RandomDataTypeNames;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import javax.naming.Name;


public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomeData(RandomDataTypeNames dataTypeNames) {

        switch (dataTypeNames)
        {
            case PETNAME:

                return faker.name().firstName();

            default:
                return "Data type name not available";

        }

    }

    public static String photoUrl() {
        return faker.internet().image();
    }


    public static String getRandomNumber(int count) {
        return faker.number().digits(count);
    }


    public static String getRandomAlphabets(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }
}