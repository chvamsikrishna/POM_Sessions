package eyct.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.qa.opencart.Utils.AppConstants;
import ey.qa.opencart.Utils.ElementUtils;
import ey.qa.opencart.Utils.TimeUtil;

public class LoginPage {

	/* Rules
	 *  
	 *  Page Specific webdriver 
	 * 1. Create Private Locators
	 * 2. Create page specific constructors
	 * 3. Actions Methods
	 * 4. No assertions
	 */
	
    private WebDriver driver;
    private ElementUtils element_Utils;
    
    private By email = By.xpath("//input[@id='input-email']");
    private By password = By.xpath("//input[@id='input-password']");
    private By login = By.xpath("//input[@type='submit']");
    //forgot password
    private By register = By.xpath("//a[contains(text(), 'Register') and @class]");
    
    
    
    public LoginPage(WebDriver driver)
    {
    	this.driver = driver;  	
    	element_Utils = new ElementUtils(driver);
    }
    
   
    public String getLoginPageTitle()
    {
    	//return driver.getTitle();
    	return element_Utils.waitForTitleIs(AppConstants.LOGIN_TITLE, TimeUtil.DEFAULT_TIME_OUT);
    }
    
    public String getPageURL()
    {
    	return driver.getCurrentUrl();
    }
    
    public AccountPage login(String username, String pass) throws InterruptedException
    {
    	//driver.findElement(email).sendKeys(username);
    	//driver.findElement(password).sendKeys(pass);
    	//driver.findElement(login).click();
    	element_Utils.waitForElementVisible(email, TimeUtil.DEFAULT_TIME_OUT).sendKeys(username);
        element_Utils.doSendKeys(password, pass);
        element_Utils.doClick(login);
    	//element_Utils.wait(5000);
    	
    	return new AccountPage(driver);
        	
    }
    
    public RegPage moveToRegister()
    {
    	element_Utils.doClick(register);
        return new RegPage(driver);
    }
 
    
    
    
	 
}
