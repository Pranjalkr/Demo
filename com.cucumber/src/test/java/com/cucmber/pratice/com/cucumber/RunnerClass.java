package com.cucmber.pratice.com.cucumber;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.PageObject.BaseClass;
import com.cucumber.PageObject.LandingPage.CartPage;
import com.cucumber.PageObject.LandingPage.LandingPage;
import com.cucumber.PageObject.LandingPage.PamentPage;
import com.cucumber.PageObject.LandingPage.ProductCatalog;

public class RunnerClass extends BaseClass {

	public RunnerClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();	
		LandingPage login = new LandingPage(driver);
		login.LoginURLsetup();
		ProductCatalog products=login.loginApplication(BaseClass.propertiesReader("email"),BaseClass.propertiesReader("password"));
		//ProductCatalog products= new ProductCatalog(driver); creating the object in landing page and returning the product as a object
		products.addProductToCart(BaseClass.propertiesReader("ProductName"));
		CartPage cartpage = BaseClass.goToCart();
		//CartPage cartpage= new CartPage(driver);
		Boolean booleanvalue=cartpage.verifyProductDisplayed(BaseClass.propertiesReader("ProductName"));
		Assert.assertTrue(booleanvalue);
		cartpage.clickOnTotal();
		PamentPage pmntpage = new PamentPage(driver);
		pmntpage.choiceCountry(BaseClass.propertiesReader("CountryName"));
		Assert.assertTrue(pmntpage.ThankyouMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
