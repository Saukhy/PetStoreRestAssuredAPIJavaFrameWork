package JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;


// to handle different environments

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String,Object> getJsonDataAsMap(String jsonFileName) throws IOException {


        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;

        Map<String,Object> data = objectMapper.readValue(new File(completeJsonFilePath) ,new TypeReference<>(){});

        return data;
    }


}
