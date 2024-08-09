package com.nopCommerce.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerce.Pages.SearchPage;
import com.nopCommerce.TestBase.TestBase;

public class SearchValidProduct extends TestBase {
	public WebDriver driver;
	public SearchPage searchPage;

	public SearchValidProduct() throws Exception {
		super();
	}

	@BeforeMethod
	public void checkoutSetup() {
		driver = openingApplicationWithAnyBrowser(prop.getProperty("browser"));
		searchPage = new SearchPage(driver);

	}

	@Test(priority = 1)
	public void searchAndNavigateToValidProduct() {
		searchPage.enterValidProductName(dataProp.getProperty("validProduct"));
		searchPage.clickOnSearchButton();
// this is the first  option to assert the presence of the product is displayed(more direct)
		Assert.assertTrue(searchPage.verifyValidProductPresence());
// this is another option to assert the presence of the product
		// String actualProductName = "Apple MacBook Pro 13-inch";
		// String expectedProductName = driver.findElement(By.linkText("Apple MacBook
		// Pro 13-inch")).getText();
		// assertTrue(actualProductName.contains(expectedProductName), "Product name
		// does not match!");
		// searchPage.clickOnProductToAccessDeatils();
	}

	public void tearDown() {
		driver.quit();
	}
}
