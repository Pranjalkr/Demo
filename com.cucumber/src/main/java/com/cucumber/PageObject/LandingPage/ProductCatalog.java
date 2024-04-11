package com.cucumber.PageObject.LandingPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.PageObject.BaseClass;

public class ProductCatalog {
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver){
		this.driver=driver;
	}
	public ProductCatalog(){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	By addToVart=By.cssSelector(".card-body button:last-of-type");
	By ProdList=By.cssSelector(".mb-3");
	By elemToApearBy=By.cssSelector("#toast-container");
	
//	@FindBy(css = ".mb-3")
//	List<WebElement> productsElements=driver.findElements(By.cssSelector(".mb-3"));
	
//	@FindBy(css =".ng-animating")
//	WebElement spinnerElement;
	
	
	public List<WebElement> getProductList()
	{
		BaseClass.WaitForElement(ProdList);
		List<WebElement> productsElements=driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		return productsElements;
	}
	
	public WebElement getProductName(String productName)
	{
		List<WebElement> products=getProductList();
		WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName)
	{
		WebElement productEle = getProductName(productName);
		productEle.findElement(addToVart).click();
		BaseClass.WaitForElement(elemToApearBy);
		WebElement spinnerElement=driver.findElement(By.cssSelector(".ng-animating"));
		BaseClass.waitForElementToDisapper(spinnerElement);
	}
}
