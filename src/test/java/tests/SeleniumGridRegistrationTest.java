package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class SeleniumGridRegistrationTest extends SeleniumGridTestBase{

	HomePage home;
	RegistrationPage reg;
	LoginPage log;
	Faker faker = new Faker();
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8).toString();
	
	@Test(priority=1)
	public void testRegistrationPage() throws InterruptedException
	{
		home  = new HomePage(getDriver());
		home.clickRegisterLink();
		reg = new RegistrationPage(getDriver());
		reg.registrationForm(fName, lName, email, password);
		assertEquals(reg.successMessage.getText(), "Your registration completed");
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void testClickingLogout()
	{
		reg.clickLogout();	
	}
	
	@Test(priority=3)
	public void testClickingLogin()
	{
		home.clickLoginLink();
	    log = new LoginPage(getDriver());
		log.loginForm(email, password);
		assertEquals(home.logoutLink.getText(), "Log out");
	}
	
	@Test(priority=4)
	public void testClickingLogoutAgain()
	{
		reg.clickLogout();	
	}
}
