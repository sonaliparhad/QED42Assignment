package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipKartHomePage {
	
	public String flipkartPrice = "";
    
	@FindBy(css="div._2QfC02>button._2KpZ6l")
	public WebElement cancelButtonOfLoginPage;
	
	@FindBy(xpath="//input[@title=\"Search for products, brands and more\"]")
	public WebElement searchField;
	
	@FindBy(css="ul.col-12-12 li:nth-child(1) div a")
	public WebElement appleIphone13;
	
	@FindBy(xpath="(//div[@class=\"_30jeq3 _1_WHN1\"])[1]")
	public WebElement priceOfIphone13;
	
	
	public void clickOnCancelButton() {
        cancelButtonOfLoginPage.click();
	}
	
	public void enterTextOnSearchField() {
        searchField.sendKeys("APPLE iPhone 13 (Starlight, 256 GB)");
	}
	
	public void clickOnIphone13() {
        appleIphone13.click();
	}
	
	public void getPriceOfIphone13() {
		flipkartPrice = priceOfIphone13.getText();
		System.out.println("Flipkart price of Apple iphone13: "+flipkartPrice);
	}
}
