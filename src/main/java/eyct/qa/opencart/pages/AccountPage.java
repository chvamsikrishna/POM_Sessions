package eyct.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	private By logoutIcon = By.xpath("(//a[text()='Logout'])[2]");
	private By headers = By.cssSelector("#content h2");
	private By searchBox = 	By.xpath("//input[@name='search']");
	private By searhButton = By.cssSelector("div#search button");
	
	
    // LogOut visibility, Left Headers, Search Box presence.
	
	public boolean logoutVisibility()
	{
		return driver.findElement(logoutIcon).isDisplayed();
	}
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> leftHeaders()
	{
		List <WebElement> header = driver.findElements(headers);
		List<String> h2_Values = new ArrayList<String>();
		
		for(WebElement e: header) 
		
		{
			String headerValue = e.getText();
			h2_Values.add(headerValue);		
		}
		return h2_Values;
		
	}
	
	
	
	public SearchPage searchBox(String item)
	{
		try 
		{
		if(driver.findElement(searchBox).isDisplayed())
		{
			driver.findElement(searchBox).clear();
			driver.findElement(searchBox).sendKeys(item);
			driver.findElement(searhButton).click();
		
		}
		return new SearchPage(driver);
		}
		
		catch(Exception e)
		{
			System.out.println("No element found");
		}
		return null;
		
	}
	
	

}
