package com.obsqura.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementCommands extends Base{
	@Test(description="Single field input message validating")
	public void sendKeysSample() {
		String inputMessage = "Hi Message!!!",outputMessage;
		boolean flag = false;
		driver.findElement(By.xpath("//input[@id='single-input-field']")).sendKeys(inputMessage);
		driver.findElement(By.xpath("//button[@id='button-one']")).click();
		outputMessage=driver.findElement(By.xpath("//div[@id='message-one']")).getText();// retruns string and getText() will locate web elements

		if(outputMessage.equals("Your Message : "+inputMessage)) {
			flag = true;
		}
		Assert.assertTrue(flag, "Messages are not same");
	}
	
	@Test(description = "getting CSS attributes of button")
	public void getCSSValueSample() {
		String bgColor, expectedColor,color;
		Point location;
		bgColor= driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("background-color");
		color = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("color"); //getting button font color
		location = driver.findElement(By.xpath("//button[@id='button-one']")).getLocation();
		int locatonY= location.getY();
		int locationX= location.getX();
		//int xAxis = driver.findElement(By.xpath("//button[@id='button-one']")).getLocation().getX(); // single line of declaration for excluding the multiple line of code

	}
	@Test(description = "getting button Background color")
	public void getBgColor() {
		String bgColor, expectedBgColor="rgba(0, 123, 255, 1)";
		bgColor = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("background-color");
	    Assert.assertEquals(bgColor, expectedBgColor, "Background colors are not equal");
	}
	
	@Test(description = "getting button font color")
	public void getFontColor() {
		String fontColor, expectedFontColor="rgba(255, 255, 255, 1)";
		fontColor = driver.findElement(By.xpath("//button[@id='button-one']")).getCssValue("color"); //getting button font color
	    Assert.assertEquals(fontColor, expectedFontColor, "Element font colors are not equal");
	}
	
	@Test(description = "CSS attribute Widgets Positions comparing")
	public void getBtnPositions() {
		//Point locationBtnShowMessage,locationLabelYourMessage;
		int btnShowMsgYVal, btnYourMsgYVal;
		boolean flag = false;
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php\\");
		//locationBtnShowMessage = driver.findElement(By.xpath("//button[@id='button-one']")).getLocation(); //x=425 and y=257
		//locationLabelYourMessage = driver.findElement(By.xpath("//div[@id='message-one']")).getLocation(); //x=425 and y=303
		btnShowMsgYVal= driver.findElement(By.xpath("//button[@id='button-one']")).getLocation().getY();
		btnYourMsgYVal = driver.findElement(By.xpath("//div[@id='message-one']")).getLocation().getY();
		/*if(btnYourMsgYVal>btnShowMsgYVal) {
			flag = true;
		}*/
		Assert.assertTrue(btnYourMsgYVal>btnShowMsgYVal, "Widgets are not aligned well");
	}
	@Test(description= "Getting elements attribute ID")
	public void getAttributeID() {
		String attributeID,expectedAttributeID="button-one";
		attributeID = driver.findElement(By.xpath("//button[@id='button-one']")).getAttribute("id");
		Assert.assertEquals(attributeID, expectedAttributeID, "Attribute ID's are not same");
	}
	
	@Test(description= "Getting elements attribute Class Name")
	public void getAttributeClassName() {
		String attributeClassName,expectedAttributeClassName="btn btn-primary";
		attributeClassName = driver.findElement(By.xpath("//button[@class='btn btn-primary']")).getAttribute("class");
		Assert.assertEquals(attributeClassName, expectedAttributeClassName, "Attribute class names are not same");
	}
	
	@Test(description= "Getting elements attribute Tag Name")
	public void getAttributeTagName() {
		String attributeType,expectedAttributeType="button";
		attributeType = driver.findElement(By.xpath("//button[@id='button-one']")).getTagName();
		Assert.assertEquals(attributeType, expectedAttributeType, "Attribute tag names are not same");
	}
	
	@Test(description= "Getting elements attribute Size(HeightxWidth)")
	public void getAttributeSize() {
		//Dimension size;
		int attributeSizeHeight, attributeSizeWidth;
		attributeSizeHeight = driver.findElement(By.xpath("//button[@id='button-one']")).getSize().getHeight();
		attributeSizeWidth = driver.findElement(By.xpath("//button[@id='button-one']")).getSize().getWidth();
		//size = driver.findElement(By.xpath("//button[@id='button-one']")).getSize();
		Assert.assertTrue(attributeSizeWidth>attributeSizeHeight, "Locate Elements Dimensions are not found!");
	}
	
	@Test(description= "Check the WebElement is enabled")
	public void checkButtonEnabled() {
		boolean enabled;
		enabled = driver.findElement(By.xpath("//button[@id='button-one']")).isEnabled();
		Assert.assertTrue(enabled,"Button is not Enabled");
	}
	@Test(description= "Check the WebElement is displayed")
	public void checkButtonDisplayed() {
		boolean displayed;
		displayed = driver.findElement(By.xpath("//button[@id='button-one']")).isDisplayed();
		Assert.assertTrue(displayed,"Button is not Displayed");
	}
	
	/*@Test(description= "Check the WebElement is disabled")
	public void checkButtonDisabled() {
		boolean disabled;
		disabled = driver.findElement(By.xpath("//button[@id='button-one']")).isEnabled();
		Assert.assertFalse(disabled,"Button is Displayed");
	}*/
	
	@Test(description ="Check whether the element is input field and for the button enabled, display the messgae which is entered in the input field")
	public void checkFormElementsOperations() {
		String attributeType, expectedAttributeType="input", inputMessage = "Selenium Automation",outputMessage;
		boolean flag = false,enabled;
		attributeType = driver.findElement(By.xpath("//input[@id='single-input-field']")).getTagName();
		if(attributeType.equals(expectedAttributeType)) {
			flag = true;
			driver.findElement(By.xpath("//input[@id='single-input-field']")).sendKeys(inputMessage);
		}
		Assert.assertTrue(flag, "Located Element is not an input field");
		enabled = driver.findElement(By.xpath("//button[@id='button-one']")).isEnabled();
		if(enabled == true) {
			driver.findElement(By.xpath("//button[@id='button-one']")).click();
		}
		Assert.assertTrue(enabled, "Button is not Enabled");
		outputMessage=driver.findElement(By.xpath("//div[@id='message-one']")).getText();
		
		if(outputMessage.equals("Your Message : "+inputMessage)) {
			flag = true;
		}
		Assert.assertTrue(flag, "Messages are not same");
	}
	
}
