package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports extent;
	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		reusableComponents.ReadConfig readconfig = new reusableComponents.ReadConfig("./Configuration/config.properties");
		String baseURL = readconfig.getValue("baseURL");
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		String browser = readconfig.getValue("browser"); 
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
	    extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("Test Automation Report");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Test Report");
		
		extent.setSystemInfo("Executed on Environment: ",baseURL);
		extent.setSystemInfo("Executed on Browser: ",browser);
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

		return extent;
	}


}
