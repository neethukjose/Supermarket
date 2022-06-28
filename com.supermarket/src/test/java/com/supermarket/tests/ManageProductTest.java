package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

public class ManageProductTest extends BaseClass {
	
	ManageProductPage manageproductpage;
	LoginPage loginpage;
	
	@Test(groups="regression")
	public void validateNewButtonColor() {
		manageproductpage=  new ManageProductPage(driver);
		loginpage= new LoginPage(driver);
		loginpage.loginUtility();
		String expectedcolor="rgba(220, 53, 69, 1)";
		String actualcolor=manageproductpage.newButtonColorVerification();
		Assert.assertEquals(actualcolor, expectedcolor);
	}
	@Test(groups="smoke")
	public void verifyProductCreation() throws InterruptedException  {
		manageproductpage=  new ManageProductPage(driver);
		loginpage= new LoginPage(driver);
		loginpage.loginUtility();
		boolean status=manageproductpage.productCreation("value2");
		Assert.assertTrue(status);
	}
	@Test(groups="regression")
	public void verifyProductDeletion() {
		manageproductpage=  new ManageProductPage(driver);
		loginpage= new LoginPage(driver);
		loginpage.loginUtility();
		boolean status=manageproductpage.deleteProduct("abc");
		Assert.assertTrue(status);
	}

}
