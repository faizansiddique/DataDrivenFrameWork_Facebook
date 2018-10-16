package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_java.Main;
import dd_util.TestUtil;

public class aboutTest extends Main{
	
	// is Executable
	@BeforeTest
	public void isSkip() {

		if (!TestUtil.isExecutable("aboutTest")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");
		}

	}
	
	@Test
	public void gotoAbout() throws Exception{
		
		WebElement aboutClick = driver.findElement(By.xpath(object.getProperty("about")));
		if(aboutClick.isDisplayed()){
			aboutClick.click();
			logs.debug("Click on About successfully");
		}else{
			logs.debug("failed to click on About");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement aboutLink = driver.findElement(By.xpath(object.getProperty("aboutLink")));
		if(aboutLink.isDisplayed()){
			logs.debug("About Link is visible");
		}else{
			logs.debug("About Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement overviewLink = driver.findElement(By.xpath(object.getProperty("Overview")));
		if(overviewLink.isDisplayed()){
			overviewLink.click();
			logs.debug("Overview Link is visible");
		}else{
			logs.debug("Overview Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement mobileNo = driver.findElement(By.xpath(object.getProperty("mobileNumber")));
		String mobNumber = mobileNo.getText();
		System.out.println(mobNumber);
		
		if(mobNumber.contains("080972 17409")){
			logs.debug("Mobile Number is visible");
		}else{
			logs.debug("Mobile Number is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement workandEducationLink = driver.findElement(By.xpath(object.getProperty("workandEducation")));
		if(overviewLink.isDisplayed()){
			workandEducationLink.click();
			logs.debug("Work and Education Link is visible");
		}else{
			logs.debug("Work and Education Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement placeyoulivedLink = driver.findElement(By.xpath(object.getProperty("placeyoulived")));
		if(placeyoulivedLink.isDisplayed()){
			placeyoulivedLink.click();
			logs.debug("Place you Lived Link is visible");
		}else{
			logs.debug("Place you Lived Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement contactandbasicinfoLink = driver.findElement(By.xpath(object.getProperty("contactandbasicinfo")));
		if(contactandbasicinfoLink.isDisplayed()){
			contactandbasicinfoLink.click();
			logs.debug("Contact and basic info Link is visible");
		}else{
			logs.debug("Contact and basic info Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement familyandrealtionshipsLink = driver.findElement(By.xpath(object.getProperty("familyandrealtionships")));
		if(familyandrealtionshipsLink.isDisplayed()){
			familyandrealtionshipsLink.click();
			logs.debug("Family and Relationships Link is visible");
		}else{
			logs.debug("Family and Relationships Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement detailsaboutyouLink = driver.findElement(By.xpath(object.getProperty("detailsaboutyou")));
		if(detailsaboutyouLink.isDisplayed()){
			detailsaboutyouLink.click();
			logs.debug("Details about you Link is visible");
		}else{
			logs.debug("Details about you Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement lifeEventsLink = driver.findElement(By.xpath(object.getProperty("lifeEvents")));
		if(lifeEventsLink.isDisplayed()){
			lifeEventsLink.click();
			logs.debug("Life Events Link is visible");
		}else{
			logs.debug("Life Events Link is not visible");
			TestUtil.CaptureScreenshot();
		}
		
		
		
	}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("aboutTest");
		}

		
		
	}



