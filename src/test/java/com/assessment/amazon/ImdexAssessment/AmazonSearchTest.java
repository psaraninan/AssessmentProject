package com.assessment.amazon.ImdexAssessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonSearchTest extends DriverInitialisationTest {

	AmazonSearch search;

	@BeforeTest
	public void bookSearch() throws InterruptedException {
		search = new AmazonSearch(driver);
		search.getSearchBar().click();
		search.getSearchBar().sendKeys(properties.getProperty("book"));
		Thread.sleep(2000);
		search.getSearchBar().sendKeys(Keys.ENTER);
	}

	@Test
	public void validatePrice() throws InterruptedException {
		SoftAssert assertion = new SoftAssert();
		for (WebElement book : search.getSearchResults()) {
			if (search.getBookName(book).getText().equalsIgnoreCase(properties.getProperty("book"))) {
				System.out.println(search.getBookName(book).getText());
				assertion.assertEquals(search.getBookPrice(book), properties.getProperty("price"));
				assertion.assertAll();
				break;
			}
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
