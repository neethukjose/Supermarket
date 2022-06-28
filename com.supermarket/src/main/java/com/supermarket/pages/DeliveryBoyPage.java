package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class DeliveryBoyPage {

	public WebDriver driver;
    GeneralUtilities generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	private WebElement deliveryboytab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nametext;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonenumber;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordText;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebutton;

	public DeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String navigateDeliveryBoyPageValidation() {
		pageutility = new PageUtility(driver);
		pageutility.scroll_And_Click(deliveryboytab);
		return driver.getTitle();
	}

	public void navigateDeliveryBoyPage() {
		pageutility = new PageUtility(driver);
		pageutility.scroll_And_Click(deliveryboytab);

	}
	
	public boolean createNewDeliveryBoy(String name, String emailid,String phoneNo, String userName,String password) {
		List<String> names = new ArrayList<String>();
		pageutility = new PageUtility(driver);
		generalutility= new GeneralUtilities(driver);
		navigateDeliveryBoyPage();
		newbutton.click();
		nametext.sendKeys(name);
		email.sendKeys(emailid);
		phonenumber.sendKeys(phoneNo);
		username.sendKeys(userName);
		passwordText.sendKeys(password);
		pageutility.scroll_And_Click(savebutton);
		int i;
		names = generalutility.getAllElementsText("//tr//td[1]");
		for (i = 0; i < names.size(); i++) {
			if (name.equals(names.get(i))) {
				i++;
				return true;
	
					}
		}
		return false;
	}

}
