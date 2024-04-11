package com.cucumber.PageObject.LandingPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.PageObject.BaseClass;

public class PamentPage {
	
	WebDriver driver;
	
	public PamentPage(WebDriver driver) {
		super();
		this.driver=driver;
	}
	
	public void choiceCountry(String CountryName) throws InterruptedException
	{
		By CountryList = By.cssSelector(".ta-results");
		WebElement countryElement=driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		countryElement.sendKeys(CountryName);
		BaseClass.WaitForElement(CountryList);
		ArrayList <WebElement> ab=(ArrayList<WebElement>) driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));

		for(int i=0;i<ab.size();i++)
		{
			if(ab.get(i).getText().equalsIgnoreCase(CountryName))
			{
				ab.get(i).click();
			}
		}
		submit();
	}
	
	public void submit() throws InterruptedException {
		By findBY=By.cssSelector(".action__submit");
		BaseClass.ScrolltoBottom();
		WebElement frameElement=driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"));
		//driver.switchTo().frame(frameElement);
		BaseClass.WaitForElement(findBY);
		driver.findElement(By.cssSelector(".action__submit")).click();
	}
	
	public String ThankyouMessage()
	{
		return driver.findElement(By.cssSelector(".hero-primary")).getText();
	}
	
}
