package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.PropHandler;
import com.supermarket.utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtilities generalutility;
	WaitUtility waitutil;
	PageUtility pageutility;

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='card-body login-card-body']//p")
	private WebElement loginMessage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidMessage;
	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	private WebElement remembermeLabel;
	@FindBy(xpath = "//div[@class='icheck-dark']")
	private WebElement rememberCheckbox;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberCheckboxselected;
	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	private WebElement userImage;
	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	private WebElement settings;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']//a[2]")
	private WebElement logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void  loginUtility(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
		
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void loginUtility() {
		String userName;
		String password;
		userName = prop.getPropertiesFileData("username");
		password = prop.getPropertiesFileData("password");
		loginUtility(userName, password);

	}

	public boolean isLoginInfoDisplayed(String infoMessage) {
		generalutility = new GeneralUtilities(driver);
		return generalutility.isExpectedTextPresent(loginMessage, infoMessage);

	}

	public boolean isInvalidCredentialsMessageDisplayed(String expectedErrorMessage) {
		generalutility = new GeneralUtilities(driver);
		return generalutility.isExpectedTextPresent(invalidMessage, expectedErrorMessage);
	}

	public boolean isRemember_Meisdisplayed() {
		generalutility = new GeneralUtilities(driver);
		return generalutility.isElementDisplayed(remembermeLabel);
	}
	
	public boolean isRemember_meIsSelected() {
		generalutility = new GeneralUtilities(driver);
        rememberCheckbox.click();
		return generalutility.isElementSelected(rememberCheckboxselected);
	}
	
	public boolean login_Successfull_Validation(String expectedText) {
		generalutility = new GeneralUtilities(driver);
		return generalutility.isExpectedTextPresent(userImage, expectedText);	
	}
	
	public String logOutVerification() {
		pageutility= new PageUtility(driver);
		settings.click();
		pageutility.moveToElementUtil(logout);
		logout.click();
		generalutility = new GeneralUtilities(driver);
		return generalutility.get_CurrentUrl();
	}
}
