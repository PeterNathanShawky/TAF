package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Email")
	WebElement emailTextBox;
	
	@FindBy(id="Password")
	WebElement passTextBox;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBtn;
	
	public void loginForm(String mail, String pass)
	{
		fillTextField(emailTextBox, mail);
		fillTextField(passTextBox, pass);
		clickButton(loginBtn);
	}

}
