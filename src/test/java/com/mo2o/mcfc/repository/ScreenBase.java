package com.mo2o.mcfc.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScreenBase {
	public static AppiumDriver driver;

	public ScreenBase(AppiumDriver driver) {
		this.driver = driver;
		loadElements();
	}
	public void loadElements(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
