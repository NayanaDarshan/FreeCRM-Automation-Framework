package com.qa.FreeCRM.PageTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCRM.Constants.FreeCRMConstants;
import com.qa.FreeCRM.Pages.ContactsPage;
import com.qa.FreeCRM.Pages.HomePage;
import com.qa.FreeCRM.Pages.LoginPage;
import com.qa.FreeCRM.Utilis.ExcelUtil;
import com.qa.FreeCRM.base.BasePage;

public class ContactsPageTest extends BasePage {

	private WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;

	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);

	}

	@BeforeClass

	public void ContactsPageSetup() {
		homepage =
				  loginpage.doLogin(prop.getProperty("username"),
				  prop.getProperty("password")); 
		contactspage = homepage.goContactsLink();

	}
	
	@Test
	public void verifyContactsPageHeaderTest() {
		String headername =contactspage.getContactsPageHeader();
		Assert.assertEquals(headername, FreeCRMConstants.CONTACTS_HEADER_NAME);
	}
	
	@DataProvider()
	public Object[][] getContactsTestData() {
		Object data[][]=ExcelUtil.getTestdata(FreeCRMConstants.CONTACTS_SHEETNAME);
		return data;
	}
	

	@Test(dataProvider="getContactsTestData")
	public void verifyCreateContactTest(String firstname, String lastname, String address, String emailaddress) {
		contactspage.createContact(firstname, lastname, address, emailaddress);
		
		//contactspage.createContact("Nayana","Raghu", "K.L 806 3rd Cross, Mandya", "nayana.28mr@gmail.com");
		getDriver().navigate().to(prop.getProperty("contactURL"));
	}
		
	@AfterTest
	public void teardown() {
		getDriver().quit();
	}
}
