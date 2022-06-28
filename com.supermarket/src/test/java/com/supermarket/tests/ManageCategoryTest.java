package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCategoryPage;

public class ManageCategoryTest extends BaseClass {
	
	ManageCategoryPage managecategorypage;
	LoginPage loginpage;
	
	@Test
	public void verifyVisibilityofSubMenu() {
		loginpage= new LoginPage(driver);
		managecategorypage= new ManageCategoryPage(driver);
		loginpage.loginUtility();
		String expectedValue="nav-item has-treeview menu-open";
		String actualValue=managecategorypage.subMenuIsPresent();
		Assert.assertEquals(actualValue, expectedValue);
		
	}
	
	@Test(groups="smoke")
	public void verifyCreateCategory() {
		loginpage= new LoginPage(driver);
		managecategorypage= new ManageCategoryPage(driver);
		loginpage.loginUtility();
		boolean status=managecategorypage.addCategory();
	    Assert.assertTrue(status);
		
	}
}
