package com.obsqura.TestNGSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectFromDropDown extends Base{
	@Test
	public void selectSample() {
		String inputText="Red",expText = "Selected Color : "+inputText,actualText;
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.id("single-input-field")));
		objSelect.selectByVisibleText(inputText);
		actualText = driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		Assert.assertEquals(actualText, expText, inputText+" is not selected.");
	}

	@Test
	public void selectByIndex() {
		String actualIndexColor, expectedColor="Green";
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.id("single-input-field")));
		objSelect.selectByIndex(3); //getting red from the dropdown
		//objSelect.selectByIndex(0); //getting the 'select' from the dropdown
		 actualIndexColor = objSelect.getFirstSelectedOption().getText();
		Assert.assertEquals(actualIndexColor, expectedColor,"Selected Index drop down item is no longer present");
	}
	@Test
	public void selectByValue() {
		String inputValue="Yellow";
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.id("single-input-field")));
		objSelect.selectByValue(inputValue); //getting the web element value as selection item in the dropdown
		Assert.assertNotNull(objSelect.getFirstSelectedOption().getText(), "Dropdown item is not selected");
		
	}
	@Test
	public void selectByGetOptions() {
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		Select objSelect = new Select(driver.findElement(By.id("single-input-field")));
		List <WebElement> listItems = objSelect.getOptions();
		int listCount = listItems.size();
		Assert.assertNotNull(listCount, "List size is empty");
	}
	@Test
	public void multipleSelectDropDown() {
		WebElement btnSelectall;
		String listColor1, listColor2, actualMessage,expMessage;
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
			Select objSelect = new Select(driver.findElement(By.id("multi-select-field"))); 
			objSelect.isMultiple();
			objSelect.selectByIndex(1);
			objSelect.selectByIndex(2);
			btnSelectall = driver.findElement(By.xpath("//button[@id='button-all']"));
				if(btnSelectall.isEnabled()) {
				btnSelectall.click();
				List <WebElement> colorDropdown=objSelect.getOptions();
				listColor1= colorDropdown.get(1).getText();
				listColor2= colorDropdown.get(2).getText();
				expMessage = "All selected colors are : "+listColor2;
				actualMessage = driver.findElement(By.xpath("(//div[@class='my-2'])[2]")).getText();
				Assert.assertEquals(actualMessage, expMessage, "Selected dropdown list items are not as same as expected one");
		   }
		Assert.assertTrue(btnSelectall.isEnabled(), "get All Selected button is disabled");
	}
		
}
