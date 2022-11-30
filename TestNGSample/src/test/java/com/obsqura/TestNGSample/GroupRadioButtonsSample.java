package com.obsqura.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupRadioButtonsSample extends Base{
	boolean selection1,selection2,selection3;

	@Test(description = "Validate title is displayed and radio button are not selected")
	public void noSelectionPatientsGender() {
		WebElement radio1,radio2,title;
		//boolean selection1,selection2;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		title = driver.findElement(By.xpath("//form[h4='Pateints Gender']"));
		if(title.isDisplayed()) {
		radio1=driver.findElement(By.xpath("//label[@for='inlineRadio1']"));
		radio2=driver.findElement(By.xpath("//label[@for='inlineRadio2']"));
		selection1=radio1.isSelected();
		selection2=radio2.isSelected();
		}
		Assert.assertTrue(title.isDisplayed(), "Patients Gender label is not displayed");
	}
	
	@Test(description = "Validate title is displayed and radio button are not selected")
	public void noSelectionPatientsAgeGroup() {
		WebElement radio1,radio2,radio3,title;
		//boolean selection1,selection2,selection3;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		title = driver.findElement(By.xpath("//form[h4='Pateints Age Group']"));
		if(title.isDisplayed()) {
		radio1=driver.findElement(By.xpath("//input[@id='inlineRadio22']"));
		radio2=driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
		radio3=driver.findElement(By.xpath("//input[@id='inlineRadio24']"));
		selection1=radio1.isSelected();
		selection2=radio2.isSelected();
		selection3=radio3.isSelected();
		}
		Assert.assertTrue(title.isDisplayed(), "Patients Age Group label is not displayed");
	}
	
	@Test(description = "Validate that title is displayed, radio buttons are not selected,on button click show messages")
	public void noSelection() {
		String actualText, expText = "Gender :"+"\n"+"Age group:";
		Boolean messageFlag = false;
		noSelectionPatientsGender();
		noSelectionPatientsAgeGroup();
		driver.findElement(By.xpath("//button[@id='button-two']")).click();
		actualText = driver.findElement(By.xpath("//div[@id='message-two']")).getText();
		if(selection1==false && selection2==false && selection3==false) {
			if(actualText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");
		}
		Assert.assertTrue(selection1==false && selection2==false && selection3==false, "One of the Radio button is selected");
	}
	@Test
	public void radioButtonMaleClick() {
		WebElement radio1;
		String actualText, maleSelection,expString,expText;
		Boolean messageFlag = false;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radio1=driver.findElement(By.xpath("//label[@for='inlineRadio11']"));
		if(radio1.isDisplayed()) {
			radio1.click();
			maleSelection=radio1.getText();
			expText="Gender : "+maleSelection+"\n"+"Age group:";
			driver.findElement(By.xpath("//button[@id='button-two']")).click();
			actualText = driver.findElement(By.xpath("//div[@id='message-two']")).getText();
			if(actualText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");
		}
		Assert.assertTrue(radio1.isDisplayed(), "Radio button male type is not displayed");
	}
	
	@Test
	public void radioButtonMaleAndAgeGroupClick() {
		WebElement radio1,radioAgeGroup1;
		String actualText, maleSelection,ageGroupSelection,expText;
		Boolean messageFlag = false;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		radio1=driver.findElement(By.xpath("//label[@for='inlineRadio11']"));
		radioAgeGroup1=driver.findElement(By.xpath("//label[@for='inlineRadio22']"));
		if(radio1.isDisplayed()) {
			radio1.click();
			maleSelection=radio1.getText();
			radioAgeGroup1.click();
			ageGroupSelection = radioAgeGroup1.getText();
			expText="Gender : "+maleSelection+"\n"+"Age group:"+" "+ageGroupSelection;
			driver.findElement(By.xpath("//button[@id='button-two']")).click();
			actualText = driver.findElement(By.xpath("//div[@id='message-two']")).getText();
			if(actualText.equals(expText)) {
				messageFlag=true;
			}
			Assert.assertTrue(messageFlag, "Actual and Expected radio button messages are not equal");
		}
		Assert.assertTrue(radio1.isDisplayed(), "Radio button male type is not displayed");
	}
}

