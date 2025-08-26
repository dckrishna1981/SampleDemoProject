package Pages;

import Base.BaseTest;
import Utilities.ControlUtilities;
import Utilities.ReportingUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;
    public By byUsernameTF = By.xpath("//input[@name='username']");
    private By byPasswordTF = By.xpath("//input[@name='password']");
    private By byUsernameLabel = By.xpath("//label[text()='Username']");
    private By byLoginButton = By.xpath("//button[@type='submit']");

    //private ControlUtilities controlUtilities;
    BaseTest baseTest;


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        baseTest = new BaseTest();
    }

    public void loginOHRM(String strURL,String strUserName,String strPassword)
    {


        baseTest.getDriver().get(strURL);
        baseTest.getControlUtilities(baseTest.getDriver()).waitForElementTillMaxTime(byUsernameTF,"Username",60);
        baseTest.getControlUtilities(baseTest.getDriver()).takeScreenShot();
        baseTest.getControlUtilities(baseTest.getDriver()).setTextIntoTextField(byUsernameTF,"Username",strUserName);
        baseTest.getControlUtilities(baseTest.getDriver()).setTextIntoTextField(byPasswordTF,"Password",strPassword);
        baseTest.getControlUtilities(baseTest.getDriver()).clickElement(byLoginButton,"Login");


    }
}
