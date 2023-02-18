package eyct.qa.opencart.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ey.qa.opencart.Utils.ElementUtils;
import ey.qa.opencart.Utils.JavaScriptUtil;
import ey.qa.opencart.Utils.TimeUtil;

public class RegPage {
	
	private WebDriver driver;
	private ElementUtils ele;
	private JavaScriptUtil js;
	
	private By FirstName = By.id("input-firstname");
	private By LastName = By.id("input-lastname");
	private By E_Mail = By.id("input-email");
	private By Telephone = By.id("input-telephone");
	private By Password = By.id("input-password");
	private By Confirm_Password = By.id("input-confirm");
		
	private By Subscribe_Yes = By.xpath("(//label[@class='radio-inline'])[1]/input");
	private By Subscribe_No = By.xpath("(//label[@class='radio-inline'])[2]/input");
	private By Privacy_Policy = By.xpath("//input[@name='agree']");
	private By Continue = By.xpath("//input[@value='Continue']");
	
	
	private By registerSuccess = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
		
	
	public RegPage(WebDriver driver){
		this.driver = driver;
		ele = new ElementUtils(driver);
		js = new JavaScriptUtil(driver);
	}
	
	
	public String randomGmail()
	{
		Random r = new Random();
		String email = "mail"+r.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	
	
	public boolean fillRegisterForm(String firstname, String lastname, String email, String telephone,  String password, String subscribe) throws Exception
	{
	    
		ele.waitForElementVisible(FirstName, TimeUtil.DEFAULT_TIME_OUT).sendKeys(firstname);
		ele.doSendKeys(LastName, lastname);
		ele.doSendKeys(Telephone, telephone);
		ele.doSendKeys(E_Mail, email);
		ele.doSendKeys(Password, password);
		ele.doSendKeys(Confirm_Password, password);
		
		if(subscribe.equalsIgnoreCase("yes"))
		{
			ele.doClick(Subscribe_Yes);
		}
		else
		{
			ele.doClick(Subscribe_No);
		}
		
		ele.doClick(Privacy_Policy);
		ele.doClick(Continue);
		
		
		String successMessage = ele.waitForElementVisible(registerSuccess,TimeUtil.DEFAULT_TIME_OUT).getText();
		System.out.println(successMessage);
		
		if(successMessage.contains("Created"))
		{
			//js.scrollIntoView(driver.findElement(logoutLink));
			js.scrollPageDown();
			ele.doClick(logoutLink);
			ele.doClick(registerLink);
			return true;
		}
		else
		{
			System.out.println("User "+firstname+" registration got failed");
			ele.doClick(registerLink);
		}
		return false;
	}
	
	
	

}
