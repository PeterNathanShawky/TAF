package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage home;
	SearchPage search;
	ProductDetailsPage product;
	
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	String currency = "Euro";
	String currency2 = "US Dollar";

	@Test(priority=23)
	public void userCanChangecurrency()
	{
		home = new HomePage(driver);
		home.changeCurrency(currency);
	}

	@Test(priority=24)
	public void searchForItemUsingAutoSuggession()
	{
		search = new SearchPage(driver);
		product = new ProductDetailsPage(driver);
		try {
			search.searchUsingautoSuggession(searchItem1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(product.productBreadCrumb.getText(), searchItem);
		Assert.assertTrue(product.currencyLabel.getText().contains("Ђ") );
	}
	
	@Test(priority=25)
	public void userCanChangecurrencyAgain()
	{
		home = new HomePage(driver);
		home.changeCurrency(currency2);
	}
}
