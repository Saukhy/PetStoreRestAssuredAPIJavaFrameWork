package Base;

import JSONUtils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class BaseClass {

    public static Map<String,Object> dataFromJsonFile;

    static{
        String  env  = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("/petStore/"+env+"/petApi.json");
            } catch (IOException e) {
            throw new RuntimeException(e);
                }

        }


}