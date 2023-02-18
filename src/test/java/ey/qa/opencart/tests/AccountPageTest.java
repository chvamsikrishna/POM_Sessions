package ey.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ey.qa.opencart.Utils.AppConstants;
import ey.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest {
	
	// to get to AccountPage we have to login first then navigate to accountPage
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		account_Page = login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void logoutDisplyedTest()
	{
		Assert.assertTrue(account_Page.logoutVisibility());
	}
	
	@Test
	public void accountTitleTest()
	{
		String actualTilte = account_Page.getAccountPageTitle();
		Assert.assertEquals(actualTilte, "My Account");	
	}
	
	@Test
	public void account_HeadersTest()
	{
		List<String> actualHeaders = account_Page.leftHeaders();
		Assert.assertEquals(actualHeaders, AppConstants.ACCOUNT_HEADERS);
		
	}
	

	@DataProvider()
	public Object[][] sampleData()
	{
		
		String value[][] = {{"iMac"},{"MacBook"}, {"samsung"}};
		return value;
		
	}
	
	
	@Test(priority = 3, dataProvider="sampleData")
	public void productList(String productName)
	{
	   	
		account_Page.searchBox(productName);
		
	}
	
	
	

}
