package Tests;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import reusableComponents.ExcelUtils;
import reusableComponents.JSONutils;
import reusableComponents.ReadConfig;
import testBase.MyLogger;
import testBase.TestBase;




public class AirbnbTests extends TestBase {
	
	HomePage homePage = new HomePage();
	SearchResultsPage searchResultPage=new SearchResultsPage();
	
	@Test(enabled=true)
	public void test1() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		ReadConfig readConfig=new ReadConfig("C:\\ReactJS Framework\\ReactJS\\Configuration\\config.properties");
		String exlpath= readConfig.getValue("excelPath");
		String shName= readConfig.getValue("sheetName");
		ExcelUtils exObj=new ExcelUtils(exlpath,shName);
		
		homePage.clickLocation();
		homePage.setLocation(exObj.getDataBasedOnTCandAttribute("Location", "TC-1"));
		homePage.clickCheckin();
		homePage.selectFromDate(exObj.getDataBasedOnTCandAttribute("FromDate", "TC-1"));
		homePage.selecttoDate(exObj.getDataBasedOnTCandAttribute( "ToDate", "TC-1"));
		homePage.clickGuestelm();
		homePage.addGuests("adults",Integer.parseInt(exObj.getDataBasedOnTCandAttribute("Adults", "TC-1")));
		homePage.addGuests("children", Integer.parseInt(exObj.getDataBasedOnTCandAttribute("Children", "TC-1")));
		homePage.clickSearch();
		Assert.assertEquals(searchResultPage.getMessage(), "Stays in Bengaluru");
		searchResultPage.clickLink();

	}
	
	@Test(enabled=true)
	public void test2() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		ReadConfig readConfig=new ReadConfig("C:\\ReactJS Framework\\ReactJS\\Configuration\\config.properties");
		String exlpath= readConfig.getValue("excelPath");
		String shName= readConfig.getValue("sheetName");
		ExcelUtils exObj=new ExcelUtils(exlpath,shName);
		
		homePage.clickLocation();
		homePage.setLocation(exObj.getDataBasedOnTCandAttribute("Location", "TC-1"));
		homePage.clickCheckin();
		homePage.selectFromDate(exObj.getDataBasedOnTCandAttribute("FromDate", "TC-1"));
		homePage.selecttoDate(exObj.getDataBasedOnTCandAttribute( "ToDate", "TC-1"));
		homePage.clickGuestelm();
		homePage.addGuests("adults",Integer.parseInt(exObj.getDataBasedOnTCandAttribute("Adults", "TC-1")));
		homePage.addGuests("children", Integer.parseInt(exObj.getDataBasedOnTCandAttribute("Children", "TC-1")));
		homePage.clickSearch();
		Assert.assertEquals(searchResultPage.getMessage(), "Stay in Bengaluru");
		searchResultPage.clickLink();

	}
	
}
