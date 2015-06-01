package com.mo2o.mcfc.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

import com.mo2o.mcfc.repository.RepMenuLateral;



public class CommonFunctions {
	static By btnMenuLateral = By.id( "android.widget.ImageButton");

	public static void displaySideMenu(AppiumDriver driver){
		try {
			RepMenuLateral repMenuLateral = new RepMenuLateral(driver);
			repMenuLateral.buttonMenuLateral(driver).click();
		} catch (NoSuchElementException e) {
			System.out.println("********Problema en "+ e.getMessage() + "*************");
		}
	}
	
	public static void waitAppLanzado(AppiumDriver driver){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(btnMenuLateral));
		} catch (NoSuchElementException e) {
			System.out.println("********Problema en "+ e.getMessage() + "*************");
		}
	}

}
