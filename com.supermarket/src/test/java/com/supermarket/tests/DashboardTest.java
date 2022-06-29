package com.supermarket.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.DashboardPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;
import com.supermarket.utilities.ResponseCodeGetter;
import com.supermarket.utilities.ScreenShot;

public class DashboardTest extends BaseClass {

	DashboardPage dashboardpage;
	LoginPage loginpage;
	ResponseCodeGetter responsecode;

	@Test(priority=2,groups="regression")
	public void valiidateDashboardTiles() {
		dashboardpage = new DashboardPage(driver);
		boolean status = dashboardpage.validateDashboardSections();
		Assert.assertTrue(status);
	}

	@Test(groups="regression")
	public void validateDashboardTitle() {
		dashboardpage = new DashboardPage(driver);
		String expectedTitle = "7rmart supermarket";
		String actualTitle = dashboardpage.validateDashboardTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(groups="regression")
	public void  verifyIsProfileBroken() throws MalformedURLException, IOException {
		String url="https://groceryapp.uniqassosiates.com/admin/list-admin";
		dashboardpage = new DashboardPage(driver);
		loginpage= new LoginPage(driver);
		loginpage.loginUtility();
		responsecode= new ResponseCodeGetter();
		int response=responsecode.getResponseCode(url);
		System.out.println(response);
		if(response>400) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
