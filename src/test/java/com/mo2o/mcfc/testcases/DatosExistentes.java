package com.mo2o.mcfc.testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mo2o.mcfc.functions.FunLogInScreen;
import com.mo2o.mcfc.utils.ReadPropertyFile;

public class DatosExistentes extends TestBase {

	//TC001: Verificar imposibilidad de hacer log in con email no existente o erroneo
	@Test (dataProvider ="DP1")
	public void TC001(String testCase, String email, 
			String contrasena, String numero, String contrasenaNumero, Method m) 
					throws Exception {
		String contenidoCelda = testCase;
		String metodo = m.toString();  
		boolean tcID= metodo.contains(contenidoCelda);
		if (tcID==true){
			FunLogInScreen.loginEmail(driver, email, contrasena, numero , contrasenaNumero);
			FunLogInScreen.veriLogInErroneo(driver);
		}
	}

	//TC002: Verificar imposibilidad de hacer log in con password no existente o erroneo
	@Test (dataProvider ="DP1")
	public void TC002(String testCase, String email, 
			String contrasena, String numero, String contrasenaNumero, Method m) 
					throws Exception {
		String contenidoCelda = testCase;
		String metodo = m.toString();  

		boolean tcID= metodo.contains(contenidoCelda);
		if (tcID==true){
			FunLogInScreen.loginEmail(driver, email, contrasena, numero , contrasenaNumero);
			FunLogInScreen.veriLogInErroneo(driver);
		}
	}

	@AfterMethod
	public void close() throws Exception{
		System.out.println("Ha entrado en quit");
		driver.quit();
	}

	@DataProvider(name = "DP1")
	public Object[][] createData1(Method m) throws Exception {
		Object[][] retObjArr = getTableArray(
				"/Users/javiercorroto/Desktop/TestCase_McFc.xls", "PruebasKO",
				"mcfc",m);
		return (retObjArr);
	}
}