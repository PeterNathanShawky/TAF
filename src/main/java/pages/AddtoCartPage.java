package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtoCartPage extends PageBase{

	public AddtoCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="removefromcart")
	WebElement removeProductCheckbox;
	
	@FindBy(css="input.qty-input")
	WebElement quantityTxtBox;
	
	@FindBy(css="span.product-subtotal")
	public WebElement toataPricelLabel;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/input[1]")
	WebElement updateCartBtn;
	
	@FindBy(css="div.no-data")
	WebElement noDataLabel;
	
	public void changeQuantity(String quantity)
	{
		clearTextField(quantityTxtBox);
		fillTextField(quantityTxtBox, quantity);
		clickButton(updateCartBtn);
	}
	
	public void clearCart()
	{
		clickButton(removeProductCheckbox);
		clickButton(updateCartBtn);
	}
	
	@FindBy(id="termsofservice")
	WebElement termsOfServiceCheckbox;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public void clickCheckout()
	{
		clickButton(termsOfServiceCheckbox);
		clickButton(checkoutBtn);
	}
	
}
