package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistPageTest extends TestBase{
	HomePage home;
	SearchPage search;
	ProductDetailsPage product;
	WishlistPage wishlist;
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";

	@Test(priority=16)
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
	}
	
	@Test(priority=17)
	public void addProductTowishlist() throws InterruptedException {
		product.clickAddToWishlistLink();
		product.clickWishlistNotification();
		wishlist = new WishlistPage(driver);
		assertTrue(wishlist.wishlistHeader.isDisplayed());
		assertEquals(wishlist.wishlistItem.getText(), searchItem);
	}
	
	@Test(priority=18)
	public void removeProductFromWishlist() 
	{
		wishlist.removeItemFromWishList();
		assertEquals(wishlist.wishlistStatus.getText(), "The wishlist is empty!");
	}
}
