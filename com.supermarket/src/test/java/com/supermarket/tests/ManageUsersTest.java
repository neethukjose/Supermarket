package com.supermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends BaseClass {

	ManageUsersPage manageuserspage;
	LoginPage loginpage;

	@Test(priority=1,groups="regression")
	public void validateManageUsersTitle() {
		manageuserspage = new ManageUsersPage(driver);
		boolean status = manageuserspage.navigateToManageUsers();
		Assert.assertTrue(status);
	}

	@Test(groups="smoke")
	public void validateUserActivation() {
		manageuserspage = new ManageUsersPage(driver);
		String expectedMessage="User Status Changed Successfully";
		boolean status=manageuserspage.activateUser(expectedMessage);
		Assert.assertTrue(status);
	}
	
	@Test
	public void validateDeleteUser() {
		manageuserspage = new ManageUsersPage(driver);
		String expectedMessage="User Informations Deleted Successfully";
		boolean status=manageuserspage.deleteUser(expectedMessage);
		Assert.assertTrue(status);
	}
	
	@Test(groups="smoke")
	public void verifyDeactivatesUser() {
		manageuserspage = new ManageUsersPage(driver);
		loginpage= new LoginPage(driver);
		loginpage.loginUtility();
		manageuserspage.clickOnDeactivateButton("sumesh");
		
		
	}
	
}
