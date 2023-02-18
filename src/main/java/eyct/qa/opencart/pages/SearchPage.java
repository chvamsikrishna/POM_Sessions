package eyct.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ey.qa.opencart.Utils.ElementUtils;
import ey.qa.opencart.Utils.TimeUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtils element_Util;
	
	private By productSearchList = By.xpath("//div[@class='caption']//a");
	private By sortList =By.xpath("//select[@id='input-sort']");
	private By price = By.xpath("//span[@class='price-tax']//parent::p[@class='price']");

	public SearchPage(WebDriver driver)
	{
		this.driver= driver;
		element_Util = new ElementUtils(driver);
		
	}
	

	public String searchPageTitle()
	{
		return driver.getTitle();
	}
	
	public List<WebElement> sortBy()
	{
		
		
		element_Util.doSelectDropDownByIndex(sortList, 5);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		return element_Util.waitForElementsVisible(price,TimeUtil.DEFAULT_TIME_OUT);
		
	}
	
	public List<WebElement> productList()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		return element_Util.waitForElementsVisible(productSearchList, TimeUtil.DEFAULT_TIME_OUT);
		
	}
	
	public Productinfo product_Click(String productName)
	{
		List<WebElement> value =  element_Util.waitForElementsVisible(productSearchList, TimeUtil.DEFAULT_TIME_OUT);
		
		for(WebElement e : value)
		{
			
			try {
			if(e.getText().equals(productName))
			{
				
				e.click();
			
			}
			
			}
			catch(StaleElementReferenceException e1)
			{
				e1.printStackTrace();

			}
		
		
		}
		
		return new Productinfo(driver);
	}
}


