package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddtoCartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCartPageTest extends TestBase{

	HomePage home;
	SearchPage search;
	ProductDetailsPage product;
	AddtoCartPage cart;
	
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	String quantity ="3";

	@Test(priority=26)
	public void searchForItemAndAddItToCart() throws InterruptedException
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
	}

	@Test(priority=27)
	public void userCanAddToCart() throws InterruptedException
	{
		product.clickAddToCartBtn();
		product.clickCartNotification();
		Thread.sleep(2000);
		cart = new AddtoCartPage(driver);
		assertTrue(cart.toataPricelLabel.getText().contains("$3,600.00"));
	}
	
	@Test(priority=28)
	public void userCanChangeQuantity()
	{
		cart.changeQuantity(quantity);
	}
	
	@Test(priority=29)
	public void userCanClearCart()
	{
		cart.clearCart();
	}
}