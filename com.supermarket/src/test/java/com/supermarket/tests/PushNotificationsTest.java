package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;

public class PushNotificationsTest extends BaseClass {

	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	
	@Test(groups="smoke")
	public void verifySendPushNotification() {
		loginpage= new LoginPage(driver);
		pushnotificationpage= new PushNotificationsPage(driver);
		loginpage.loginUtility();
		boolean status=pushnotificationpage.sendPushNotification("Message send successfully");
		Assert.assertTrue(status);
	}
}
