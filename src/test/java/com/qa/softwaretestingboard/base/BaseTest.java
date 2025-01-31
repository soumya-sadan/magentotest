package com.qa.softwaretestingboard.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.softwaretestingboard.factory.DriverFactory;
import com.qa.softwaretestingboard.pages.LoginPage;
import com.qa.softwaretestingboard.pages.MyAccountPage;
import com.qa.softwaretestingboard.pages.RegisterPage;



public class BaseTest {

	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	protected MyAccountPage myaccountPage;

	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(@Optional String browserName)
	{
		df = new DriverFactory();
		prop = df.initProp();
		// driver = df.initDriver(prop);
		
			
		// check if browser parameter is coming from testng.xml
		if(browserName!= null)
		{
			prop.setProperty("browser", browserName);
			//prop.setProperty("browserversion", browserVersion);
			//prop.setProperty("testname", testName);
		}
		driver = df.initDriver(prop);
		
		System.out.println("DONE---------------");
		
		if (loginPage == null) 	

		{
			loginPage = new LoginPage(driver);
			System.out.println("loginPage insitiazed");
			System.out.println("LoginPage instance: " + loginPage);
			
		}	
		else
		{
			System.out.println("loginPage not null.. Login page insitiazed");
		}
		
		
		
	}

	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
