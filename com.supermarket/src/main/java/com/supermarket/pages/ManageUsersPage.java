package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageUsersPage {

	public WebDriver driver;
	LoginPage loginpage;
	GeneralUtilities generalutility;
	PageUtility pageutility;
	WaitUtility wait;

	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageusersTab;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement listusersTitle;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchbutton;
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement selectdropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchbutton2;
	@FindBy(xpath = "//tbody//tr[1]//td[6]//a[1]")
	private WebElement inactiveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertText;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	private WebElement deleteButton;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean navigateToManageUsers() {
		loginpage = new LoginPage(driver);
		generalutility = new GeneralUtilities(driver);
		loginpage.loginUtility();
		manageusersTab.click();
		boolean status = generalutility.isExpectedTextPresent(listusersTitle, "List Users");
		return status;
	}

	public void searchUser() {
		loginpage = new LoginPage(driver);
		pageutility = new PageUtility(driver);
		loginpage.loginUtility();
		manageusersTab.click();
		searchbutton.click();
		pageutility.select_ByValue(selectdropdown, "inactive");
		searchbutton2.click();
	}

	public boolean activateUser(String expectedMessage) {
		wait = new WaitUtility(driver);
		generalutility = new GeneralUtilities(driver);
		pageutility = new PageUtility(driver);
		searchUser();
		pageutility.scroll_into_View(inactiveButton);
		wait.waitForElementToBeClickable("//tbody//tr[1]//td[6]//a[1]");
		inactiveButton.click();
		return generalutility.isExpectedTextPresent(alertText, expectedMessage);

	}

	public boolean deleteUser(String expectedMessage) {
		loginpage = new LoginPage(driver);
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtilities(driver);
		loginpage.loginUtility();
		manageusersTab.click();
		deleteButton.click();
		pageutility.accept_Alert_Popup();
		return generalutility.isExpectedTextPresent(alertText, expectedMessage);
	}

	public void clickOnDeactivateButton(String username) {
		List<String> names = new ArrayList<String>();
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtilities(driver);
		manageusersTab.click();
		int i;
		names = generalutility.getAllElementsText("//tr//td[1]");
		for (i = 0; i < names.size(); i++) {
			if (username.equals(names.get(i))) {
				i++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[6]//a[1]"));
		pageutility.scroll_And_Click(deactivateButton);
	}
}
