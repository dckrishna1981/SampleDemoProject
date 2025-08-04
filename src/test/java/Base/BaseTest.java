package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ControlUtilities;
import Utilities.ReportingUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest
{
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ReportingUtilities reportingUtilities;
    private ControlUtilities controlUtilities;

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    public LoginPage getLoginPage()
    {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public HomePage getHomePage()
    {
        homePage = new HomePage(driver);
        return homePage;
    }

    public ReportingUtilities getReportingUtilities()
    {
        reportingUtilities = new ReportingUtilities();
        return reportingUtilities;
    }

    public ControlUtilities getControlUtilities(WebDriver driver)
    {
        controlUtilities = new ControlUtilities(driver);
        return controlUtilities;
    }

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //getReportingUtilities().createTestNode(Thread.currentThread().getName());
    }

    @AfterMethod
    public void tearDown()
    {
        if(driver!=null)
            driver.quit();
    }

    @BeforeSuite
    public void setupReportSparker()
    {
        getReportingUtilities().initializeReport();

    }

    @AfterSuite
    public void tearDownReports()
    {
        getReportingUtilities().flushReport();

    }



}
