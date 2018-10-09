package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase{

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextTxtBox;
	
	@FindBy(id="addproductrating_4")
	WebElement rateNum4;
	
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css="div.result")
	public WebElement reviewSuccessMsg;
	
	public void addReviewForm(String reviewtitle, String reviewText)
	{
		fillTextField(reviewTitleTxtBox, reviewtitle);
		fillTextField(reviewTextTxtBox, reviewText);
		clickButton(rateNum4);
		clickButton(submitReviewBtn);
	}
}
