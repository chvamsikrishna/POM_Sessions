package eyct.qa.opencart.factory;


import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;



public class DriverFactory {
	
	
	public static String high;
	public WebDriver driver;
	public Properties prop;
	public OptionsManager op;
	
	static ThreadLocal<WebDriver> tLocal = new ThreadLocal<WebDriver>();

	
	@BeforeTest
	public WebDriver init(Properties prop)
	{
		String driverValue = prop.getProperty("browser").trim();
		
		high = prop.getProperty("highlight");
		
		op = new OptionsManager(prop);
		
		if(driverValue.equalsIgnoreCase("chrome"))
		{
			//driver = new ChromeDriver(op.chrome_Options());	
			tLocal.set(new ChromeDriver(op.chrome_Options()));
		}
		else if(driverValue.equalsIgnoreCase("firefox"))
		{
			//driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please enter the correct driver");
		}
		
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	public synchronized static WebDriver getDriver()
	{
		
	return tLocal.get();
	}
	
	public Properties prop_Init()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/java/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public static  String getScreenShot()
	{
		
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String des_Path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(des_Path);
		
		try {
			FileHandler.copy(sourceFile, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return des_Path;
		
	}
}
