package eyct.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverFactory {
	
	public WebDriver driver;
	
	@BeforeTest
	public WebDriver init(String driverValue)
	{
		if(driverValue.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();		
		}
		else if(driverValue.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter the correct driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		return driver;
	}
	

	
	

}
