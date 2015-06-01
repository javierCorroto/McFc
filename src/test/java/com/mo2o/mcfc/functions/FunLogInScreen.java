package com.mo2o.mcfc.functions;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.mo2o.mcfc.repository.*;

public class FunLogInScreen extends CommonFunctions{
	static By editEmail = By.id("com.mcfc.citymatchday:id/loginPasswordEditText");
	static By btnClose = By.id("com.mcfc.citymatchday:id/btClose");
	static By popUpPassErroneo = By.id("com.mcfc.citymatchday:id/tvText");

	//	public static void clickAreaPersonal(AppiumDriver driver) throws IOException{
	//		int click = 0;
	//		try {                      
	
	//			//ReadPropertyFile read = new ReadPropertyFile();
	//			//CommonFunctions.waitAppLanzado(driver);
	//			CommonFunctions.displaySideMenu(driver);
	//
	//			WebElement listViewMenuLateral = driver.findElement(listView);
	//			List<WebElement> buscarAreaPersonalString = listViewMenuLateral.findElements(textView);
	//			for (WebElement element : buscarAreaPersonalString){
	//				if (click == 1) {
	//					element.click();
	//					break;
	//				}
	//				if (element.getText().toString().equalsIgnoreCase("INICIO")){
	//					click = click +1;
	//					System.out.println(element.getText());
	//				}
	//			}
	//		} catch (NoSuchElementException e) {
	//			System.out.println("********clickAreaPersonal falta " + e.getMessage() + "*************");
	//		}
	//	}

	
	public static void loginEmail(AppiumDriver driver, String email, String passEmail, String numero, String passNum) throws InterruptedException{
		try {
			
//			RepInicioS7esion repIS = P7ageFactory.initElements(new AppiumFieldDecorator(driver), RepInicioSesion.class);
			RepInicioSesion repIS = PageFactory.initElements(driver, RepInicioSesion.class);
			//ReadPropertyFile read = new ReadPropertyFile();
			//CommonFunctions.waitAppLanzado(driver);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(editEmail));
			//if (repIS.btnClose(driver).isDisplayed() == true && repIS.editEmail(driver).isDisplayed() == false) System.out.println("Esta bien");
			//if (repIS.btnClose(driver).isDisplayed() == true) System.out.println("Esta bien");
			//			if (driver.findElement(By.id("com.mcfc.citymatchday:id/btClose")).isDisplayed() ==true){
			//				System.out.println("Esta bien");
			//			}else{
			//				System.out.println("NO Esta bien");
			//			}
			//repIS.btnSoyNuevo.sendKeys(email);
			repIS.editEmail(driver).sendKeys(email);
			repIS.editPass(driver).sendKeys(passEmail);
			driver.hideKeyboard();
			repIS.btnLogIn(driver).click();
		} catch (NoSuchElementException e) {
			Method m = null;
			System.out.println( "Ha habido un error" + m.getName() + " " + e.getMessage());
		}
	}

	public static void veriLogInErroneo(AppiumDriver driver){
		String passIncorrecto = "Password is not correct";
		RepInicioSesion repIS = new RepInicioSesion();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(popUpPassErroneo));	
			Assert.assertEquals(passIncorrecto, repIS.popUpPassErroneo(driver).getText(), "Pasado");
		} catch (NoSuchElementException e) {
			System.out.println("********clickInciarSesion falta " + e.getMessage() + "*************");
		}
	}


}