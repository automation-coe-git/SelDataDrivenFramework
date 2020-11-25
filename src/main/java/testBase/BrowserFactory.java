package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
		RemoteWebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities desiredCapablities=new DesiredCapabilities();
			WebDriverManager.chromedriver().browserVersion("85.0").setup();
			//driver=new ChromeDriver();
			desiredCapablities.setBrowserName(BrowserType.CHROME);
			//desiredCapablities.setVersion("85.0");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapablities);
		}else if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities desiredCapablities=new DesiredCapabilities();
			WebDriverManager.firefoxdriver().browserVersion("81.0").setup();
			//driver= new FirefoxDriver();
			desiredCapablities.setBrowserName(BrowserType.FIREFOX);
			//desiredCapablities.setVersion("81.0");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapablities);
			
		} if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}
}