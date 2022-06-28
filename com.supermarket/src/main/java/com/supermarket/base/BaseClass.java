package com.supermarket.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.supermarket.utilities.PropHandler;
import com.supermarket.utilities.ScreenShot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	 PropHandler prophandler;
	 ScreenShot screenshot;
	
	public void initialize(String browser, String url) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(enabled=true,alwaysRun=true)
	public void setUp() {
		
		prophandler= new PropHandler();
		String url=prophandler.getPropertiesFileData("url");
		String browser= prophandler.getPropertiesFileData("browser");
		initialize(browser, url);
	}
	
	@Parameters("browser")
	@BeforeMethod(enabled=false)	
	public void setUpCrossBrowser(String browser) {
		prophandler= new PropHandler();
		String url=prophandler.getPropertiesFileData("url");
		initialize(browser, url);
	}

	
	@AfterMethod
	public void tearDown(ITestResult itestresult) {
		screenshot= new ScreenShot();
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			String testCaseName= itestresult.getName();
			screenshot.takeScreenshot(driver, testCaseName);
		}
		//driver.close();
	}
	
	
	
}
