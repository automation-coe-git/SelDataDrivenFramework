package testBase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	BrowserFactory bf = new BrowserFactory();

	@Parameters("browser")
	@BeforeMethod
	public void LaunchApplication(String browser) throws Exception {
		reusableComponents.ReadConfig readconfig = new reusableComponents.ReadConfig("./Configuration/config.properties");
		String baseURL = readconfig.getValue("baseURL");
		
		
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(baseURL);

	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

	
}
