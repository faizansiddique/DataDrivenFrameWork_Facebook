package dd_util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import dd_java.Main;

public class TestUtil extends Main{
	
	public static String screenShotPath;
	
public static boolean isExecutable(String TestCase){
		
		for(int rownum=2;rownum<=excel.getRowCount("TestSuite");rownum++){
			if(excel.getCellData("TestSuite", "TestCase", rownum).equals(TestCase)){
				if(excel.getCellData("TestSuite", "runmode", rownum).equals("Y")){
				
					return true;
				}
				else{
					return false;
				}
				}
			
		}
		return false;
	}

public static Object[][] getData(String sheetName){
	
	int rows = excel.getRowCount(sheetName);
	System.out.println(rows);
	int cols= excel.getColumnCount(sheetName);
	System.out.println(cols);
	
	Object[][] data = new Object[rows-1][cols];
	
	for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
		for(int colNum=0 ; colNum< cols; colNum++){
			data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
		}
	}
	
	return data;
}

public static void CaptureScreenshot() throws IOException{
	
	  Calendar cal = new GregorianCalendar();
	  int month = cal.get(Calendar.MONTH); //3
	  int year = cal.get(Calendar.YEAR); //2014
	  int sec =cal.get(Calendar.SECOND);
	  int min =cal.get(Calendar.MINUTE);
	  int date = cal.get(Calendar.DATE);
	  int day =cal.get(Calendar.HOUR_OF_DAY);
	
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try{
	  screenShotPath = System.getProperty("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
	  FileUtils.copyFile(scrFile, new File(screenShotPath));
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}

	public WebElement getWhenVisible(By locator, int timeout) {
	WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return element;
}
	
	public WebElement waitForWebElement(By locator, double maxWaitTime) {
		Boolean isElementFound = false;
		StopWatch sw = new StopWatch();
		sw.start();
		while (sw.getTime() < maxWaitTime) {
			try {
				if (driver.findElements(locator).size() > 0) {
					isElementFound = true;
					break;
				}
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!isElementFound) {
			throw new ElementNotFoundException(locator.toString(),
					locator.toString(), locator.toString());
		}
		return driver.findElement(locator);
	}
}
