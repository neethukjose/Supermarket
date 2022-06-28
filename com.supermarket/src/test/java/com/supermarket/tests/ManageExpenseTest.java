package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;

public class ManageExpenseTest extends BaseClass {

	ManageExpensePage manageexpensepage;
	LoginPage loginpage;

	@Test(groups = "smoke")
	public void verifyExpenseCategoryVisibility() {
		manageexpensepage = new ManageExpensePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String expectedclass = "nav-item";
		String actualclass = manageexpensepage.validateExpenseCategoryVisible();
		Assert.assertEquals(actualclass, expectedclass);
	}

	@Test
	public void verifyEditExpenseCategory() {
		manageexpensepage = new ManageExpensePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		boolean status=manageexpensepage.editExpenseCategory("TestEditNew");
		Assert.assertTrue(status);
	}

	@Test
	public void verifyDeleteExpenseCategory() {
		manageexpensepage = new ManageExpensePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		boolean status=manageexpensepage.deleteExpenseCategory("TestEditNew");
		Assert.assertTrue(status);
	}

}
