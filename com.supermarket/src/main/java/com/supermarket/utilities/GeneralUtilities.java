package com.supermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.supermarket.base.BaseClass;

public class GeneralUtilities {

	WebDriver driver;

	public GeneralUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public String get_CurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTextofElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isExpectedTextPresent(WebElement element, String expectedText) {
		return element.getText().contains(expectedText);
	}

	public List<String> getAllElementsText(String xpath) {
		List<String> text = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		for (WebElement s : elements) {
			text.add(s.getText());
		}
		return text;
	}
	
	public String  getAttributeValue(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}
	
	public boolean  isgetAttributeValuePresent(WebElement element,String attribute,String expectedvalue) {
		return element.getAttribute(attribute).contains(expectedvalue);
	}
	public String  getCSSSelectorValue(WebElement element,String property) {
		return element.getCssValue(property);
	}
	
	//css boolean
	public String  getToolTipValue(WebElement element,String attribute) {
		return element.getAttribute("title");
	}
	
	//get title
	//get current url
	
	
}
