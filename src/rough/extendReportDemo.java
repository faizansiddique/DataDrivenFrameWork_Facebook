package rough;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extendReportDemo {
	
	static WebDriver driver;
	
	public String GetScreenShot(WebDriver driver, String screenShotName) throws Exception{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("D:\\ecclipse\\practise\\dataDrivenFramework\\screenshots")+"\\screenshot\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
		
	}

	public static void main(String[] args) throws Exception  {
	
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\ecclipse\\practise\\dataDrivenFramework\\ReportsGeneratedReport.html");
		ExtentReports extent = new ExtentReports();
		ExtentTest test;
		

	extent.attachReporter(reporter);
	test = extent.createTest("captureScreenShot");
	
	extendReportDemo demo = new extendReportDemo();
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://www.google.com/");
	String title = driver.getTitle();
	Assert.assertEquals("Googl", title);
	
	String screenShotPath = demo.GetScreenShot(driver, "screenShotName");
	test.fail("SnapShot below:"+test.addScreenCaptureFromPath(screenShotPath));
	
	
	
	
	
	
	
	
		
	}

}
