package com.supermarket.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 public static final long IMPLICIT_WAIT=10;
	 public static final long PAGE_LOAD_WAIT=20;
	 public static final long EXPLICIT_WAIT=20;
	 
	 public WaitUtility(WebDriver driver) {
		 this.driver= driver;
	 }
	 
	 public void waitForElementToBeClickable(String xpath) {
		 wait= new WebDriverWait(driver, EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	 }

	 public void waitforAlertPresent() {
		 wait= new WebDriverWait(driver, EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.alertIsPresent());
	 }
	 
	 public void waitForVisibilityofElementLocated(String xpath) {
		 wait= new WebDriverWait(driver, EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	 }
	 
	 public void waitForInvisibilityofElementLocated(String xpath) {
		 wait= new WebDriverWait(driver, EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	 }
	 
}
