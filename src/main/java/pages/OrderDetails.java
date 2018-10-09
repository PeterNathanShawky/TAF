package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderDetails extends PageBase{

	public OrderDetails(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a.button-2.print-order-button")
	WebElement printInvoiceBtn;
	
	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement downloadInvoiceBtn;

	public void clickdownloadInvoiceBtn() {
		clickButton(downloadInvoiceBtn);
	}
}
