package pageObjects;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reusableComponents.CommonFunctions;
import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class HomePage extends TestBase {

	private static int intflag = 0;

	By location_txtbox = By.xpath("//*[@id='bigsearch-query-detached-query']");
	By checkin_elm = By.xpath("//*[contains(text(),'Check in')]");
	By dateelm = By.xpath("//*[contains(text()," + "'October 2020')]");
	By nextBtn = By.xpath("//button[contains(@aria-label,'Next')]");
	By checkout_elm = By.xpath("//*[contains(text(),'Check out')]");
	By guest_elm = By.xpath("//div[contains(text(),'Guest')]");
	By addGuests = By.className("_7hhhl3");
	By searchIcon = By.className("_1mzhry13");

	public void nextBtnClick() {
		int attempts = 0;
		while (attempts < 2) {
			try {
				DriverFactory.getInstance().getDriver().findElement(nextBtn).click();
				break;
			} catch (Exception e) {
			}
			attempts++;
		}
	}

	public void clickSearch() {
		DriverFactory.getInstance().getDriver().findElement(searchIcon).click();
	}

	public void clickLocation() {
		MyLogger.info("Clicking on Location Textbox");
		DriverFactory.getInstance().getDriver().findElement(location_txtbox).click();
	}

	public void setLocation(String strLocation) {

		DriverFactory.getInstance().getDriver().findElement(location_txtbox).sendKeys(strLocation);

	}

	public void clickGuestelm() {
		DriverFactory.getInstance().getDriver().findElement(guest_elm).click();
	}

	public void addGuests(String strGuest, int intGuest) {
		List<WebElement> addIcon = DriverFactory.getInstance().getDriver().findElements(addGuests);
		for (int intCount = 0; intCount <= addIcon.size() - 1; intCount++) {
			if (addIcon.get(intCount).getAttribute("data-testid").contains(strGuest)) {
				for (int i = 1; i <= intGuest; i++) {
					addIcon.get(intCount).click();
				}
			}
		}
	}

	public void clickCheckin() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(checkin_elm).click();
	}

	public void clickCheckout() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(checkout_elm).click();
	}

	public void clickNextButton() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(nextBtn).click();
		DriverFactory.getInstance().getDriver().findElement(nextBtn).click();
	}

	public void selectFromDate(String sDate) throws InterruptedException, ParseException {

		String strFromDate = CommonFunctions.convertDate(sDate);

		List<WebElement> dateTbl = DriverFactory.getInstance().getDriver().findElements(By.className("_1258d0t"));

		for (int intCount = 0; intCount <= dateTbl.size() - 32; intCount++) {
			if (dateTbl.get(intCount).getAttribute("data-testid").contains(strFromDate)) {
				dateTbl.get(intCount).click();
				intflag = 1;
				break;
			}
		}
		if (intflag == 0) {
			nextBtnClick();
			Thread.sleep(2000);
			selectFromDate(strFromDate);
		}
		intflag = 0;
	}

	public void selecttoDate(String sDate) throws InterruptedException, ParseException {
		String strToDate = CommonFunctions.convertDate(sDate);
		List<WebElement> dateTbl = DriverFactory.getInstance().getDriver().findElements(By.className("_1258d0t"));
		for (int i = 0; i <= dateTbl.size() - 32; i++) {
			if (dateTbl.get(i).getAttribute("data-testid").contains(strToDate)) {
				dateTbl.get(i).click();
				intflag = 1;
				break;
			}
		}
		if (intflag == 0) {
			nextBtnClick();
			Thread.sleep(2000);
			selecttoDate(strToDate);
		}
		intflag = 0;
	}
}
