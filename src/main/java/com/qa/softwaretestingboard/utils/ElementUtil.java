package com.qa.softwaretestingboard.utils;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.factory.DriverFactory;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;
	private JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver = driver;
		act = new Actions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	//--------------CLICK----------------------------
	/**
	 * Fetches Web element from locator and performs click
	 * @param locator
	 */
		public void doClick(By locator)
	{
		getElement(locator).click();
	}
		
	/**
	 * Waits for webElement to be present for timeout duration and performs click
	 * @param locator
	 * @param timeout
	 */
	public void doClick(By locator, int timeout)
	{
		waitForElementVisible(locator,timeout).click();
	}
	
	//--------------SEND KEYS ----------------------------
	
	  public void doSendKeys(By locator, String input)
	  {
		  getElement(locator).clear();
		  getElement(locator).sendKeys(input);
	  }
	  
	  public void doSendKeys(WebElement element, String input)
	  {
		  element.clear();
		  element.sendKeys();
	  }
	  
	  public void doSendKeys(By locator, String input, int timeout)
	  {
		
		WebElement ele = waitForElementVisible(locator, timeout);
		ele.clear();
		ele.sendKeys(input);		 
	  }
	
	
	//--------------GET ELEMENT ----------------------------
	
  public WebElement getElement(By locator)
  {
	 WebElement element = driver.findElement(locator);
	 return element;
  }
  
  public WebElement getElement(By locator, String value, int timeout)
  {
	  WebElement element =  waitForElementVisible(locator, timeout);
	  return element;
	  
  }

     
  public WebElement waitForElementVisible(By locator, int timeout)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  

  
  public void highLightAndFlashElement(WebElement element)
  {
  if(Boolean.parseBoolean(DriverFactory.isHighlight))		  
  {
	  jsUtil.flash(element);
  }
  
  }
}
