package com.mo2o.mcfc.repository;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepMenuLateral extends ScreenBase{
	public RepMenuLateral(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static WebElement object = null;
	
	public WebElement buttonMenuLateral(AppiumDriver driver){
		object = driver.findElementByClassName("android.widget.ImageButton");
		return object;
	}
	@AndroidFindBy(id="com.munrodev.crfmobile:id/tvTitle")
	public WebElement btnMenuLateral; 
}




