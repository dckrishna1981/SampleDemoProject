package Utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ReportingUtilities {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static ThreadLocal<ExtentTest> tExtentTest = new ThreadLocal<>();
    private static ExtentSparkReporter sparkReporter;

    private static final String REPORT_FOLDER = System.getProperty("user.dir") + File.separator + "Reports";

    public void initializeReport() {
        String reportName = "TestReport_" + System.currentTimeMillis() + ".html";
        new File(REPORT_FOLDER).mkdirs(); // Ensure the folder exists
        sparkReporter = new ExtentSparkReporter(REPORT_FOLDER + File.separator + reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public void flushReport() {
        if (extentReports != null)
            extentReports.flush();
    }

    public ExtentTest createTestNode(String testName) {
        extentTest = extentReports.createTest(testName);
        tExtentTest.set(extentTest);
        return extentTest;
    }

    public ExtentTest getTest() {
        return tExtentTest.get();
    }

    public void logStep(String s)
    {
        getTest().log(Status.PASS,s);
        //extentTest.log(Status.PASS,s);
    }
}
