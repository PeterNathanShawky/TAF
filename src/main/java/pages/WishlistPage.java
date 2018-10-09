package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="h1")
	public WebElement wishlistHeader;
	
	@FindBy(css="a.product-name")
	public WebElement wishlistItem;
	
	@FindBy(name="removefromcart")
	WebElement removeItemCheckbox;
	
	@FindBy(css="input.button-2.update-wishlist-button")
	WebElement updateWishlist;
	
	@FindBy(css="div.no-data")
	public WebElement wishlistStatus;
	
	public void removeItemFromWishList()
	{
		clickButton(removeItemCheckbox);
		clickButton(updateWishlist);
	}
}
