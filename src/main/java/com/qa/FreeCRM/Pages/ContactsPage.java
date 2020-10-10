package com.qa.FreeCRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.FreeCRM.base.BasePage;

public class ContactsPage extends BasePage{
	
	private WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//By Locators
	
	By contatsHeaderName= By.xpath("//div[text()='Contacts']");
	By contactsCreate= By.xpath("//button[text()='New']");
	By newCreatecontactheader=By.xpath("//div[text()='Create New Contact']");
	By firstName=By.name("first_name");
	By lastName=By.name("last_name");
	By address=By.xpath("//input[@placeholder='Street Address']");
	By emailAddress=By.xpath("//input[@placeholder='Email address']");
	By saveBtn=By.xpath("//button[text()='Save']");
	By contactsLink=By.xpath("//span[text()='Contacts']");
	
	public String getContactsPageHeader() {
		return getDriver().findElement(contatsHeaderName).getText();
	}
	
	public void doClickCreateContact() {
		getDriver().findElement(contactsCreate).click();
	}
	

	public void createContact(String FN, String LN, String ADDR, String EADDR) {
		doClickCreateContact();
	
		getDriver().findElement(firstName).sendKeys(FN);
		getDriver().findElement(lastName).sendKeys(LN);
		getDriver().findElement(emailAddress).sendKeys(EADDR);
		getDriver().findElement(address).sendKeys(ADDR);
		getDriver().findElement(saveBtn).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
		

	}
	
	public void doContactLinkClick() {
		getDriver().findElement(contactsLink).click();
	  
	}
	

}
