package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement registerLink;
	
	public void clickRegisterLink() {
		clickButton(registerLink);
	}
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	
	public void clickLoginLink() {
		clickButton(loginLink);
	}

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	public void clickContactUsLink() {
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	@FindBy(id="customerCurrency")
	WebElement currencyList;
	
	public void changeCurrency(String currency) {
		select = new Select(currencyList);
		select.selectByVisibleText(currency);
	}
	
	@FindBy(linkText="Computers")
	WebElement hoverMenu;
	
	@FindBy(linkText="Notebooks")
	WebElement hoverMenuItem;
	
	public void hoverMenu()
	{
		action.moveToElement(hoverMenu).moveToElement(hoverMenuItem)
		.click().build().perform();
	}
	
}
