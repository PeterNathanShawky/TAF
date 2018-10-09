package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsPageTest extends TestBase{

	HomePage home;
	ContactUsPage contact;
	Faker faker = new Faker();
	
	String fullName = faker.name().fullName();
	String mail = faker.internet().emailAddress();
	String enquiry = "hellooo";
	
	@Test(priority=9)
	public void fillContactUsForm() throws InterruptedException
	{
		home = new HomePage(driver);
		home.clickContactUsLink();
		contact = new ContactUsPage(driver);
		contact.contactUsForm(fullName, mail, enquiry);
		assertEquals(contact.sucessEnquiry.getText(), "Your enquiry has been successfully sent to the store owner.");
	}
	
}
