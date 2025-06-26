package reportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;
import org.testng.ITestResult;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class ExtentReportManager {

    public static ExtentReports extentReport;

    public static ExtentReports createInstanceOfExtentReport(String fileName , String reportName ,String documentTitle)

    {
        ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(fileName);
        extentSparkReport.config().setReportName(reportName);
        extentSparkReport.config().setTheme(Theme.DARK);
        extentSparkReport.config().setReportName(reportName);
        extentSparkReport.config().setDocumentTitle(documentTitle);
        extentSparkReport.config().setEncoding("utf-8");
        extentReport = new ExtentReports();
        extentReport.attachReporter(extentSparkReport);

        return extentReport;
    }

    public static String getReportNameWithTimeStamp()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName;
        reportName = "Test Report" + formattedTime + ".html";
        return reportName;
    }

    public static void logPassDetails(String log)

    {
        SetUp.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailureDetails(String log)
    {
        SetUp.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));

    }

    public static void warningDetails(String log)
    {
        SetUp.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.ORANGE));

    }
    public static void  LogInfoDetails(String log)
    {
        SetUp.extentTest.get().info(MarkupHelper.createLabel(log,ExtentColor.GREY));

    }

    public static void  logJson(String log)
    {
        SetUp.extentTest.get().info(MarkupHelper.createCodeBlock(log, CodeLanguage.JSON));
    }

    public static  void  printHeaders(List<Header> headersList)
    {
       String[][] arrayHeaders =  headersList.stream().map(header -> new String[]{header.getName(),header.getValue()})
               .toArray(String[][] ::new);
       SetUp.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }



}
