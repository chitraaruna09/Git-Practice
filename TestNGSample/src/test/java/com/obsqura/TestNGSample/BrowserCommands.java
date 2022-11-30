package com.obsqura.TestNGSample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserCommands extends Base {
	@Test
	public void verifyTitle() {
		String actualTitle,
		expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		actualTitle = driver.getTitle(); // getting title of the loaded site
		// verifying the page title
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void verifyURL() {
		String actualUrl, expectedURL = "https://www.amazon.in/";
		actualUrl = driver.getCurrentUrl();
		// verifying the page URL's
		Assert.assertEquals(expectedURL, actualUrl);
	}

	@Test
	public void verifyPageSource() {
		String actualPageSource, pageSourceText = "Search in";
		// getting page source details
		actualPageSource = driver.getPageSource();
		Assert.assertTrue(actualPageSource.contains(pageSourceText), "Page Source is not Found");
	}

	@Test
	public void navigateAndCheck() {
		String actualLoginURL,
		expectedLoginURL = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		driver.navigate().to("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		actualLoginURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedLoginURL, actualLoginURL);
	}
}
