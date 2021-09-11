package com.amazon.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.amazon.reusableComponents.Methods;
import com.amazon.uistore.SearchUI;

public class Search extends Methods{
	
	public void loginpage(WebDriver driver) throws IOException
	{
		Methods.clicksearch(SearchUI.searchpro,driver);
	}
	
	public void passproducts(WebDriver driver,String name)
	{
	
		Methods.passproduct(SearchUI.searchpro, driver, name);
		
	}
}
