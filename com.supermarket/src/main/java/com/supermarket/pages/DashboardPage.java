package com.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtilities;

public class DashboardPage {

	public WebDriver driver;
	GeneralUtilities generalutility;
	LoginPage loginpage;
	ExcelUtility excel;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement pagetitle;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateDashboardSections() {

		generalutility = new GeneralUtilities(driver);
		loginpage = new LoginPage(driver);
		boolean status = false;
		loginpage.loginUtility();
		excel = new ExcelUtility();
		excel.setExcelFile("DashBoardTiles", "Tiles");
		List<String> actuallist = excel.getDatainList();
		List<String> dashboardtiles = generalutility.getAllElementsText("//div[@class='inner']//p");
		
		 System.out.println("actuallist"+actuallist);
		  System.out.println("dashboard"+dashboardtiles);
		 
		for (int i = 0; i < actuallist.size(); i++) {
			for (int j = 0; j < dashboardtiles.size(); j++) {
				if(actuallist.get(i).equals(dashboardtiles.get(j))) {
				status=true;
				break;
				}
				if (!actuallist.get(i).equals(dashboardtiles.get(j))) {
					if (j == dashboardtiles.size()-1) {
						status = false;
						break;
					} 
				}

			}
			
				if (status == false) {

					break;

				}

		}

		return status;

	}

	public String validateDashboardTitle() {

		loginpage = new LoginPage(driver);
		generalutility = new GeneralUtilities(driver);
		loginpage.loginUtility();
		return generalutility.getTextofElement(pagetitle);
	}

}
