package com.qa.softwaretestingboard.pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.constants.AppConstants;
import com.qa.softwaretestingboard.utils.ElementUtil;

public class RegisterPage {

	WebDriver driver;
	Actions act;
	ElementUtil eleUtil;

	private By firstName = By.id("firstname");
	//private By LastName = By.id("lastname");
	//private By email = By.id("email_address");
	//private By password = By.id("password");
	//private By confirmPass = By.id("password-confirmation");
	private By createAccountButton = By
			.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * Registering on the website https://magento.softwaretestingboard.com/
	 * 
	 * @param fname
	 * @param lname
	 * @param email
	 * @param password
	 * @return
	 */
	public MyAccountPage registerAccount(String fname, String lname, String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstName))).sendKeys(fname);
		//eleUtil.highLightAndFlashElement(name);
		act = new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(lname).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(password)
				.sendKeys(Keys.TAB).sendKeys(password).build().perform();

		driver.findElement(createAccountButton).click();
		System.out.println("account created and you are logged in");
		return new MyAccountPage(driver);

	}

	public @Nullable String getRegisterPagetitle() {
		return driver.getTitle();

	}

}
