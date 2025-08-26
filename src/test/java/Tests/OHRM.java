package Tests;

import Base.BaseTest;
import groovyjarjarasm.asm.commons.Method;
import org.testng.annotations.Test;

public class OHRM extends BaseTest
{


    @Test
    public void TC_001()
    {

        getReportingUtilities().createTestNode(Thread.currentThread().getStackTrace()[1].getMethodName());
        String strURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        getLoginPage().loginOHRM(strURL,"Admin","admin123");
        getReportingUtilities().logStep("step1_1");
        getHomePage().logOutOHRM();
    }

    @Test
    public void TC_002()
    {
        getReportingUtilities().createTestNode(Thread.currentThread().getStackTrace()[1].getMethodName());
        String strURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        getLoginPage().loginOHRM(strURL,"Admin","admin123");
        getReportingUtilities().logStep("step2_1");
        getHomePage().logOutOHRM();
    }

    @Test
    public void TC_003()
    {
        getReportingUtilities().createTestNode(Thread.currentThread().getStackTrace()[1].getMethodName());
        String strURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        getLoginPage().loginOHRM(strURL,"Admin","admin123");
        getReportingUtilities().logStep("step3_1");
        getHomePage().logOutOHRM();
    }
}
