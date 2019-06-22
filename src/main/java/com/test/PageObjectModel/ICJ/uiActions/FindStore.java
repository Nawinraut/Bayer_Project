package com.test.PageObjectModel.ICJ.uiActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class FindStore {
  
	public static void main(String args[]) throws InterruptedException
	{
		String url="https://www.drscholls.ca/en/custom-fit-orthotics/kiosk-locator-results/";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nawkumar\\workspace\\ICJ\\Driver\\chromedriver.exe");
		
		/*System.setProperty("webdriver.gecko.driver","C:\\Users\\nawkumar\\workspace\\ICJ\\Driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();*/
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cookie-bar']/div[2]/div/div[1]/span")).click();
		driver.switchTo().frame("cfoiframe");
		driver.findElement(By.id("locator-zip")).sendKeys("T7X 3Z3");
		/*WebElement drpdwn = driver.findElement(By.id("locator-radius"));
		Select select=new Select(drpdwn);
		select.selectByVisibleText("5 km");;*/
		driver.findElement(By.id("locator-zip")).sendKeys(Keys.ENTER);;
		//driver.switchTo().frame("cfoiframe");
	   WebElement storeDrive = driver.findElement(By.id("stores-list"));
		List<String> storename=new ArrayList<String>();
	   List<WebElement> store = storeDrive.findElements(By.xpath("//h3"));	
	   //List<WebElement> address1 = driver.findElements(By.xpath("//div[@id='stores-list']//p[1]"));
		System.out.println(store.size());
		//System.out.println(address1.size());
		int j=0;
		for(WebElement li:store)
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",li );
			//System.out.println(li.getText());
			String text = driver.findElement(By.xpath("//div[@id='store-"+j+"']//p[1]")).getText();
			String[] text1 = text.split("\\r?\\n");
			//System.out.println(text1[0]);
		    j++;
		    System.out.println(li.getText()+text1[0]);
			}
				//System.out.println("*********************************************");
				//storename.add(li.getText()+adrs.getText());	
		}
		
		
		//System.out.println(storename);
	}

	

