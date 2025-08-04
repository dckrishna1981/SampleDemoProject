package Tests;

import Base.BaseTest;
import groovyjarjarasm.asm.commons.Method;
import org.testng.annotations.Test;

public class OHRM extends BaseTest
{
    private BaseTest base;

    @Test
    public void initialTest()
    {

        //getReportingUtilities().initializeReport();

        //getReportingUtilities().logStep("test passed");
        //getReportingUtilities().createTest("Initial Test");
        String strURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        getLoginPage().loginOHRM(strURL,"Admin","admin123");
        getHomePage().logOutOHRM();
    }

    //@Test
    public void secondaryTest()
    {
        String strURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        getLoginPage().loginOHRM(strURL,"Admin","admin123");
        getHomePage().logOutOHRM();
    }
}
