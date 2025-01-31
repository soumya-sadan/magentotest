package com.qa.softwaretestingboard.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.softwaretestingboard.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	ElementUtil eleUtil;
	
	//private By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
	private By signInLink = By.xpath("//a[contains(text(),'Sign In')]");
	//private By createAccountButton = By.xpath("(//div[@class='primary'])[3]/a");
	private By createAccountButton = By.xpath("//a[@class='action create primary']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;  // Initialize the driver using constructor
	}
	
	/**
	 * Click Sign in on the landing page
	 * @return
	 */
	
	public String goToLoginPageAndGetTitle()
	{
		
		System.out.println("INSIDE goToLoginPageAndGetTitle()");
	driver.get("https://magento.softwaretestingboard.com/");
	System.out.println("I am on landing page");
	
	try {
		Thread.sleep(2000);
		WebElement link = driver.findElement(signInLink);
		//eleUtil.highLightAndFlashElement(link);
		link.click();
		System.out.println("sign in link clicked");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return driver.getTitle();
	}
	
		
	public RegisterPage navigateToRegisterPage()
	{
		System.out.println("INSIDE navigateToRegisterPage()");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement link = driver.findElement(signInLink);
		//eleUtil.highLightAndFlashElement(link);
		link.click();
		
		//goToLoginPageAndGetTitle();
		//driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(signInLink).click();
		WebElement createAcccButton = driver.findElement(createAccountButton);
		createAcccButton.click();
		//eleUtil.highLightAndFlashElement(createAcccButton);
		System.out.println("You are on register page");
		RegisterPage ss = new RegisterPage(driver);
		System.out.println("registerPage instance created " + ss);
		return ss;
		
		
	}
	

}
