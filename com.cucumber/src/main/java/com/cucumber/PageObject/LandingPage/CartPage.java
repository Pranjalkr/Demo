package com.cucumber.PageObject.LandingPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.PageObject.BaseClass;


public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List <WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement total;
	
	public Boolean verifyProductDisplayed(String productName ) {	
		Boolean match = productTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void clickOnTotal() throws InterruptedException {
		BaseClass.ScrolltoBottom();
		Thread.sleep(100);
		total.click();
		Thread.sleep(100);
	//	BaseClass.Scrolltotop();
	}
	
}
