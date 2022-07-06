package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Keywords;

public class HandlingTable {

	@FindBy(css = "div.gui-select-container")
	public WebElement selectContainer;

	@FindBy(css = "div.gui-options-list div.gui-option:nth-child(1)")
	public WebElement select100Rows;


	@FindBy(css = "div.gui-structure-info-panel")
	public WebElement showingIteams;

	@FindBy(css = "div.gui-structure-content div.gui-structure-row div.gui-structure-cell:nth-child(3) gui-view-text span")
	public List<WebElement> projectNames;

	public HandlingTable() {
		PageFactory.initElements(Keywords.driver, this);
	}

	public void clickOnSelectContainer() {
		selectContainer.click();
	}

	/**
	 * 
	 * @param rows value must be 100, 1000 or 10000
	 */
	public void selectNumberOfRows(int rows) {
		selectContainer.click();
		Keywords.driver.findElement(By.xpath("//div[@class=\"gui-options-list gui-downward gui-options-opened\"]/div[contains(text(),'"+rows+" R')]")).click();
	}

	public void getTextOfShowingIteams() {
		String text = showingIteams.getText();
		System.out.println(text);
		if (text.contains("100")) {
			System.out.println("test case pass. showing 100 iteams");
		} else {
			System.out.println("test case failed");
		}
	}

	

	

 	public void getProjectNames() {
		int startRowNum = 296;
		List<String> prjctNames = new ArrayList<String>();
		int size = Keywords.driver.findElements(By.cssSelector(
				"div.gui-structure-content div.gui-structure-row div.gui-structure-cell:nth-child(3) gui-view-text span"))
				.size();
		WebElement row = Keywords.driver
				.findElement(By.cssSelector("div.gui-structure-content div.gui-structure-row:nth-child(14)"));
		while (!row.getAttribute("id").endsWith("388")) {
			for (WebElement project : projectNames) {
				prjctNames.add(project.getText());
				System.out.println(project.getText());
			}

			Keywords.driver
					.executeScript("document.querySelector(\"div.gui-structure-container\").scrollBy(0 , 600)");
			row = Keywords.driver
					.findElement(By.cssSelector("div.gui-structure-content div.gui-structure-row:nth-child(14)"));
		}
	}
	
}
