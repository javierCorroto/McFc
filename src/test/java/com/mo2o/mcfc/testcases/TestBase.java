package com.mo2o.mcfc.testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mo2o.mcfc.utils.CommonUtils;
import com.mo2o.mcfc.utils.ReadPropertyFile;


public class TestBase {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	AppiumDriver driver;
	
	@Parameters("Device_ID")
	@BeforeMethod
	public void setupCapabilities(String Device_ID) throws Exception {
		try {
			ReadPropertyFile read = new ReadPropertyFile();
			Thread.sleep(5000);

			if (Device_ID.equalsIgnoreCase(read.nexus5Blanco())) {
				setcapabilities("com.mcfc.citymatchday", "com.mo2o.citymatchday.activities.SplashActivity",Device_ID);
			}
			if (Device_ID.equalsIgnoreCase(read.nexus5Rojo())) {
				setcapabilities("com.mcfc.citymatchday", "com.mo2o.citymatchday.activities.SplashActivity",Device_ID);
			}
			if (Device_ID.equalsIgnoreCase(read.samsungS5())) {
				setcapabilities("com.mcfc.citymatchday", "com.mo2o.citymatchday.activities.SplashActivity",Device_ID);
			}
			driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());	
		}
	}
	public void setcapabilities(String apppackage,
			String appActivity,String device) {
		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "ANDROID");
		capabilities.setCapability("androidPackage", apppackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("udid", device);
	}

	public String[][] getTableArray(String xlFilePath, String sheetName,
			String tableName, Method m) throws Exception {

		String[][] tabArray = null;
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
				+ "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;
		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			boolean continuarLoop = false;
			for (int j = startCol + 1; j < endCol; j++, cj++) {			
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				//System.out.println("Esto es la celda " +sheet.getCell(j, i).getContents());
				if (continuarLoop == true) continue;
				String contenidoCelda = sheet.getCell(j, i).getContents();
				String metodo = m.toString();  
				boolean tcID= metodo.contains(contenidoCelda);
				if (tcID==true){
					continuarLoop =true;
				}else{
					break;
				}
			}
		}
		return (tabArray);
	}
}
