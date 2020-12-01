package com.assessment.amazon.ImdexAssessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearch {
	WebDriver driver;
	By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchResult = By.xpath("//div[@class='a-section a-spacing-medium']");

	public AmazonSearch(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}

	public List<WebElement> getSearchResults() {
		return driver.findElements(searchResult);
	}

	public WebElement getBookName(WebElement book) {
		return (book.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")));
	}

	public String getBookPrice(WebElement book) {
		WebElement bookPriceWhole = book.findElement(By.xpath("//span[@class='a-price-whole']"));
		WebElement bookPriceFraction = book.findElement(By.xpath("//span[@class='a-price-fraction']"));
		String price = bookPriceWhole.getText().concat(".").concat(bookPriceFraction.getText());
		System.out.println("Price:" +price);
		return price;
	}
}
