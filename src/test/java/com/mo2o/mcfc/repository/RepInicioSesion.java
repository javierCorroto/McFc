package com.mo2o.mcfc.repository;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RepInicioSesion{
	private static WebElement object = null;
//	public void RepAreaPersonal(AppiumDriver driver) { 
//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}
//
	@AndroidFindBy(id="com.mcfc.citymatchday:id/loginEmailEditText")
	//@iOSFindBy(id="com.mcfc.citymatchday:id/loginEmailEditText")
	public WebElement btnSoyNuevo; 
	
	public WebElement btnClose(AppiumDriver driver){
		object = driver.findElement(By.id("com.mcfc.citymatchday:id/btClose"));
		return object;
	}
	
	public WebElement editEmail(AppiumDriver driver){
		object = driver.findElement(By.id("com.mcfc.citymatchday:id/loginEmailEditText"));
		return object;
	}
	
	public WebElement editPass(AppiumDriver driver){
		object = driver.findElement(By.id("com.mcfc.citymatchday:id/loginPasswordEditText"));
		return object;
	}
	
	public WebElement btnLogIn(AppiumDriver driver){
		object = driver.findElement(By.id("com.mcfc.citymatchday:id/loginButton"));
		return object;
	}
	
	public WebElement popUpPassErroneo(AppiumDriver driver){
		object = driver.findElement(By.id("com.mcfc.citymatchday:id/tvText"));
		return object;
	}
}
