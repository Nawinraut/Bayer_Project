package com.test.PageObjectModel.loginPage;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.test.PageObjectModel.ICJ.excelReader.ExcelReader;
import com.test.PageObjectModel.ICJ.testBase.TestBase;
import com.test.PageObjectModel.ICJ.uiActions.LoginPage;

public class VerifyStoreList extends TestBase {

	public static final Logger log = Logger.getLogger(VerifyStoreList.class.getName());
	LoginPage loginpage;
	ExcelReader readfile;

	public VerifyStoreList() {
		super();
	}

	@BeforeMethod
	public void setup() {
		init();
		readfile = new ExcelReader();
		loginpage = new LoginPage();
	}

	// @Test(dataProvider ="StoreList",dataProviderClass = ExcelReader.class)
	// String StoreName,String StoreAddress,String City,String State, String
	// ZipCode, String Latitude, String Longitude

	@Test(priority = 1)
	public void verifyStoreName() throws Exception {

		Object[][] readExcel = readfile.readExcel();
		for (int i = 0; i < readExcel.length; i++) {
			String storeName = readExcel[i][0].toString();
			String storeAddress = readExcel[i][1].toString();
			String zipCode = readExcel[i][4].toString();
			// System.out.println(storeName);
			List<String> listOfStoreName = loginpage.verifyStoreName(zipCode);
			System.out.println("Total count of stores " + listOfStoreName.size());
			int flag = 0;
			for (String store : listOfStoreName) {
				if (store.equalsIgnoreCase(storeName+storeAddress)) {
					System.out.println(store);
					System.out.println(storeName+storeAddress);
					log.info(storeName + "          ||is availabe for the Zip code||          " + zipCode);
					readfile.writeExcel(i + 1, 7, "Available");
					flag = 1;
					break;
				}

			}
			if (flag == 0) {

				log.info(storeName + "          ||is not availabe for the Zip code||            " + zipCode);
				readfile.writeExcel(i + 1, 7, "Not available");
			}

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
