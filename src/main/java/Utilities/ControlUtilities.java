package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;

import java.io.File;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;




public class ControlUtilities
{
    private WebDriver driver;
    ReportingUtilities reportingUtilities;

    public ControlUtilities(WebDriver driver)
    {
        this.driver = driver;
        reportingUtilities = new ReportingUtilities();
    }

    public void setTextIntoTextField(By byLocator,String strLocatorDescription, String strValue)
    {
        if(checkElementExists(byLocator,strLocatorDescription)) {
            driver.findElement(byLocator).click();
            driver.findElement(byLocator).sendKeys(strValue);
            reportingUtilities.logStep("The text field '" + strLocatorDescription + "'" + " set to '" + strValue + "'");
            System.out.println("The text field '" + strLocatorDescription + "'" + " set to '" + strValue + "'");
        }
    }

    public void clickElement(By byLocator,String strLocatorDescription)
    {
        //if(checkElementExists(byLocator,strLocatorDescription))
        if(waitForElementTillMaxTime(byLocator,strLocatorDescription,60)) {
            driver.findElement(byLocator).click();
            reportingUtilities.logStep("The Button/Link '" + strLocatorDescription + "' is clicked");
            System.out.println("The Button/Link '" + strLocatorDescription + "' is clicked");
        }
    }

    public boolean checkElementExists(By byLocator,  String strLocatorDescription)
    {
        boolean blnFound=false;
        try
        {
            if (driver.findElement(byLocator).isDisplayed()) {
                blnFound = true;
                return blnFound;
            }
        }
        catch(Exception ignored)
        {
            System.out.println("The Element '" + strLocatorDescription + "' is NOT found.");
        }
        return blnFound;
    }

    public boolean waitForElementTillMaxTime(By byLocator, String strEleDescription, int intMaxSeconds)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(intMaxSeconds));
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
            return true;
        }
        catch(TimeoutException te)
        {
            reportingUtilities.logStep("The Element '" + strEleDescription + "' is NOT found after waiting the Max time of " + intMaxSeconds + " seconds");
            System.out.println("The Element '" + strEleDescription + "' is NOT found after waiting the Max time of " + intMaxSeconds + " seconds");
            return false;
        }
    }

    public void takeScreenShot()
    {
        String strProjectDir = System.getProperty("user.dir");
        TakesScreenshot ts=(TakesScreenshot)driver;
        File in = ts.getScreenshotAs(OutputType.FILE);
        Timestamp timeStamp=new Timestamp(new Date().getTime());
        File out=new File(strProjectDir + File.separator + "ScreenShots" + File.separator + "Screen_" + System.currentTimeMillis() + ".png");
        try{FileHandler.copy(in,out);}catch(Exception e){}
    }

}
