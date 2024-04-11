package com.cucumber.PageObject.LandingPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.PageObject.BaseClass;

public class LandingPage extends BaseClass{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmailElement;
	
	@FindBy(id="userPassword")
	WebElement userPasswordElement;
	
	@FindBy(id="login")
	WebElement Login;
	
	public void LoginURLsetup() throws IOException
	{
		driver.get(BaseClass.propertiesReader("Baseurl"));
	}
	public ProductCatalog loginApplication(String email, String password) {
		userEmailElement.sendKeys(email);
		userPasswordElement.sendKeys(password);
		Login.click();
		ProductCatalog products= new ProductCatalog(driver);
		return products;
	}
	
	
}
