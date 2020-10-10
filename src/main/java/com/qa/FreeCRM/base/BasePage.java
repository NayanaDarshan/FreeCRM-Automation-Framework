package com.qa.FreeCRM.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static String browserName;
	public WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver>tldriver = new ThreadLocal<WebDriver>();

	
	public WebDriver init_driver(Properties prop) {
     browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			tldriver.set(new ChromeDriver());
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
			
		}
	
		else if(browserName.equalsIgnoreCase("safari")) {
			//driver=new SafariDriver();
			
			tldriver.set(new SafariDriver());
			
		}
		
		else
		{
			System.out.println("Please enter the correct browser name" +browserName);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("appURL"));
	return getDriver();
	}
	
	
	/*
	 * This method is use to get the driver
	 */
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	/*
	 * This method is used to get the properties from Property file
	 */
	
	public Properties init_prop()  {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/FreeCRM/Config/Config.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return prop;
		
	}
		
	
	// This is a method to Take screenshot
	 
	
	public String getScreenshot() {
		
	         File frsc =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	         String path= System.getProperty("user.dir")+"/Screenshots"+System.currentTimeMillis()+".png";
	         File destination = new File(path);
	         try {
				FileUtils.copyFile(frsc, destination);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	         
	         return path;
	}

}
