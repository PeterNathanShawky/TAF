package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;
import pages.SearchResult;

public class EmailFriendPageTest extends TestBase{

	HomePage home;
	RegistrationPage reg;
	SearchPage search;
	SearchResult result;
	ProductDetailsPage proDetails;
	EmailFriendPage emailfriend;
	Faker faker = new Faker();
	
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8).toString();
	String searchItem ="Apple MacBook Pro 13-inch";
	String friendMail = "hhh@mail.com";
	String friendMessage = "Hello my Friend";

	@Test(priority=11)
	public void testRegistrationPage() throws InterruptedException
	{
		home  = new HomePage(driver);
		home.clickRegisterLink();
		reg = new RegistrationPage(driver);
		Thread.sleep(2000);
		reg.registrationForm(fName, lName, email, password);
		assertEquals(reg.successMessage.getText(), "Your registration completed");
	}

	@Test(priority=12)
	public void searchForItem() throws InterruptedException
	{
		search = new SearchPage(driver);
		search.searchUsingautoSuggession(searchItem);
		proDetails  = new ProductDetailsPage(driver);
		assertEquals(proDetails.productBreadCrumb.getText(), searchItem);
	}

	@Test(priority=13)
	public void emailAFriend()
	{
		proDetails.clickemailFrndBtn();
		emailfriend = new EmailFriendPage(driver);
		emailfriend.emailFriendform(friendMail, friendMessage);
		assertEquals(emailfriend.sucessMsg.getText(), "Your message has been sent.");
	}
	
	@Test(priority=14)
	public void testClickingLogout()
	{
		reg.clickLogout();	
	}
}
