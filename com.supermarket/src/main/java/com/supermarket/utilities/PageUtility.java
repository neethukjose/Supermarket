package com.supermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void clearTextField(WebElement element) {
		element.clear();
	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void accept_Alert_Popup() {
		driver.switchTo().alert().accept();
	}

	public String alert_Popup_getText() {
		return driver.switchTo().alert().getText();
	}

	public void dismiss_Alert_Popup_() {
		driver.switchTo().alert().dismiss();
	}

	public void sendkeys_Alert_Popup_(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void moveToElementUtil(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void rightClickUtil(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void doubleClickUtil(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void clickAnd_Hold(WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
	}

	public void clickAnd_Release(WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
		action.release(element).build().perform();
	}

	public void dragAndDropUtil(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public void switch_To_Frame_by_Index(int index) {
		driver.switchTo().frame(index);
	}

	public void switch_To_Frame_by_Element(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switch_To_Frame_by_Name(String name) {
		driver.switchTo().frame(name);
	}

	public void scroll_By(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scroll_into_View(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void switch_To__Window(String id) {
		driver.switchTo().window(id);
	}

	public void fileUpload(WebElement element, String path) {

		element.sendKeys(path);

	}

	public boolean checkStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void scroll_And_Click(WebElement element) {
		int y = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (checkStatus(element)) {
			js.executeScript("window.scrollBy( 0 ," + y + ")");
			y = y + 50;
		}

	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	
}
