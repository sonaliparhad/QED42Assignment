package com.testCasesOfAmazon;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.baseTest.BaseTest;
import com.pages.AmazonHomePage;
import com.pages.FlipKartHomePage;
import com.utility.Keywords;

public class TestCasesForGettingPrice extends BaseTest{
	
	AmazonHomePage home;
	 FlipKartHomePage fHome;
    
	@Test
	public void testCase1ForAmazon() throws InterruptedException {
		
		Keywords.openUrl("https://www.amazon.in/");
		Keywords.driver.manage().window().maximize();
	    home = PageFactory.initElements(Keywords.driver, AmazonHomePage.class);
		
		home.enterTextInSearchField();
		Thread.sleep(2000);
		
		home.clickOnAppleIphone13();
		Thread.sleep(2000);
		
		home.getPriceOfAppleIphone13();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCase2ForFlipKart() throws InterruptedException {
       Keywords.openUrl("https://www.flipkart.com/");
       Keywords.driver.manage().window().maximize();
       fHome = PageFactory.initElements(Keywords.driver, FlipKartHomePage.class);
       fHome.clickOnCancelButton();
       Thread.sleep(2000);
       
       fHome.enterTextOnSearchField();
       Thread.sleep(2000);
       
       fHome.clickOnIphone13();
       Thread.sleep(2000);
       
       fHome.getPriceOfIphone13();
       Thread.sleep(2000);
	}
	
	@Test
	public void testCase3ForComparingPrice() {
        int amazonPrice = Integer.valueOf(home.amazonePrice.substring(home.amazonePrice.indexOf("8"), home.amazonePrice.indexOf("0")+1)+home.amazonePrice.substring(home.amazonePrice.indexOf(",")+1 , home.amazonePrice.lastIndexOf("0")+1));
        System.out.println("price of iphone13 on Amazon: "+amazonPrice);
        
        int flipKartPrice = Integer.valueOf(fHome.flipkartPrice.substring(1,3 )+fHome.flipkartPrice.substring(4, 7));
	     System.out.println("price of iphone13 on FlipKart: "+flipKartPrice);
	     
	    int lessPrice = Integer.compare(amazonPrice, flipKartPrice);
	    if(lessPrice<0) {
	    	System.out.println("Amazon price is less than FlipKart price " +amazonPrice);
	    }else {
	    	
	    	System.out.println("flipKart price is less than Amazon price " +flipKartPrice);
	    }
	}
	
}
