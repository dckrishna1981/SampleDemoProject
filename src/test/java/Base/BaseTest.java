package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ControlUtilities;
import Utilities.ReportingUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

public class BaseTest
{
    private static ThreadLocal <WebDriver>tDriver=new ThreadLocal<>();
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ReportingUtilities reportingUtilities;
    private ControlUtilities controlUtilities;



    public LoginPage getLoginPage()
    {
        loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public HomePage getHomePage()
    {
        homePage = new HomePage(getDriver());
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

    public WebDriver getDriver()
    {
        return tDriver.get();
    }

    @BeforeMethod
    public void setup()
    {
        //with simple driver
        /*
        driver = new ChromeDriver();
        tDriver.set(driver);
        driver.manage().window().maximize();

         */

        //with grid and no docker
        WebDriver driver;URL url=null;
        String hburl = "http://localhost:4444";
        ChromeOptions dp=new ChromeOptions();
        //dp.setPlatform(Platform.WIN10);
       // dp.setBrowserName(Browser.CHROME.browserName());
        try{
        url=new URL(hburl);
        }
        catch(Exception e){}
        driver=new RemoteWebDriver(url,dp);
        tDriver.set(driver);
        driver.manage().window().maximize();
        //getReportingUtilities().createTestNode("first test");

    }

    @AfterMethod
    public void tearDown()
    {
        if(getDriver()!=null)
            getDriver().quit();
        tDriver.remove();
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
