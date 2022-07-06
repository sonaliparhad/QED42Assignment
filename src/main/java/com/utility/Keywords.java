package com.utility;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	public static RemoteWebDriver driver = null;
	
	
	/**
	 * This method will launch specified browser 
	 * @param browserName must be one of the following
	 * <ul>
	 * <li>Chrome</li>
	 * <li>FireFox</li>
	 * <li>MSEdge</li>
	 * </ul>
	 */
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.err.println("Invalid Browser name: "+browserName);
		}
   }
	
	/**
	 * This method will open specified url in currently open browser window
	 * @param url
	 */
	
     public static void openUrl(String url) {
        driver.get(url);
	}
	
}
