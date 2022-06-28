package com.supermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.DashboardPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.ScreenShot;



public class LoginTest extends BaseClass {

	LoginPage loginpage;

	@Test(priority = 1,groups="smoke")
	public void verifyValidLogin() {

		loginpage = new LoginPage(driver);
		loginpage.loginUtility("admin", "admin");
		String expectedText = "Admin";
		boolean status = loginpage.login_Successfull_Validation(expectedText);
		Assert.assertTrue(status);
	}

	@Test(groups="regression")
	public void verifyLoginInfoMessage() {
		loginpage = new LoginPage(driver);
		String expectedInfoMessage = "Sign in to start your session";
		boolean status = loginpage.isLoginInfoDisplayed(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(groups="regression")
	public void verifyInvalidUsername() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility("abc", "admin");
		String expectedErrorMessage = "Invalid Username/Password";
		boolean status = loginpage.isInvalidCredentialsMessageDisplayed(expectedErrorMessage);
		Assert.assertTrue(status);
	}

	@Test(groups="regression")
	public void verifyRemembermeisDisplayed() {
		loginpage = new LoginPage(driver);
		boolean status = loginpage.isRemember_Meisdisplayed();
		Assert.assertTrue(status);
	}

	@Test(groups= {"smoke","regression"})
	public void verifyRemembermeisSelected() {
		loginpage = new LoginPage(driver);
		boolean status = loginpage.isRemember_meIsSelected();
		Assert.assertTrue(status);
	}

	@Test
	public void excelTest() {
		ExcelUtility excel = new ExcelUtility();
		excel.setExcelFile("UserDetails", "User");
		System.out.println(excel.getCellData(1, 0));
		excel.setExcelFile("DeliveryBoyData", "PalaLocation");
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.println(excel.getCellData(i, j));
			}
		}
	}

	@Test(dataProvider="loginCredentials",dataProviderClass=DataProviders.class,groups="regression")
    public void verifyInvalidLoginExcelandDataprovider(String username1,String password1) {

		loginpage = new LoginPage(driver);
		loginpage.loginUtility(username1, password1);
		String expectedErrorMessage = "Invalid Username/Password";
		boolean status = loginpage.isInvalidCredentialsMessageDisplayed(expectedErrorMessage);
		Assert.assertTrue(status);

	}

	@Test(dataProvider="invalidLogin",dataProviderClass=DataProviders.class,groups="smoke")
    public void verifyInvalidLoginDataProvider(String username,String password) {

		loginpage = new LoginPage(driver);
		loginpage.loginUtility(username, password);
		String expectedErrorMessage = "Invalid Username/Password";
		boolean status = loginpage.isInvalidCredentialsMessageDisplayed(expectedErrorMessage);
		Assert.assertTrue(status);

	}
	
	
}
