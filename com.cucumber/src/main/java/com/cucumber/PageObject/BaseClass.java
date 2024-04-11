package com.cucumber.PageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.PageObject.LandingPage.CartPage;

public class BaseClass {
	static WebDriver driver;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css="[routerlink*='cart']")
	static WebElement cartElement;
	
	public static String propertiesReader(String Data) throws IOException {
		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream("./Config.properties");
		 properties.load(inputStream);
		String thisValue =properties.getProperty(Data);
		 return thisValue;	
	}
	
	public static void WaitForElement(By findBY) { 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBY));
		
	}
	
	public static void waitForElementToDisapper(WebElement findBy)
    {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findBy));	
		
    }
	
	public static CartPage goToCart()
	{
		cartElement.click();
		CartPage cartpage= new CartPage(driver);
		return cartpage;
	}
	
	public static void ScrolltoBottom() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor jsExecutor =(JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,450)", " ");
		Thread.sleep(1000);
	}
	public static void Scrolltotop()
	{
		JavascriptExecutor jsExecutor =(JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,0)", " ");
	}
	
}
