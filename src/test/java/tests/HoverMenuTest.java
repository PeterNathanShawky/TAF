package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase{

	HomePage home;
	@Test(priority=10)
	public void userCanHoverMenu()
	{
		home = new HomePage(driver);
		home.hoverMenu();
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		driver.navigate().back();
	}
}
