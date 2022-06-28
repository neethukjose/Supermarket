package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PropHandler;


public class PushNotificationsPage {

	WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtilities generalutility;
	ExcelUtility excelutility;
	
	@FindBy(xpath = "//p[text()='Push Notifications']")
    private WebElement pushnotificationtab;
	@FindBy(xpath = "//input[@id='title']")
    private WebElement title;
	@FindBy(xpath = "//input[@id='description']")
    private WebElement description;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
    private WebElement sendbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement alertmessage;
	
	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean sendPushNotification(String expectedmessage) {
		excelutility = new ExcelUtility();
		generalutility= new GeneralUtilities(driver);
		pushnotificationtab.click();
		excelutility.setExcelFile("Push", "data");
	    title.sendKeys(excelutility.getCellData(1, 0));
		description.sendKeys(excelutility.getCellData(1, 1));
		sendbutton.click();
		 return generalutility.isExpectedTextPresent(alertmessage, expectedmessage);
		}
	

}
