package com.test.PageObjectModel.ICJ.uiActions;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.PageObjectModel.ICJ.testBase.TestBase;

public class LoginPage extends TestBase {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

	@FindBy(id = "zip")
	WebElement zipTxtBox;

	@FindBy(id = "locator-search")
	WebElement goButton;

	@FindBy(id = "locator-radius")
	WebElement drpdwn;

	@FindBy(xpath = "//*[@id='cookie-bar']/div[2]/div/div[1]/span")
	WebElement cookieButton;

	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	public List<String> verifyStoreName(String zipcode) {
		driver.switchTo().defaultContent();
		// boolean displayed = cookieButton.getSize();
		boolean displayed = driver.findElements(By.xpath("//*[@id='cookie-bar']/div[2]/div/div[1]/span")).size() > 0;
		if (displayed) {
			cookieButton.click();
		} else {
			zipTxtBox.clear();
		}
		zipTxtBox.sendKeys(zipcode);
		zipTxtBox.sendKeys(Keys.ENTER);
		driver.switchTo().frame("cfoiframe");
		WebElement storeDrive = driver.findElement(By.id("stores-list"));
		List<String> storename = new ArrayList<String>();
		List<WebElement> list = storeDrive.findElements(By.xpath("//h3"));
		// System.out.println(list.size());
		for (WebElement li : list) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", li);
			storename.add(li.getText());
		}
		return storename;

	}

}
