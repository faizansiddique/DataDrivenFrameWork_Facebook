package dd_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dd_util.TestConfig;
import dd_util.TestUtil;
import dd_util.Xls_Reader;
import dd_util.monitoringMail;

public class Main {
	
	
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeSuite
	public static void init() throws IOException{
		
		if(driver==null){
			
			//loading config property file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\config.properties");
			config.load(fis);
			logs.debug("Config file loaded");
			
			//loading object property file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\object.properties");
			object.load(fis);
			logs.debug("Object file loaded");
			
			excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\TestData.xlsx");
			logs.debug("Excel path loaded");
			//excel = new Xls_Reader("D:\\ecclipse\\practise\\dataDrivenFramework\\src\\dd_properties\\TestData.xlsx");
			
			//initializing the browser to launch
			if(config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "D:\\ecclipse\\practise\\dataDrivenFramework\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				logs.debug("loaded Chrome");
			}
				else if(config.getProperty("browser").equals("ie")){
					
					System.setProperty("webdriver.ie.driver", "D:\\ecclipse\\practise\\dataDrivenFramework\\Drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					logs.debug("loaded IE");
				}
				else if(config.getProperty("browser").equals("firefox")){
					
					driver = new FirefoxDriver();	
					logs.debug("loaded Firefox");
				}
			}
		
		//intializing the implicit wait
		
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logs.info("Window get maximized successfully");
		
		//initialize URL
		driver.get(config.getProperty("url"));
		TestUtil.CaptureScreenshot();
		logs.info("Browser has been launched");
		driver.navigate().refresh();
		
	}
		@AfterSuite
		public static void QuitBrowser() throws Exception, MessagingException{
			
			WebElement clickNavigation = driver.findElement(By.xpath(object.getProperty("navigation")));
			if(clickNavigation.isDisplayed()){
			clickNavigation.click();
			logs.info("Click on Navigation successfully");
			}else{
				logs.info("Unsuccessful to click on Navigation");
				TestUtil.CaptureScreenshot();
			}
			
			WebElement logout = driver.findElement(By.xpath(object.getProperty("logout")));
			if(logout.isDisplayed()){
			logout.click();
			logs.info("Click on logout successfully");
			}else{
				logs.info("Unsuccessful to click on logout");
				TestUtil.CaptureScreenshot();	
			}
			
			driver.close();
			driver.quit();
			
			//monitoringMail mail = new monitoringMail();
			//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
			
			
		
		}
	}



