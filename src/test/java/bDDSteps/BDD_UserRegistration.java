package bDDSteps;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import tests.TestBase;

public class BDD_UserRegistration extends TestBase{

	HomePage home;
	RegistrationPage reg;
	Faker faker = new Faker();

	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8).toString();

	@Given("^The user is in the home page\\.$")
	public void the_user_is_in_the_home_page() {
		home = new HomePage(driver);
		home.clickRegisterLink();
	}

	@When("^I click on the register  link\\.$")
	public void i_click_on_the_register_link() {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("^I entered the user data\\.$")
	public void i_entered_the_user_data() {
		reg = new RegistrationPage(driver);
		reg.registrationForm(fName, lName, email, password);
	}

	@Then("^The registration page is displayed successfully\\.$")
	public void the_registration_page_is_displayed_successfully() {
		reg.clickLogout();
	}
}
