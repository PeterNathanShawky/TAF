package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxtbox;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement itemLink;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	public void searchUsingSearchBtn(String searchItem)
	{
		fillTextField(searchTxtbox, searchItem);
		clickButton(searchBtn);
	}
	
	public void clickResultItem()
	{
		clickButton(itemLink);
	}
	
	public void searchUsingautoSuggession(String searchItem1) throws InterruptedException
	{
		fillTextField(searchTxtbox, searchItem1);
		Thread.sleep(3000);
		productList.get(0).click();
	}

}
