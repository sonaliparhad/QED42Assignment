package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage {
	
	public String amazonePrice="";
    
	@FindBy(css="input#twotabsearchtextbox")
	public WebElement searchField;
	
	@FindBy(css="div.s-suggestion-container div.s-suggestion")
	public WebElement appleIphone13;
	
	@FindBy(xpath="(//span[text()='80,990'])[1]")
	public WebElement price;
	
	
	
	
	public void enterTextInSearchField() {
          searchField.sendKeys("APPLE iPhone 13 (Starlight, 256 GB)");
	}
	
	public void clickOnAppleIphone13() {
        appleIphone13.click();
	}
	
	public void getPriceOfAppleIphone13() {
         amazonePrice = price.getText();
         System.out.println("Amazon Apple iPhone13 price: " +amazonePrice);
	}
}
