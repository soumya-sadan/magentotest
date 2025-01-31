package com.qa.softwaretestingboard.tests;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.softwaretestingboard.base.BaseTest;
import com.qa.softwaretestingboard.pages.RegisterPage;


public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		//String title = loginPage.goToLoginPageAndGetTitle();
		String title = loginPage.goToLoginPageAndGetTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Customer Login"));

	}
	
	
	
	
}