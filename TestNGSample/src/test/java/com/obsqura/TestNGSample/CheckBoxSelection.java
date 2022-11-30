	package com.obsqura.TestNGSample;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	public class CheckBoxSelection extends Base{
		@Test
		public void checkBoxSelection() {
			WebElement checkBox;
			String actualText,expText = "Success - Check box is checked";
			Boolean selected;
			driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
			checkBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
			selected = checkBox.isEnabled();
			if(selected==false) {
				checkBox.click();
				if(checkBox.isSelected()) {
					actualText = driver.findElement(By.xpath("//div[@id='message-one']")).getText();
					Assert.assertEquals(actualText, expText, "Actual and Expected results are not matched");
			}
				Assert.assertTrue(selected, "Checkbox is already selected");
		}
	}
}
