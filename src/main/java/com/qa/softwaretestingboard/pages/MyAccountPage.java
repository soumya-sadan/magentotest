package com.qa.softwaretestingboard.pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.constants.AppConstants;

public class MyAccountPage {
	
	WebDriver driver;
	
	private By userInfo = By.xpath("(//span[@class='logged-in'])[1]");
	private By userOptionsExpandButton = By.xpath("//div[@class='panel header']//button[@type='button']");
	private By logoutButton = By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']");
	private By createAccountLink = By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");

	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public @Nullable String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public String verifyUserDetails()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//	WebElement fName = driver.findElement(firstName);
			wait.until(ExpectedConditions.visibilityOf( driver.findElement(userInfo)));
		String userFullname = driver.findElement(userInfo).getText();
		System.out.println("User First Name and Lastname is :" + userFullname);
		return userFullname;
	}
	
	public void doLogout()
	  {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//	WebElement fName = driver.findElement(firstName);
			wait.until(ExpectedConditions.visibilityOf( driver.findElement(userOptionsExpandButton))).click();
			wait.until(ExpectedConditions.visibilityOf( driver.findElement(logoutButton))).click();
			
	  }
	
	public void navigateToRegisterPage() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//	WebElement fName = driver.findElement(firstName);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(createAccountLink))).click();
	   
	}

}
