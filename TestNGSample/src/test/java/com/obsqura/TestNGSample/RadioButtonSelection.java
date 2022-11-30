package com.obsqura.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonSelection extends Base{
	@Test
	public void radioButtonMaleClick() {
		WebElement radio1;
		String actText,maleSelection,expText,expString;
		Boolean messageFlag = false;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radio1=driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		if(radio1.isDisplayed()) {
			radio1.click();
			maleSelection=radio1.getText();
			expString="'"+maleSelection+"'";
			expText="Radio button "+expString+" is checked";
			driver.findElement(By.xpath("//button[@id='button-one']")).click();
			actText=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
			if(actText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");

		}
		Assert.assertTrue(radio1.isDisplayed(), "Radio button male type is not displayed");
	}
	@Test
	public void radioButtonFemaleClick() {
		WebElement radio2;
		String actText,femaleSelection,expText,expString;
		Boolean messageFlag = false;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radio2=driver.findElement(By.xpath("//label[@for='inlineRadio2']"));
		if(radio2.isDisplayed()) {
			radio2.click();
			femaleSelection=radio2.getText();
			expString="'"+femaleSelection+"'";
			expText="Radio button "+expString+" is checked";
			driver.findElement(By.xpath("//button[@id='button-one']")).click();
			actText=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
			if(actText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");
		}
		Assert.assertTrue(radio2.isDisplayed(), "Radio button female type is not displayed");
	}
	@Test
	public void noSelection() {
		WebElement radio1,radio2;
		boolean selection1,selection2;
		String actText,expText="Radio button is Not checked";
		Boolean messageFlag=false;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radio1=driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		radio2=driver.findElement(By.xpath("//label[@for='inlineRadio2']"));
		selection1=radio1.isSelected();
		selection2=radio2.isSelected();
		driver.findElement(By.xpath("//button[@id='button-one']")).click();
		actText=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		if(selection1==false && selection2==false) {
			if(actText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");
		}
		Assert.assertTrue(selection1==false && selection2==false, "One of the Radio button is selected");
	}
}
