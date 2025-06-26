package restUtils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reportManager.ExtentReportManager;
import reportManager.SetUp;

import java.util.*;

public class AssertionUtils {

    public static void assertExpectedValuesWithJsonPath(Response response, Map<String, Object> expectedValuesMap) {
        List<restUtils.AssertionKeys> actualValuesMap = new ArrayList<>();
        // Table headers
        actualValuesMap.add(new restUtils.AssertionKeys("JSON_PATH", "EXPECTED_VALUE", "ACTUAL_VALUE", "RESULT"));
        boolean allMatched = true;
        // Iterate to extract value from response using jsonpath
        Set<String> jsonPaths =  expectedValuesMap.keySet();
        for(String jsonPath : jsonPaths) {
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if(actualValue.isPresent()) {
                Object value = actualValue.get();
                // Assert actual and expected values
                if(value.equals(expectedValuesMap.get(jsonPath)))
                    // if value is matched then add details
                    actualValuesMap.add(new restUtils.AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "MATCHED ✅"));
                else {
                    // if single assertion is failed then to update final result as failure
                    allMatched = false;
                    actualValuesMap.add(new restUtils.AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "NOT_MATCHED ❌"));
                }
            }
            // if jsonpath does not exist in the response
            else {
                allMatched = false;
                actualValuesMap.add(new restUtils.AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), "VALUE_NOT_FOUND", "NOT_MATCHED ❌"));
            }
        }
        // To decide final result
        if(allMatched)
            ExtentReportManager.logPassDetails("All assertions are passed. 😊😊😊😊😊");
        else
            ExtentReportManager.logFailureDetails("All assertions are not passed. 😒😒😒😒😒");

        // To log the details in a tabular format in extent report
        String[][] finalAssertionsMap = actualValuesMap.stream().map(assertions -> new String[] {assertions.getJsonPath(),
                        String.valueOf(assertions.getExpectedValue()), String.valueOf(assertions.getActualValue()), assertions.getResult()})
                .toArray(String[][] :: new);
        SetUp.extentTest.get().info(MarkupHelper.createTable(finalAssertionsMap));
    }
}