package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.RandomNumberUtility;

public class ManageCategoryPage {
	
	WebDriver driver;
	GeneralUtilities generalutility;
	PageUtility pageutility;
	RandomNumberUtility randomnumberutil;
	
	@FindBy(xpath="(//li[@class='nav-item has-treeview'])[3]")
	private WebElement managecategory;
	@FindBy(xpath="(//ul[@class='nav nav-treeview'])[8]")
	private WebElement categorytab;
	@FindBy(xpath="//li[@class='nav-item has-treeview menu-open']")
	private WebElement managecategoryopen;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")
	private WebElement categorytext;
    @FindBy(xpath="//span[text()='Idukki Spices']")
	private WebElement group;
    @FindBy(xpath="//input[@id='main_img']")
	private WebElement selectfile;
	@FindBy(xpath="//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String subMenuIsPresent() {
		generalutility= new GeneralUtilities(driver);
		pageutility= new PageUtility(driver);
		pageutility.scroll_And_Click(managecategory);
		return generalutility.getAttributeValue(managecategoryopen, "class");
	}
	
	public boolean addCategory() {
		pageutility= new PageUtility(driver);
		randomnumberutil= new RandomNumberUtility(driver);
		generalutility= new GeneralUtilities(driver);
		pageutility.scroll_And_Click(managecategory);
		pageutility.scroll_And_Click(categorytab);
	    newbutton.click();
		long value= randomnumberutil.generateRandom(4);
		categorytext.sendKeys("category"+value);
		group.click();
		pageutility.fileUpload(selectfile, Constants.CATEGORY_FILE_PATH);
		pageutility.scroll_And_Click(savebutton);
		return generalutility.isElementDisplayed(alertmessage);
	}

}
