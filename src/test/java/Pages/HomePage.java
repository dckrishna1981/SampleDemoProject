package Pages;

import Base.BaseTest;
import Utilities.ControlUtilities;
import Utilities.ReportingUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    private WebDriver driver;
    private By byProfileIconImage = By.xpath("//img[@alt='profile picture']");
    private By byLogoutLink = By.linkText("Logout");

    private ControlUtilities controlUtilities;
    private ReportingUtilities reportingUtilities;
    private BaseTest base;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        controlUtilities = new ControlUtilities(driver);
        reportingUtilities = new ReportingUtilities();
        base = new BaseTest();

    }

    public void logOutOHRM()
    {
        controlUtilities.clickElement(byProfileIconImage,"Profile Picture");
        controlUtilities.clickElement(byLogoutLink,"Logout");
        if(controlUtilities.waitForElementTillMaxTime(base.getLoginPage().byUsernameTF,"Username",10)) {
            System.out.println("Successfully Logged Out");

            controlUtilities.takeScreenShot();
            //reportingUtilities.logTestStep("step1");
            //reportingUtilities.logTestStep("step2");
           // reportingUtilities.logTestStep("step3");
           // reportingUtilities.logTestStep("step4");

        }
    }
}
