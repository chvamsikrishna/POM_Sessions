package ey.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import eyct.qa.opencart.factory.DriverFactory;
import eyct.qa.opencart.pages.AccountPage;
import eyct.qa.opencart.pages.LoginPage;
import eyct.qa.opencart.pages.Productinfo;
import eyct.qa.opencart.pages.RegPage;
import eyct.qa.opencart.pages.SearchPage;

public class BaseTest {

    /* Rules: 
     *    Should hold driver created by driverFactory
     *    Maintain page specific object. 
     */
	
	
	WebDriver driver;
	DriverFactory df;
	
	protected Properties prop;
	
    protected LoginPage login_Page;
    protected AccountPage account_Page;
    protected SearchPage search_Page;
    protected Productinfo product_info;
    protected RegPage register_Page;
   
     @BeforeClass
     public void setUp()
     {
    	 df = new DriverFactory();
    	 prop = df.prop_Init();
    	driver= df.init(prop);
    	login_Page = new LoginPage(driver);
     }
     
     @AfterClass
     public void tearDown()
     {
    	 driver.close();
     }
     

}
