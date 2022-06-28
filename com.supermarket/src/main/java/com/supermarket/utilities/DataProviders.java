package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	ExcelUtility excel;
	
	@DataProvider(name="invalidLogin")
	public Object[][] methodData1()
	{
		return new Object [][] {{"admin1","admin"},{"admin2","admin"},{"watches","admin"}};
	}
	
	@DataProvider(name="deliveryBoy")
	public Object[][] deliveryBoyData()
	{
		excel= new ExcelUtility();
		excel.setExcelFile("DeliveryBoyData", "PalaLocation");
		Object data[][]=excel.getMultidimentionaldata(3, 5);
		
		return data;
	}
	
	@DataProvider(name="loginCredentials")
	public Object[][] loginData()
	{
		excel= new ExcelUtility();
		excel.setExcelFile("LoginData", "Login");
		Object data1[][]=excel.getMultidimentionaldata(4, 2);
		return data1;
	}
	
	
	
}
