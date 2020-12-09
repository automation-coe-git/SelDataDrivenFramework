package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
		RemoteWebDriver driver = null;
		reusableComponents.ReadConfig readconfig = new reusableComponents.ReadConfig("./Configuration/config.properties");
		//String remoteURL = readconfig.getValue("remoteURL");
	
		String remoteURL= "http://"+ "zalenium"+":"+"Zalenium2020"+"@"+"35.224.146.128"+"/wd/hub";
		DesiredCapabilities desiredCapablities=new DesiredCapabilities();
		desiredCapablities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		desiredCapablities.setCapability("idleTimeout", 180);
		desiredCapablities.setCapability("recordvideo", true);
		desiredCapablities.setCapability("tz", "Asia/Kolkata");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			desiredCapablities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			driver = new RemoteWebDriver(new URL(remoteURL), desiredCapablities);
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			desiredCapablities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL(remoteURL), desiredCapablities);
			
		} if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}
}