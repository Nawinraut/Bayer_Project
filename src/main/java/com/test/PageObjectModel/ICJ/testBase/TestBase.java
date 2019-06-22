package com.test.PageObjectModel.ICJ.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	String url="https://www.drscholls.ca/en/custom-fit-orthotics/kiosk-locator-results/";
	String browser="chrome";
	
	
	public void init()
	{
		selectBrowser(browser);
		//String log4jconfpath="log4j.properties";
		//PropertyConfigurator.configure(log4jconfpath);
		
	}
	public void selectBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\nawkumar\\workspace\\ICJ\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("Browser launched");
			
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\nawkumar\\workspace\\ICJ\\Driver\\chromedriver.exe");		
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");*/
			driver = new ChromeDriver(); 
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
          
		}
	}
	

	
}
