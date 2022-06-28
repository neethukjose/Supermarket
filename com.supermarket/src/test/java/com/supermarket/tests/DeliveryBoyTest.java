package com.supermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;

public class DeliveryBoyTest extends BaseClass {

	DeliveryBoyPage deliveryboypage;
	LoginPage loginpage;
	SoftAssert softassert;

	@Test(groups="regression")
	public void validateManageDeliveryBoyNavigation() {
		softassert = new SoftAssert();
		loginpage = new LoginPage(driver);
		deliveryboypage = new DeliveryBoyPage(driver);
		loginpage.loginUtility();
		String expectedTitle = "List Delivery Boy | 7rmart supermarket";
		String actualTitle = deliveryboypage.navigateDeliveryBoyPageValidation();
		softassert.assertEquals(actualTitle, expectedTitle);
		softassert.assertAll();
	}

	@Test(dataProvider = "deliveryBoy", dataProviderClass = DataProviders.class,groups="smoke")
	public void validateDeliveryBoyCreate(String name,  String emailid,String phoneNo, String userName,String password) {
		loginpage = new LoginPage(driver);
		deliveryboypage = new DeliveryBoyPage(driver);
		loginpage.loginUtility();
		boolean status=deliveryboypage.createNewDeliveryBoy(name,emailid, phoneNo, userName, password);
		Assert.assertTrue(status);
		

	}

}
