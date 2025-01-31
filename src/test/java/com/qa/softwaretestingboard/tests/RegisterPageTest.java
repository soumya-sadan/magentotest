package com.qa.softwaretestingboard.tests;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.softwaretestingboard.base.BaseTest;
import com.qa.softwaretestingboard.pages.MyAccountPage;
import com.qa.softwaretestingboard.pages.RegisterPage;

	public class RegisterPageTest extends BaseTest {
	    
	    private static int counter = 0;
	    
	    @BeforeClass
	    public void regSetup() {
	    	System.out.println("INSIDE regSetup()");
	        System.out.println("LoginPage instance: " + loginPage);
	        if (loginPage == null) {
	            throw new IllegalStateException("loginPage is NULL! BaseTest setup might not be executed.");
	        }
	               
	        
	        // Navigate to register page
	        registerPage = loginPage.navigateToRegisterPage();
	        System.out.println("registerPage instance: " + registerPage);

	        // Register a new user and navigate to MyAccountPage
	    //    MyAccountPage myAccountPage = registerPage.registerAccount("John", "Doe", generateEmail(), "Test@1234");
	    //    System.out.println("myAccountPage instance: " + myAccountPage);
	        
	    }
	    
	   
	    
	    @Test(priority = 1)
	    public void verifyRegisterPageNavigationTest() {
	    	System.out.println("INSIDE verifyRegisterPageNavigationTest()");
	        RegisterPage register = loginPage.navigateToRegisterPage();
	        @Nullable
	        String title = register.getRegisterPagetitle();
	        Assert.assertTrue(title.contains("Create New Customer Account"));
	        System.out.println("You are on register page");
	    }
	    
	    public String generateEmail() {
	        counter++;
	        return "testuser" + System.currentTimeMillis() + counter + "@gmail.com";
	    }
	    
	    @DataProvider
	    public Object[][] getRegisterdatafromExcel() {
	        return ExcelUtil.getExcelTestData(AppConstants.REG_SHEET_NAME);
	    }
	    
	    @Test(priority = Integer.MAX_VALUE, dataProvider = "getRegisterdatafromExcel")
	    public void userRegisterTest(String firstname, String lastname, String password) {
	        MyAccountPage myaccountPage = registerPage.registerAccount(firstname, lastname, generateEmail(), password);
	       try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	        String title = myaccountPage.getPageTitle();
	        Assert.assertTrue(title.contains("My Account"));
	        String username = myaccountPage.verifyUserDetails();
	        String name = firstname + " " + lastname;
	        System.out.println(name);
	        Assert.assertTrue(username.contains(name));
	        System.out.println("username verified");
	        
	        myaccountPage.doLogout();
	        myaccountPage.navigateToRegisterPage();
	    }
	}
	//  --------------------
	    
	    /*public class RegisterPageTest extends BaseTest{
		
		private static int counter = 0;
		
		@BeforeClass
		public void regSetup()
		{
			
			
			System.out.println("LoginPage instance: " + loginPage);
		    if (loginPage == null) {
		        throw new IllegalStateException("loginPage is NULL! BaseTest setup might not be executed.");
		    }
		    registerPage = loginPage.navigateToRegisterPage();
		}
		
//		@Test
		//public void verifyRegistration()
//		{
		//	registerPage.registerAccount();
//		}  
		
		
		@Test(priority = 1)
		public void verifyRegisterPageNavigationTest()
		{
			RegisterPage register = loginPage.navigateToRegisterPage();
			@Nullable
			String title = register.getRegisterPagetitle();
			Assert.assertTrue(title.contains("Create New Customer Account"));
			System.out.println("You are on register page");
		}
		
		public String generateEmail() {
			
		    counter++;
		    return "testuser" + System.currentTimeMillis() + counter + "@gmail.com";
	}

			
		@DataProvider
		public Object[][] getRegisterdatafromExcel()
		{
			return ExcelUtil.getExcelTestData(AppConstants.REG_SHEET_NAME);
			
		}
		
		*//**
		 * Validate on the landing screen whether correct name and surname is displayed
		 * de-duplication handling by storing registeration info in excel.

		 * @param firstname
		 * @param lastname
		 * @param password
		 *//*
		
		@Test(priority=Integer.MAX_VALUE, dataProvider = "getRegisterdatafromExcel")
		public void userRegisterTest(String firstname, String lastname, String password)
		{
			
			MyAccountPage myaccountPage = registerPage.registerAccount(firstname, lastname, generateEmail() , password);
			@Nullable
			String title = myaccountPage.getPageTitle();
			Assert.assertTrue(title.contains("My Account"));
			String username = myaccountPage.verifyUserDetails();
			String name = firstname +" " + lastname;
			System.out.println(name);
			Assert.assertTrue(username.contains(name));
			System.out.println("username verified");	
			
			 myaccountPage.doLogout();
			 myaccountPage.navigateToRegisterPage();
		}	
		*/
		
		
		
		
		//----------------
	  
	  
	    
	    

	

