package com.qa.FreeCRM.PageTest;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Constants.FreeCRMConstants;
import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.base.BasePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic Number-102-This includes the Home Page Testing module")
@Story("US-102- Home Page module - verifying the Home Page behaviour")

public class HomePageTest {
	

	private WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;

	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		
	}
	
	  @BeforeClass 
	  public void homePageSetup() { 
	  homepage =
	  loginpage.doLogin(prop.getProperty("username"),
	  prop.getProperty("password")); 
	  
	  }
	 
	@Description("This is the method to verify logged in user User Profile Name")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void verifyUserProfileTest() {
		String userName=homepage.getUserProfileName();
		System.out.println("The Logged in user name===>"+userName);
		Assert.assertEquals(userName, FreeCRMConstants.USER_PROFILE_NAME);
	}
	
	@AfterTest
	public void teardown() {
		basepage.getDriver().quit();
	}

}
