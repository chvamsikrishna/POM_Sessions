package ey.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ey.qa.opencart.base.BaseTest;

public class SearchPageTest extends BaseTest{
	

	@BeforeClass
	public void login_Account() throws Exception
	{
		account_Page =login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
	    search_Page =account_Page.searchBox("mac");
	}
	
	

	
	@Test(priority = 1)
	public void searchPageTitle()
	{
		String actual_Title = search_Page.searchPageTitle();
		Assert.assertTrue(actual_Title.contains("Search"));
	}
	
	@Test(priority = 2)
	public void sort_Test()
	{
		List<WebElement> price = search_Page.sortBy();
        double value_1 = Integer.valueOf(price.get(0).getText().substring(1,2));
        double value_2 = Integer.valueOf(price.get(1).getText().substring(1,2));
        
        System.out.println(value_1);
        System.out.println(value_2);
        Assert.assertTrue(value_1>value_2);

	}	
	
	@DataProvider
	public String[][] productName()
	{
		 String value[][]= {
			 {"Mac", "iMac"}, {"samsung","Samsung SyncMaster 941BW"}
		 };
		return value;
	}
	
	@Test (dataProvider = "productName" , priority = 3)
	public void productSelection(String key, String Product)
	{
		search_Page =account_Page.searchBox(key);
		product_info =search_Page.product_Click(Product);
		
//		List<WebElement>items = search_Page.productList();
//	     for(WebElement e : items)
//	     {
//	    	String actualValue=  e.getText();
//	    	Assert.assertEquals(actualValue,Product);
//	    	product_info =search_Page.product_Click(Product);
//	     }
//		
				
	}
    
}
