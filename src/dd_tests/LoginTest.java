package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dd_java.Main;
import dd_util.TestUtil;

public class LoginTest extends Main {
	
	//is Executable
	@BeforeTest
	public void isSkip(){
		
		if(! TestUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the test case as the run mode is set to NO");
		}

	}
	
	@Test(dataProvider = "getData")
	public void doLogin(String Username, String Password) throws IOException{
		
		String title = driver.getTitle();
		Assert.assertEquals("Facebook – log in or sign up", title );
		/*logger =extent.createTest("LoginTest");
		logger.pass("Status.PASS");
		logger.addScreenCaptureFromPath(TestUtil.screenShotPath);*/
		//TestUtil.CaptureScreenshot();
		
		driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(Username);
		logs.debug("Username given successfully");
		//logger.log(Status.PASS, "Username given successfully");
		
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(Password);
		logs.debug("password added successfully");
		//logger.log(Status.PASS, "password added successfully");
		
		driver.findElement(By.xpath(object.getProperty("login"))).click();
		logs.debug("Click on login button successfully");
		//logger.log(Status.PASS, "Click on login button successfully");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("LoginTest");
	}
	
	
	

}
