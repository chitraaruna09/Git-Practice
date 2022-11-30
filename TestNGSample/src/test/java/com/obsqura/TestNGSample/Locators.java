package com.obsqura.TestNGSample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends Base {

	@Test(description = "Locating by ID amazon search")
	public void locatingByID() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 12");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14 pro max case");

		Thread.sleep(5000);
	}

	@Test(description = "Locating By Class Amazon")
	public void locatingByClassAmazon() {
		driver.findElement(By.className("hm-icon-label")).click();
	}

	@Test(description = "Locating by Class using obsqura site")
	public void locatingByClass() {
		driver.findElement(By.className("top-logo"));
	}

	@Test(description = "Locating by Class Name using Selenium Dev Site")
	public void locatingClassName() throws InterruptedException {
		driver.findElement(By.className("mt-2")).click();
		Thread.sleep(5000);
	}

	@Test(description = "Locating by Name amazone site")
	public void locateByName() {
		driver.findElement(By.name("dropdown-selection"));
	}

	@Test(description = "Locating CSS Selector by ID")
	public void locateCSSSelectorID() {
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone 14 pro max case");
	}

	@Test(description = "Locating CSS Selector by Tag and ID")
	public void locateCSSSelectorTagAndID() throws InterruptedException {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("iPhone 12");
		Thread.sleep(5000);
	}

	@Test(description = "Locating CSS Selector by Class")
	public void locateCSSSelectorClass() {
		driver.findElement(By.cssSelector(".nav-search-field "));
	}

	@Test(description = "Locating CSS Selector by Tag and Class")
	public void locateCSSSelectorTagAndClass() {
		driver.findElement(By.cssSelector("span.nav-line-1 "));
	}
	@Test(description = "Locating CSS Selector by Tag and Attribute")
	public void locateCSSSelectorTagAndAttribute() {
		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
	}
	@Test(description = "Locating CSS Selector by Tag and Inner Text")
	public void locateCSSSelectorInnerText() {
		driver.findElement(By.cssSelector("span:contains['Professional tools']")); // using CSS Locators, contains not working
	}
	
	@Test(description = "Locating  by XPath using ID")
	public void locateXPath() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	}
	@Test(description = "Locating XPath using Text")
	public void locateXPathText() {
		driver.findElement(By.xpath("//span[text()='All']"));
	}
	@Test(description = "Locating XPath using Contains")
	public void locateXPathContains() {
		driver.findElement(By.xpath("//input[contains(@name,'field-keywords')]")).sendKeys("iphone 12 pro");
	}
	@Test(description = "Locating XPath using OR & AND")
	public void locateXPathOrAnd() {
		driver.findElement(By.xpath("//*[@id='searchDropdownBox' or @value='search-alias=aps']"));
	}
	@Test(description = "Locating XPath using starts-with")
	public void locateXPathStartsWith() {
		driver.findElement(By.xpath("//li[starts-with(@class,'nav')]")).click();
	}
	@Test(description = "Locating XPath using Link")
	public void locateXPathUsingLink() {
		driver.findElement(By.xpath("//a[text()='Amazon App Download']"));
	}
	@Test(description = "Locating XPath using child current node")
	public void locateXPathChildCurrentNode() {
		driver.findElement(By.xpath("//div[@class = 'nav-sprite']//child::a[2]")).click();
	}
	@Test(description = "Locating XPath using Self Axes or current node")
	public void locateXPathSelfAxes() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']//self::input"));
	}
	@Test(description = "Locating XPath using Descendants")
	public void locateXPathDescendants() {
		driver.findElement(By.xpath("//a[@id='nav-orders']//descendant::span[2]")).click();
	}
	
	@Test(description = "Locating elements using Link Text")
	public void locateLinkText() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
	}
	@Test(description = "Locating elements using PartialLink Text")
	public void locatePartialLinkText() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.partialLinkText("Simple Form")).click();
	}
	@Test(description ="Axes Using Contains")
	public void locateAxesUsingContains() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.xpath("//input[contains(@id,'single-input-field')]")).sendKeys("Hi, Welcome");
		driver.findElement(By.xpath("//input[contains(@id,'single-input-field')]")).click();
	}
	@Test(description ="Axes Using OR")
	public void locateAxesUsingOR() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.xpath("//input[@id='single-input-field' or @placeholder='Message']")).sendKeys("Selenium Automation");
		driver.findElement(By.xpath("//input[@id='single-input-field' or @placeholder='Message']")).click();
	}
	@Test(description ="Axes Using AND")
	public void locateAxesUsingAND() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.findElement(By.xpath("//input[@class='form-control' and @id='single-input-field']")).sendKeys("Automating the Web Element");
		driver.findElement(By.xpath("//input[@class='form-control' and @id='single-input-field']")).click();
	}
}
