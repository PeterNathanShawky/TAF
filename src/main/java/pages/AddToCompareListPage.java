package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCompareListPage extends PageBase{

	public AddToCompareListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="table.compare-products-table")
	WebElement productsTable;

	@FindBy(tagName="tr")
	List<WebElement> allRows;

	@FindBy(tagName="td")
	List<WebElement> allColumns;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement firstProductName;
	
	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement secondProductName;
	
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;

	@FindBy(css="div.no-data")
	public WebElement noDataLabel;

	public void clickClearBtn() {
		clickButton(clearListBtn);
	}

	public void printTableContents()
	{
		for (WebElement row : allRows) {
			System.out.println(row.getText() + "\t");
			for (WebElement col : allColumns) {
				System.out.println(col.getText() + "\t");
			}
		}
	}


}
