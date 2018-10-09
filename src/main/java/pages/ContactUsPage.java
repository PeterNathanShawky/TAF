package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement nameTxtBox;
	
	@FindBy(id="Email")
	WebElement mailTxtBox;
	
	@FindBy(id="Enquiry")
	WebElement enquiryTxtBox;
	
	@FindBy(css="input.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement sucessEnquiry;
	
	public void contactUsForm(String fullName, String mail, String enquiry )
	{
		fillTextField(nameTxtBox, fullName);
		fillTextField(mailTxtBox, mail);
		fillTextField(enquiryTxtBox, enquiry);
		clickButton(submitBtn);
	}

}
