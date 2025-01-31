package com.qa.softwaretestingboard.utils;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class JavaScriptUtil {
		
		private WebDriver driver;
		private JavascriptExecutor js;
		
		public JavaScriptUtil(WebDriver driver) {
			this.driver = driver;
			js = (JavascriptExecutor)driver;
		}
		
		public String getPageTitle() {
			return js.executeScript("return document.title;").toString();
		}
		
		public String getPageURL() {
			return js.executeScript("return document.URL;").toString();
		}
			
		
		public void flash(WebElement element) {
			String bgcolor = element.getCssValue("backgroundColor");//white
			for (int i = 0; i < 50; i++) {
				changeColor("rgb(0,200,0)", element);// Green
				changeColor(bgcolor, element);// While
			}
		}

		private void changeColor(String color, WebElement element) {
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);//G-->W--G--W---G--W
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
		
		

	}


