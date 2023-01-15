package ey.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import eyct.qa.opencart.factory.DriverFactory;
import eyct.qa.opencart.pages.AccountPage;
import eyct.qa.opencart.pages.LoginPage;
import eyct.qa.opencart.pages.SearchPage;

public class BaseTest {

    /* Rules: 
     *    Should hold driver created by driverFactory
     *    Maintain page specific object. 
     */
	
	
	WebDriver driver;
	DriverFactory df;
	
    protected LoginPage login_Page;
    protected AccountPage account_Page;
    protected SearchPage search_Page;
   
     @BeforeClass
     public void setUp()
     {
    	 df = new DriverFactory();
    	driver= df.init("chrome");
    	login_Page = new LoginPage(driver);
     }
     
     @AfterClass
     public void tearDown()
     {
    	 driver.close();
     }
     

}
