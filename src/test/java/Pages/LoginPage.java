package Pages;

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

    private ControlUtilities controlUtilities;


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        controlUtilities = new ControlUtilities(driver);
    }

    public void loginOHRM(String strURL,String strUserName,String strPassword)
    {

        driver.get(strURL);
        controlUtilities.waitForElementTillMaxTime(byUsernameTF,"Username",60);
        controlUtilities.takeScreenShot();
        controlUtilities.setTextIntoTextField(byUsernameTF,"Username",strUserName);
        controlUtilities.setTextIntoTextField(byPasswordTF,"Password",strPassword);
        controlUtilities.clickElement(byLoginButton,"Login");


    }
}
