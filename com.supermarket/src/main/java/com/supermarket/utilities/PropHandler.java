package com.supermarket.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.supermarket.constants.Constants;

public class PropHandler {

	Properties prop;
	FileInputStream ip;

	public PropHandler() {
		prop = new Properties();
		
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPropertiesFileData(String key) {

		return prop.getProperty(key);

	}
}
