package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productBreadCrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFrndBtn;
	
	public void clickemailFrndBtn() {
		clickButton(emailFrndBtn);
	}
	
	@FindBy(css="span.price-value-4")
	public WebElement currencyLabel;
	
	@FindBy(xpath="//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement addReviewLink;
	
	public void clickAddReviewLink() {
		clickButton(addReviewLink);
	}
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistLink;
	
	public void clickAddToWishlistLink() {
		clickButton(addToWishlistLink);
	}
	
	@FindBy(linkText="wishlist")
	WebElement wishListNotification;
	
	public void clickWishlistNotification() throws InterruptedException {
		Thread.sleep(2000);
		clickButton(wishListNotification);
	}
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareListLink;
	
	public void clickAddToCompareListLink() {
		clickButton(addToCompareListLink);
	}
	
	@FindBy(linkText="product comparison")
	WebElement comparisonNotification;
	
	public void clickComparisonNotification() {
		clickButton(comparisonNotification);
	}
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void clickAddToCartBtn() {
		clickButton(addToCartBtn);
	}
	
	@FindBy(linkText="shopping cart")
	WebElement cartNotification;
	
	public void clickCartNotification() {
		clickButton(cartNotification);
	}
	
	
	
	
	

}
