package com.qa.FreeCRM.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FreeCRM.base.BasePage;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	//By Locators
	
	//By LoginBtn= By.xpath("//span[text()='Log In']");
	By username=By.xpath("//input[@name='email']");
	By password=By.xpath("//input[@name='password']");
	By lgBtn=By.xpath("//div[text()='Login']");
	
	
	//Page Actions
	@Step("Getting login page title.....")
	public String getLoginPageTitle() {
		return getDriver().getTitle();
	}
	
	/*
	 * public void loginBtnClick() { driver.findElement(LoginBtn).click(); }
	 */
	
	@Step("user login with username : {0}, password :{1}")
	public HomePage doLogin(String un, String pwd) {
		getDriver().findElement(username).sendKeys(un);
		getDriver().findElement(password).sendKeys(pwd);
		getDriver().findElement(lgBtn).click();
		return new HomePage(driver);
	}
}
