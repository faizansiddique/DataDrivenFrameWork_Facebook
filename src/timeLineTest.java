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

public class timeLineTest extends Main {

	// is Executable
	@BeforeTest
	public void isSkip() {

		if (!TestUtil.isExecutable("timeLineTest")) {

			throw new SkipException("Skipping the test case as the run mode is set to NO");
		}

	}
	
	@Test
	public void gotoTimeLine() throws Exception{
		
		WebElement timeLineClick = driver.findElement(By.xpath(object.getProperty("timeLineClick")));
		if(timeLineClick.isDisplayed()){
		timeLineClick.click();
			logs.debug("TimeLine link is present");
		}else{
			logs.debug("TimeLine Link is not present");	
			TestUtil.CaptureScreenshot();
		}
		
		WebElement listView = driver.findElement(By.xpath(object.getProperty("listView")));
		if(listView.isDisplayed()){
			logs.debug("List View is displayed");
		}else{
			logs.debug("List View is not present");
			TestUtil.CaptureScreenshot();
		}
		
		WebElement gridView = driver.findElement(By.xpath(object.getProperty("gridView")));
		if(gridView.isDisplayed()){
			logs.debug("Grid View is displayed");
		}else{
			logs.debug("Grid View is not displayed");
			TestUtil.CaptureScreenshot();
		}
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("timeLineTest");
	}
}
