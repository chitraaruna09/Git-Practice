package com.obsqura.TestNGSample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertSample extends Base{
	@Test(description ="soft assert ")
	public void softAssertSample() {
		String actualTitle, actualUrl, expectedTitle = "Obsqura Testing", expectedURL = "https://selenium.obsqurazone.com/simple-form-demo.php//";
		actualTitle = driver.getTitle(); // getting title of the loaded site
		actualUrl = driver.getCurrentUrl();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualUrl, expectedURL);
		softAssert.assertAll();
	}

}
