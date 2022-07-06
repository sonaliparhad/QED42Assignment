package com.testCasesOfGuiGeneric;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.baseTest.BaseTest;
import com.pages.HandlingTable;
import com.utility.Keywords;

public class TestCasesOfGenericGui extends BaseTest {

	HandlingTable table;

	// @Test
	public void testCase1ForValidating100Rows() throws InterruptedException {
	

		table = PageFactory.initElements(Keywords.driver, HandlingTable.class);
		table.clickOnSelectContainer();
		Thread.sleep(2000);
		table.selectNumberOfRows(100);
		Thread.sleep(2000);

		table.getTextOfShowingIteams();
		Thread.sleep(2000);
	}

	@Test
	public void testCase2ForGettingInformation() throws InterruptedException {
		int rows = 10;
		Keywords.openUrl("https://generic-ui.com/demo");
		Keywords.driver.manage().deleteAllCookies();
		Keywords.driver.manage().window().maximize();

		table = PageFactory.initElements(Keywords.driver, HandlingTable.class);
		table.clickOnSelectContainer();
		Thread.sleep(2000);

		table.selectNumberOfRows(100);
		Thread.sleep(2000);

		// table.enterTextOnSearchPhrase();
		Thread.sleep(2000);

		List<WebElement> list = Keywords.driver.findElements(By.cssSelector("div.gui-row>div.gui-cell:nth-child(6)"));

		System.out.println(list.size());
		for (WebElement elements : list) {

			Keywords.driver.executeScript("document.querySelector(\"div.gui-structure-container\").scrollBy(0 , 500)");
			Thread.sleep(3000);

			String status = elements.getText();
			Thread.sleep(3000);

			System.out.println("project Status: " + status);

		}

	}
	
	@Test
	public void printProjectNames() {
		Keywords.openUrl("https://generic-ui.com/demo");
		table = new HandlingTable();
		table.selectNumberOfRows(100);
		table.getProjectNames();
	}
}
