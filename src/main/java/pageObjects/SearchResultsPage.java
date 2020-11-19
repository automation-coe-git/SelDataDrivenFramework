package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.DriverFactory;
import testBase.TestBase;

public class SearchResultsPage extends TestBase{
	
	By messageElm					=By.xpath("//*[contains(text(),'Stays in')]");
	By resultsLinks 				=By.className("_1048zci");
	
	public String getMessage()
	{
		WebElement msgelm=DriverFactory.getInstance().getDriver().findElement(messageElm);
		return msgelm.findElement(messageElm).getText();
	}
	
	public void clickLink()
	{
		List<WebElement> relinks = DriverFactory.getInstance().getDriver().findElements(resultsLinks);
		try {
		relinks.get(0).click();
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
