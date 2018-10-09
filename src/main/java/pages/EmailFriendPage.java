package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FriendEmail")
	WebElement frndEmail;
	
	@FindBy(id="PersonalMessage")
	WebElement message;
	
	@FindBy(css="input.button-1.send-email-a-friend-button")
	WebElement sendEmialBtn;
	
	@FindBy(css="div.result")
	public WebElement sucessMsg;
	
	public void emailFriendform(String frndMail, String msg) {
		fillTextField(frndEmail, frndMail);
		fillTextField(message, msg);
		clickButton(sendEmialBtn);
	}
	
}
