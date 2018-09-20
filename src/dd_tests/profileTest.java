package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dd_java.Main;
import dd_util.TestUtil;

public class profileTest extends Main {
	
	//is Executable
		@BeforeTest
		public void isSkip(){
			
			if(! TestUtil.isExecutable("profileTest")){
				
				throw new SkipException("Skipping the test case as the run mode is set to NO");
			}

		}
		
		@Test
		public void gotoProfile() throws IOException{
		
			WebElement profile = driver.findElement(By.xpath(object.getProperty("profile")));
			if(profile.isDisplayed()){
				profile.click();
				logs.debug("Click on profile successfully");
				//logger.log(Status.PASS, "Click on profile successfully");
			}else{
				logs.debug("Click on profile is not done successfully");
				/*logger.log(Status.FAIL, "Click on profile is not done successfully");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement Timeline = driver.findElement(By.xpath(object.getProperty("timeline")));
			if(Timeline.isDisplayed()){
				logs.debug("Timeline displayed successfully");
				//logger.log(Status.PASS, "Timeline displayed successfully");
			}else{
				logs.debug("Timeline is not displayed");
				/*logger.log(Status.FAIL, "Timeline is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement About = driver.findElement(By.xpath(object.getProperty("about")));
			if(About.isDisplayed()){
				logs.debug("About displayed successfully");
				//logger.log(Status.PASS, "About displayed successfully");
			}else{
				logs.debug("About is not displayed");
				/*logger.log(Status.FAIL, "About is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement Friends = driver.findElement(By.xpath(object.getProperty("friends")));
			if(Friends.isDisplayed()){
				logs.debug("Friends displayed successfully");
				//logger.log(Status.PASS, "Friends displayed successfully");
			}else{
				logs.debug("Friends is not displayed");
				/*logger.log(Status.FAIL, "Friends is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement Photos = driver.findElement(By.xpath(object.getProperty("photos")));
			if(Photos.isDisplayed()){
				logs.debug("Photos displayed successfully");
				//logger.log(Status.PASS, "Photos displayed successfully");
			}else{
				logs.debug("Photos is not displayed");
				/*logger.log(Status.FAIL, "Friends is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement Archive = driver.findElement(By.xpath(object.getProperty("archive")));
			if(Archive.isDisplayed()){
				logs.debug("Archive displayed successfully");
				//logger.log(Status.PASS, "Archive displayed successfully");
			}else{
				logs.debug("Archive is not displayed");
				/*logger.log(Status.FAIL, "Archive is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement More = driver.findElement(By.xpath(object.getProperty("more")));
			if(More.isDisplayed()){
				logs.debug("More displayed successfully");
				//logger.log(Status.PASS, "More displayed successfully");
			}else{
				logs.debug("More is not displayed");
				/*logger.log(Status.FAIL, "More is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
			
			WebElement Intro = driver.findElement(By.xpath(object.getProperty("intro")));
			if(Intro.isDisplayed()){
				logs.debug("Intro displayed successfully");
				//logger.log(Status.PASS, "Intro displayed successfully");
			}else{
				logs.debug("Intro is not displayed");
				/*logger.log(Status.FAIL, "Intro is not displayed");
				logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
				//TestUtil.CaptureScreenshot();
			}
		}
			
			
		
		
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("profileTest");

}
		}
		
