package eyct.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    
    private By email = By.xpath("//input[@id='input-email']");
    private By password = By.xpath("//input[@id='input-password']");
    private By login = By.xpath("//input[@type='submit']");
    //forgot password
    
    
    public LoginPage(WebDriver driver)
    {
    	this.driver = driver;  	
    }
    
   
    public String getLoginPageTitle()
    {
    	return driver.getTitle();
    }
    
    public String getPageURL()
    {
    	return driver.getCurrentUrl();
    }
    
    public AccountPage login(String username, String pass)
    {
    	driver.findElement(email).sendKeys(username);
    	driver.findElement(password).sendKeys(pass);
    	driver.findElement(login).click();
    	
    	return new AccountPage(driver);
        	
    }
 
    
	 
}
