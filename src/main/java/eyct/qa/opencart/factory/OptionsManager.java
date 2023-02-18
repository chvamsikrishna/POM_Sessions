package eyct.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;


public class OptionsManager {

        private Properties prop;  
        private ChromeOptions co;
        
        public OptionsManager(Properties prop)
        {
        	this.prop =prop;
        }
        
  
        public ChromeOptions chrome_Options()
        {
            co = new ChromeOptions();
        	if(Boolean.parseBoolean(prop.getProperty("headless")))
        	{
        		System.out.println("Running in headless");
        		co.setHeadless(true);
        	}
        	if(Boolean.parseBoolean(prop.getProperty("incognito")))
        	{
        	   System.out.println("Running in incognito");
        	   co.addArguments("--incognito");
        	}
        	return co;
        }
}
