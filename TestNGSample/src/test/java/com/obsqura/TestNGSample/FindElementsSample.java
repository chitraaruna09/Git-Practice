package com.obsqura.TestNGSample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindElementsSample extends Base{
	@Test(description = "Locate web elements using the findElements;list of elements. finding the checkbox button and click on it") 
	public void findElementsSample() {
		String expButton = "Checkbox Demo",actURL,expURL="https://selenium.obsqurazone.com/check-box-demo.php";
		List<WebElement> menuItems = driver.findElements(By.xpath("//li[@class='list-group-item']//a"));
		for(WebElement menu:menuItems) {
			if(menu.getText().equals(expButton)) {
				menu.click();
				break;
			}
		}
		actURL=driver.getCurrentUrl();
		Assert.assertEquals(expURL, actURL);
	}
	@Test 
	public void datePickerMethod() {
		String button="Date Pickers",actualText;
		List<WebElement> items=driver.findElements(By.xpath("//li[@class='nav-item']//a"));
		for(WebElement selectItem:items) {
			actualText=selectItem.getText();
			if(actualText.contains(button)) {
				selectItem.click();
				Assert.assertTrue(true);
			}
		}
	}
	
}
