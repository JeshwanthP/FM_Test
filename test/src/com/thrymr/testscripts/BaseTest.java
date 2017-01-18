package com.thrymr.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.thrymr.functions.GeneralFunctions;
import com.thrymr.global.Global;
import com.thrymr.objects.XMLObjects;

public class BaseTest {

	boolean bStatus = false;


	@BeforeMethod
	public void beforeMethod() {
		bStatus = GeneralFunctions.openBrowser(Global.sBrowserName, Global.sURL);
		if(!bStatus){
			Assert.fail(Global.gErrMsg);
		}
	}

	@AfterMethod
	public void afterMethod() {
		bStatus = GeneralFunctions.closeBrowser();
		if(!bStatus){
			Assert.fail(Global.gErrMsg);
		}
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		XMLObjects.setobjectLocatorFilePath = "Sample.xml";
	}

	@AfterSuite
	public void afterSuite() {
	}

	@DataProvider
	public static Object[][] getSignUpDetails() {
		return XMLObjects.loadSignUpData();
	}
	
	@DataProvider
	public static Object[][] getLoginDetails() {
		return XMLObjects.loadLoginData();
	}
	
	@DataProvider
	public static Object[][] getChildDetails() {
		return XMLObjects.loadTagNewChildData();
	}
	
	@DataProvider
	public static Object[][] getNewPswdDetails() {
		return XMLObjects.loadNewPswds();
	}
	
	@DataProvider
	public static Object[][] getConfirmPswdDetails() {
		return XMLObjects.loadConfirmPswds();
	}
	

}


