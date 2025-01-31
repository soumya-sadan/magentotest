package com.qa.softwaretestingboard.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.softwaretestingboard.base.BaseTest;
import com.qa.softwaretestingboard.pages.MyAccountPage;

public class MyAccountPageTest extends BaseTest {

	
	
	  @BeforeClass public void myaccSetup() 
	  { 
		  
		  myaccountPage =   registerPage.registerAccount("sathy", "hari", "ss123456@gmail.com", "Test123456");
	  }
	
}
	/*
	@Test(dataProvider="getUserData")	
	public void verifyUserDetailsTest()
	{
		String userInfo = myaccountPage.verifyUserDetails();
		Assert.assertTrue(userInfo.contains("))
	}  
	*/


