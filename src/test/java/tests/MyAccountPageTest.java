package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class MyAccountPageTest extends TestBase{

	HomePage home;
	RegistrationPage reg;
	LoginPage log;
	MyAccountPage account;
	Faker faker = new Faker();
	
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String oldPassword = faker.number().digits(8).toString();	
	String newPassword =faker.number().digits(9).toString();
	
	
	@Test(priority=5)
	public void testRegistrationPage()
	{
		home  = new HomePage(driver);
		home.clickRegisterLink();
		reg = new RegistrationPage(driver);
		reg.registrationForm(fName, lName, email, oldPassword);
		assertEquals(reg.successMessage.getText(), "Your registration completed");
	}
	
	@Test(priority=6)
	public void testChangePassword() {
		reg.clickMyAccount();
		driver.findElement(By.linkText("Change password")).click();
		account = new MyAccountPage(driver);
		account.clickChangePassword();
		account.changePassForm(oldPassword, newPassword);
		assertEquals(account.chngSuccessMsg.getText(), "Password was changed");
	}
	
	@Test(priority=7)
	public void testClickingLogout()
	{
		reg.clickLogout();	
	}
	
	@Test(priority=8)
	public void testClickingLogin()
	{
		home.clickLoginLink();
	    log = new LoginPage(driver);
		log.loginForm(email, newPassword);
		assertEquals(home.logoutLink.getText(), "Log out");
		reg.clickLogout();
	}
}
