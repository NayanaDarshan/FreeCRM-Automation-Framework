package com.qa.FreeCRM.PageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Constants.FreeCRMConstants;
import com.qa.FreeCRM.Listeners.TestAllureListener;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.base.BasePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestAllureListener.class)
@Epic("Epic number-100- Login Page Module for FreeCRM Application")
@Story("US-101-Design all features of login page - login module, verigy page title")

public class LoginPageTest {

	private WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;

	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
	}

	
	@Description("This is a method to verify login page title.....")
	@Severity(SeverityLevel.NORMAL)
	
	@Test
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("The Title is===>" + title);
		System.out.println("Testing the ngrok setup");
		Assert.assertEquals(title, FreeCRMConstants.LOGIN_TITLE_NAME, "The Login page title is same");
		//Assert.assertEquals(title, "NayanaMR", "The Login page title is same");
	}
	

	/*
	 * @Test public void verifyLoginBtnclickText() { loginpage.loginBtnClick(); }
	 */
	@Description("This is a method to verify FREE CRM Application login......")
	@Severity(SeverityLevel.BLOCKER)
	
	@Test
	public void verifyLoginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	  @AfterTest public void teardown() { 
		  basepage.getDriver().quit();
	  
	  }
	 
	 

}
