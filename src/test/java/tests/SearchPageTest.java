package tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.SearchResult;

public class SearchPageTest extends TestBase{

	SearchPage search;
	SearchResult result;

	String searchItem ="Apple MacBook Pro 13-inch";
	String searchItem1 ="Apple Mac";
	
	@Test(enabled=false)
	public void searchForItemUsingSearchBtn()
	{
		search = new SearchPage(driver);
		search.searchUsingSearchBtn(searchItem);
		search.clickResultItem();
		result = new SearchResult(driver);
		assertEquals(result.itemBreadcrumb.getText(), searchItem);
	}
	
	@Test(priority=15)
	public void searchForItemUsingAutoSuggession()
	{
		search = new SearchPage(driver);
		try {
			search.searchUsingautoSuggession(searchItem1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = new SearchResult(driver);
		assertEquals(result.itemBreadcrumb.getText(), searchItem);
	}
	
}
