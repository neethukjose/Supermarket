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

public class ManageProductPage {

	WebDriver driver;
	GeneralUtilities generalutility;
	PageUtility pageutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//p[text()='Manage Product']")
	private WebElement manageproducttab;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath = "//select[@id='sub_id']")
	private WebElement subcategory;
	@FindBy(xpath = "//input[@id='m_weight']")
	private WebElement weightvalue;
	@FindBy(xpath = "//select[@id='w_unit']")
	private WebElement weightunit;
	@FindBy(xpath = "//input[@id='max_weight']")
	private WebElement maxweightvalue;
	@FindBy(xpath = "//input[@id='w_price']")
	private WebElement pricevalue;
	@FindBy(xpath = "//input[@id='w_stock']")
	private WebElement stockvalue;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean productCreation(String productName) throws InterruptedException {
		List<String> products = new ArrayList<String>();
		generalutility = new GeneralUtilities(driver);
		pageutility = new PageUtility(driver);
		waitutility = new WaitUtility(driver);
		manageproducttab.click();
		newbutton.click();
		title.sendKeys(productName);
		pageutility.select_ByVisibleText(category, "Personal Care");
		waitutility.waitForElementToBeClickable("//select[@id='sub_id']");
		subcategory.click();
		pageutility.select_ByVisibleText(subcategory, "Hair Care");
		weightvalue.sendKeys("500");
		pageutility.select_ByValue(weightunit, "kg");
		maxweightvalue.sendKeys("600");
		pricevalue.sendKeys("30");
		stockvalue.sendKeys("10");
		pageutility.scroll_And_Click(savebutton);
		Thread.sleep(3000);
		manageproducttab.click();
		boolean flag = false;
	    products = generalutility.getAllElementsText("//tr//td[1]");
		
		for (int i = 0; i < products.size(); i++) {
			
			if ((products.get(i)).contains(productName)) {
				flag = true;
				System.out.println(products.get(i));
				break;
		}
		}
		return flag;

	}

	public String newButtonColorVerification() {
		manageproducttab.click();
		generalutility = new GeneralUtilities(driver);
		return generalutility.getCSSSelectorValue(newbutton, "background-color");
	}

	public boolean deleteProduct(String productName) {
		List<String> names = new ArrayList<String>();
		List<String> finalnames = new ArrayList<String>();
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtilities(driver);
		manageproducttab.click();
		int i;
		names = generalutility.getAllElementsText("//tr//td[1]");
	    for (i = 0; i < names.size(); i++) {
			if ((names.get(i)).contains(productName)) {

				i++;
				break;
			}
		}
		WebElement deletebuton = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[9]//a[2]"));
		pageutility.scroll_And_Click(deletebuton);
		pageutility.accept_Alert_Popup();
		System.out.println("deletebuttonclicked");
		pageutility.pageRefresh();
		
		boolean flag = true;
		finalnames = generalutility.getAllElementsText("//tr//td[1]");
	    for (i = 0; i < finalnames.size(); i++) {
			if ((finalnames.get(i)).contains(productName)) {
				
				flag = false;
				break;
			}

		}
		return flag;
	}

}
