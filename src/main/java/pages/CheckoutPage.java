package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestCheckoutBtn;

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fNameTxtbox;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lNameTxtbox;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxtbox;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryDropdownList;

	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxtbox;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1Txtbox;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxtbox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumTxtbox;

	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;

	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRadiobtn;

	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueShippingBtn;

	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePaymentBtn;

	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continuePaymentInfoBtn;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement productName;

	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement successMsg;
	
	@FindBy(linkText="Click here for order details.")
	WebElement orderdetailsLink;

	@FindBy(css="input.button-1.order-completed-continue-button")
	WebElement continueOrdercompletionBtn;

	public void registeredUsercheckoutForm(String city,
			String address, String postalCode, String phoneNum) throws InterruptedException
	{
		/*select = new Select(countryDropdownList);
		select.selectByVisibleText("Egypt");
		fillTextField(cityTxtbox, city);
		fillTextField(address1Txtbox, address);
		fillTextField(postalCodeTxtbox, postalCode);
		fillTextField(phoneNumTxtbox, phoneNum);*/
		clickButton(continueBtn);
		Thread.sleep(2000);
		clickButton(shippingMethodRadiobtn);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentInfoBtn);
		Thread.sleep(2000);
	}

	public void confirmOrder() throws InterruptedException
	{
		clickButton(confirmBtn);
		Thread.sleep(1000);	
	}

	public void clickOrderDetailsLink()
	{
		clickButton(orderdetailsLink);
	}
	
	public void clickGuestcheckoutLink()
	{
		clickButton(guestCheckoutBtn);
	}
	
	public void guestcheckoutForm(String fName, String lName, String mail, String city,
			String address, String postalCode, String phoneNum) throws InterruptedException
	{
		fillTextField(fNameTxtbox, fName);
		fillTextField(lNameTxtbox, lName);
		fillTextField(emailTxtbox, mail);
		select = new Select(countryDropdownList);
		select.selectByVisibleText("Egypt");
		fillTextField(cityTxtbox, city);
		fillTextField(address1Txtbox, address);
		fillTextField(postalCodeTxtbox, postalCode);
		fillTextField(phoneNumTxtbox, phoneNum);
		clickButton(continueBtn);
		Thread.sleep(2000);
		clickButton(shippingMethodRadiobtn);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentInfoBtn);
		Thread.sleep(2000);
	}
}
