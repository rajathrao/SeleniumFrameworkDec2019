package com.ebay.dataDrivenFramework.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	public WebDriver driver;
	
	@BeforeTest
	public void initializeThis() throws IOException {
		
		Properties prop = new Properties();
		String projectLocation = System.getProperty("user.dir");
		
		// gives the entire path
	 String configPath = projectLocation +"/Resources/data.properties";
		
		//System.out.println(configPath);
	 
	 // here we have the location of the property file 
		FileInputStream fis = new FileInputStream(configPath);
	    // heere we are loading the file
		prop.load(fis);
		
		
		String browserName= prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		int implcitwaitTime = Integer.parseInt(prop.getProperty("implicitWait"));
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rajat\\OneDrive\\Desktop\\Flexon Automation\\jar files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(urlName);
			driver.manage().timeouts().implicitlyWait(implcitwaitTime, TimeUnit.SECONDS);
		
		}
		
	}
	
  @AfterTest
  public void endThis() { 
	//  driver.quit();
  }
}
