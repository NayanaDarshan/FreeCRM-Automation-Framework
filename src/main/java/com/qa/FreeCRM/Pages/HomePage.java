package com.qa.FreeCRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FreeCRM.base.BasePage;

import io.qameta.allure.Step;

public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//By Locators
	
	By userProfile= By.xpath("//span[text()='Nayan Raghu']");
	By contactsLink= By.xpath("//span[text()='Contacts']");

	//Page Actions
	@Step("This is the step to get the logged in user profile name")
	public String getUserProfileName() {
		return getDriver().findElement(userProfile).getText();
	}
	
	public ContactsPage goContactsLink() {
		getDriver().findElement(contactsLink).click();
		return new ContactsPage(driver);
	}
}
