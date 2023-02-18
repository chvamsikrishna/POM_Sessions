package ey.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ey.qa.opencart.Utils.ExcelUtils;
import ey.qa.opencart.base.BaseTest;
import eyct.qa.opencart.pages.RegPage;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regPagesetUp()
	{
		register_Page =login_Page.moveToRegister();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object excel_Data[][] = ExcelUtils.readFileData("Sheet1");
		return excel_Data;
	}
	
	@Test(dataProvider = "getData")
	public void registerUserTest(String firstName, String lastName, String telephone, String Password, String subscribe) throws Exception
	{
		
		boolean flag= register_Page.fillRegisterForm(firstName, lastName,register_Page.randomGmail() ,telephone, Password, subscribe);
		Assert.assertTrue(flag);
		
	}
	
	

	

	
	
}
