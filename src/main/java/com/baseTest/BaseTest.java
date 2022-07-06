package com.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utility.Keywords;

public class BaseTest {
	 
	Keywords key = new Keywords();

	@BeforeMethod
    public void setupBrowser() {
         Keywords.openBrowser("chrome");
	}	
	
	@AfterMethod
	public void tearDownBrowser() {
        Keywords.driver.close();
	}
}
