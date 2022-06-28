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

public class ManageExpensePage {

	WebDriver driver;
	GeneralUtilities generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//p[contains(text(),'Manage Expense')]")
	private WebElement manageexpensetab;
	@FindBy(xpath = "//li[2]//ul[1]//li")
	private WebElement expensecategorytab;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updatebutton;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String validateExpenseCategoryVisible() {
		generalutility = new GeneralUtilities(driver);
		manageexpensetab.click();
		return generalutility.getAttributeValue(expensecategorytab, "class");

	}

	public boolean editExpenseCategory(String nameedit) {
		List<String> category = new ArrayList<String>();
		manageexpensetab.click();
		expensecategorytab.click();
		searchExpense_AndClickonEditButton("TestEdit");
		name.clear();
		name.sendKeys(nameedit);
		updatebutton.click();
		boolean flag = false;
		category = generalutility.getAllElementsText("//tr//td[1]");

		for (int i = 0; i < category.size(); i++) {

			if ((category.get(i)).contains(nameedit)) {
				flag = true;
				System.out.println(category.get(i));
				break;
			}
		}
		return flag;
	}

	public boolean deleteExpenseCategory(String category) {
		List<String> categorylist = new ArrayList<String>();
		manageexpensetab.click();
		expensecategorytab.click();
		searchExpense_AndClickonDeleteButton(category);
		boolean flag = true;
		categorylist = generalutility.getAllElementsText("//tr//td[1]");

		for (int i = 0; i < categorylist.size(); i++) {

			if ((categorylist.get(i)).contains(category)) {
				flag = false;
				System.out.println(categorylist.get(i));
				break;
			}
		}
		return flag;
	}

	public void searchExpense_AndClickonEditButton(String category) {
		List<String> names = new ArrayList<String>();
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtilities(driver);
		int i;
		names = generalutility.getAllElementsText("//tr//td[1]");
		for (i = 0; i < names.size(); i++) {
			if (category.equals(names.get(i))) {
				i++;
				break;
			}
		}
		WebElement editbutton = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[2]//a[1]"));
		pageutility.scroll_And_Click(editbutton);
	}

	public void searchExpense_AndClickonDeleteButton(String category) {
		List<String> deletelist = new ArrayList<String>();
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtilities(driver);
		int i;
		deletelist = generalutility.getAllElementsText("//tr//td[1]");
		for (i = 0; i < deletelist.size(); i++) {
			if (category.equals(deletelist.get(i))) {
				i++;
				break;
			}
		}
		WebElement deletebutton = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[2]//a[2]"));
		pageutility.scroll_And_Click(deletebutton);
		pageutility.accept_Alert_Popup();
	}

}
