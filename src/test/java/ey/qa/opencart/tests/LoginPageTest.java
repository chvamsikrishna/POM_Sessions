package ey.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ey.qa.opencart.base.BaseTest;


public class LoginPageTest extends BaseTest{
	
	
	@Test
	public void getLoginPageTitle_Test()
	{
		
		String actTitle = login_Page.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login_Updated");
	}
	
	@Test
	public void getPageURL_Test()
	{
		String actualURL =login_Page.getPageURL();
	    Assert.assertTrue(actualURL.contains("route=account/login"));
	}
	
	
	@Test
	public void login_Test() throws InterruptedException
	{
        
		account_Page =login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(account_Page.logoutVisibility());
	   	
			
	}
	
	
	

}
