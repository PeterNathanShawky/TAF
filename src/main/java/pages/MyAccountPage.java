package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="Change password")
	WebElement chngPassLink;

	@FindBy(id="OldPassword")
	WebElement oldPassTxtBox;

	@FindBy(id="NewPassword")
	WebElement newPassTxtBox;

	@FindBy(id="ConfirmNewPassword")
	WebElement confPassTxtBox;

	@FindBy(css="input.button-1.change-password-button")
	WebElement chngPassBtn;
	
	@FindBy(css="div.result")
	public WebElement chngSuccessMsg;
	
	public void clickChangePassword() {
		clickButton(chngPassLink);
	}
	
	public void changePassForm(String oldPass, String newPass)
	{
		fillTextField(oldPassTxtBox, oldPass);
		fillTextField(newPassTxtBox, newPass);
		fillTextField(confPassTxtBox, newPass);
		clickButton(chngPassBtn);
	}
}
