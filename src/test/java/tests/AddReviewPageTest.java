package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;
import pages.SearchResult;

public class AddReviewPageTest extends TestBase{

	HomePage home;
	RegistrationPage reg;
	SearchPage search;
	SearchResult result;
	ProductDetailsPage product;
	AddReviewPage review;
	Faker faker = new Faker();
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8).toString();
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	String reviewTitle="MY Review";
	String reviewText = "The Product is good";

	@Test(priority=19)
	public void testRegistrationPage()
	{
		home  = new HomePage(driver);
		home.clickRegisterLink();
		reg = new RegistrationPage(driver);
		reg.registrationForm(fName, lName, email, password);
		assertEquals(reg.successMessage.getText(), "Your registration completed");
	}

	@Test(priority=20)
	public void searchForItem() throws InterruptedException
	{
		search = new SearchPage(driver);
		product = new ProductDetailsPage(driver);
		search.searchUsingautoSuggession(searchItem1);
		assertEquals(product.productBreadCrumb.getText(), searchItem);
	}

	@Test(priority=21)
	public void addProductReview()
	{
		product.clickAddReviewLink();
		review = new AddReviewPage(driver);
		review.addReviewForm(reviewTitle, reviewText);
		assertEquals(review.reviewSuccessMsg.getText(),"Product review is successfully added.");	
	}

	@Test(priority=22)
	public void testClickingLogout()
	{
		reg.clickLogout();	
	}
}
