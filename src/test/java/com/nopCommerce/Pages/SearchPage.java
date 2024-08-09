package com.nopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='small-searchterms']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

//@FindBy(linkText = "Apple MacBook Pro 13-inch")
//private WebElement appleProductDetails;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	private WebElement validProduct;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//public SearchPage clickOnBooksHomePageIcon() {
//	searchField.click();
//	return new SearchPage(driver);
//}
	public void enterValidProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
	}

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

//public SearchPage clickOnProductToAccessDeatils() {
//	appleProductDetails.click();
//	return new SearchPage(driver);
//}
	public boolean verifyValidProductPresence() {
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
	}

}
