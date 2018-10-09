package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends PageBase{

	public SearchResult(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement itemBreadcrumb;
	
}
