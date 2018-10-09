package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToCompareListPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCompareListTest extends TestBase{
	HomePage home;
	SearchPage search;
	ProductDetailsPage product;
	AddToCompareListPage compare;
	
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	String secondSearchItem = "Asus N551JK-XO076H Laptop";
	String secondSearchItem1 = "Asus";


	@Test(priority=40)
	public void searchForItemsAndAddThemToCompareList() throws InterruptedException
	{	
		search = new SearchPage(driver);
		product = new ProductDetailsPage(driver);

		search.searchUsingautoSuggession(searchItem1);
		assertEquals(product.productBreadCrumb.getText(), searchItem);
		product.clickAddToCompareListLink();

		search.searchUsingautoSuggession(secondSearchItem1);
		assertEquals(product.productBreadCrumb.getText(), secondSearchItem);
		Thread.sleep(2000);
		product.clickAddToCompareListLink();

		product.clickComparisonNotification();
		
		compare = new AddToCompareListPage(driver);
		assertTrue(compare.firstProductName.isDisplayed());
		assertTrue(compare.secondProductName.isDisplayed());
		compare.printTableContents();
	}

	@Test(priority=41)
	public void clearCompareListItems()
	{		
		compare.clickClearBtn();
		assertEquals(compare.noDataLabel.getText(), "You have no items to compare.");
		
	}
}
