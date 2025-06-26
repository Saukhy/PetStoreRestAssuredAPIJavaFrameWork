package reportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

public class SetUp implements ITestListener {

    private static ExtentReports extentReports;

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context)

    {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir")+"\\reports\\"+ fileName;
        extentReports = ExtentReportManager.createInstanceOfExtentReport(fullReportPath, "Test API Automation Report", "Test Execution Report");


    }

    public  void onFinish(ITestContext context)

    { if(extentReports!= null)
         extentReports.flush();
    }

    public void onTestStart(ITestResult result)
    {

        ExtentTest test = extentReports.createTest("Test Name" + "-"+ result.getMethod().getMethodName());
        extentTest.set(test);
    }
    public void onTestFailure(ITestResult result)
    {
        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll("," ,"<br>");
        String formattedTrace = "<details>\n" +
                "  <summary>" +
                "Click here for exceptional logs</summary>\n" +
                "  <p>formattedTrace</p>\n" +
                "</details>";
        ExtentReportManager.logFailureDetails(formattedTrace);
    }

}
