package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddtoCartPage;
import pages.CheckoutPage;
import pages.OrderDetails;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;
import pages.SearchResult;

public class GuestCheckoutTest extends TestBase{
	
	RegistrationPage reg;
	SearchPage search;
	SearchResult result;
	ProductDetailsPage product;
	AddtoCartPage cart;
	CheckoutPage checkout;
	OrderDetails order;
	Faker faker = new Faker();
	
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.number().digits(8).toString();
	String address = faker.address().toString();
	String postalCode = faker.code().toString();
	String phoneNum = faker.phoneNumber().toString();
	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	
	@Test(priority=30)
	public void searchForItemAndAddItToCart() throws InterruptedException
	{
		driver.get("https://demo.nopcommerce.com/desktops");

		search = new SearchPage(driver);
		product = new ProductDetailsPage(driver);

		search.searchUsingautoSuggession(searchItem1);
		assertEquals(product.productBreadCrumb.getText(), searchItem);
	}

	@Test(priority=31)
	public void userCanAddToCart() throws InterruptedException
	{
		product.clickAddToCartBtn();
		product.clickCartNotification();
		Thread.sleep(2000);
		cart = new AddtoCartPage(driver);
		assertTrue(cart.toataPricelLabel.getText().contains("$3,600.00"));
	}
	
	@Test(priority=32)
	public void guestUserCanCheckout() throws InterruptedException
	{
		cart.clickCheckout();
		checkout = new CheckoutPage(driver);
		checkout.clickGuestcheckoutLink();
		checkout.guestcheckoutForm(fName, lName, email, "Cairo", address, postalCode, phoneNum);
		assertTrue(checkout.productName.isDisplayed());
		assertEquals(checkout.productName.getText(), searchItem);
		checkout.confirmOrder();
		assertTrue(checkout.successMsg.isDisplayed());
	}
	
	@Test(priority=33)
	public void downloadAndPrintInvoice() throws InterruptedException
	{
		checkout.clickOrderDetailsLink();
		order = new OrderDetails(driver);
		order.clickdownloadInvoiceBtn();
		Thread.sleep(2000);
		//Click Print button, then close the new opened window
		String current = driver.getWindowHandle();
		driver.findElement(By.cssSelector("a.button-2.print-order-button")).click();
		for (String zz: driver.getWindowHandles()) {
			System.out.println(driver.switchTo().window(zz).getCurrentUrl());
			String url =driver.switchTo().window(zz).getCurrentUrl();
			if(url.contains("print"))
			{
				driver.close();
				break;
			}
		}
		driver.switchTo().window(current);
	}
}
