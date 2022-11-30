package com.obsqura.TestNGSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MultipleCheckBoxSample extends Base{
	@Test
	public void mulltipleCheckBox() {
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement chkBoxOne,chkBoxTwo,chkBoxThree,chkBoxFour,btnSelectAll;
		Boolean ischkBoxOneSelected,ischkBoxTwoSelected,ischkBoxThreeSelected,ischkBoxFourSelected,isbtnSelectAllEnabled;
		String expbuttonNameTxt = "Unselect All", actualbuttonNameTxt,strTxt;
		SoftAssert softAssert = new SoftAssert();
		chkBoxOne = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		chkBoxTwo = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		chkBoxThree = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		chkBoxFour = driver.findElement(By.xpath("//input[@id='check-box-four']"));
		btnSelectAll  = driver.findElement(By.xpath("//input[@id='button-two']"));
		ischkBoxOneSelected = chkBoxOne.isSelected();
		ischkBoxTwoSelected = chkBoxTwo.isSelected();
		ischkBoxThreeSelected = chkBoxThree.isSelected();
		ischkBoxFourSelected = chkBoxFour.isSelected();
		//isbtnSelectAllEnabled = btnSelectAll.isSelected();
		if(ischkBoxOneSelected==false && ischkBoxTwoSelected == false && ischkBoxThreeSelected == false &ischkBoxFourSelected == false) {
			if(btnSelectAll.isEnabled()==true) {
				btnSelectAll.click();
				//strTxt = btnSelectAll.getText();
				driver.findElement(By.xpath("//input[@id='button-two']")).click();
				//actualbuttonNameTxt = driver.findElement(By.xpath("//input[@id='button-two']")).getText();
				actualbuttonNameTxt = driver.findElement(By.cssSelector("input#button-two")).getText();
				Assert.assertEquals(actualbuttonNameTxt, expbuttonNameTxt, "Actual and Expected Values are not matched");
			}
			softAssert.assertTrue(btnSelectAll.isEnabled(), "Select All button is not displayed");
		}
		softAssert.assertTrue(ischkBoxOneSelected, "Checkbox 1 is selected");
		softAssert.assertTrue(ischkBoxOneSelected, "Checkbox 2 is selected");
		softAssert.assertTrue(ischkBoxOneSelected, "Checkbox 3 is selected");
		softAssert.assertTrue(ischkBoxOneSelected, "Checkbox 4 is selected");
		softAssert.assertTrue(ischkBoxOneSelected, "Select All Button  is selected");
		softAssert.assertAll();
	}

}
