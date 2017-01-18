package com.thrymr.functions;
import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thrymr.global.Global;

public class GeneralFunctions 
{
	private static Logger logger = Logger.getLogger("GeneralFunctions");
	private static boolean bStatus = false;

	public static boolean openBrowser(String browser, String url){
		try{	
			if(browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("firefox")){
				logger.info("loading firefox browser");
				Global.driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie")|| browser.equalsIgnoreCase("internetexplorer")){ 
				logger.info("loading IE browser");
				System.setProperty("webdriver.ie.driver","");
				Global.driver = new InternetExplorerDriver();
				Global.driver.manage().deleteAllCookies();
			}
			else if(browser.equalsIgnoreCase("gc")|| browser.equalsIgnoreCase("chrome")){
				logger.info("loading chrome browser");
				System.setProperty("webdriver.chrome.driver","/home/thrymr/chromedriver.exe");
				Global.driver = new ChromeDriver();
				Global.driver.manage().deleteAllCookies();
			}
			Global.driver.get(url);
			Global.driver.manage().window().maximize();
			logger.info("Browser loaded with url and maximized");
			return true;
		}
		catch(Exception e){
			Global.gErrMsg = "Browser is not opened" + e.getMessage();
			logger.warn("browser is no opened: Exception: "+e.getMessage());
			return false;
		}
	}

	public static boolean waitForElementVisibility(By objLocator,int iTimeout){
		try{
			Global.gErrMsg = "";
			Global.wait=new WebDriverWait(Global.driver,iTimeout);
			Global.wait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
			logger.info(objLocator+" element is visible after waiting for "+iTimeout);
			return true;
		}
		catch(Exception e){
			Global.gErrMsg = e.getMessage();
			logger.warn(objLocator+" element is not visible after waiting for "+iTimeout+" Exception: "+e.getMessage());
			return false;
		}
	}

	public static boolean enterText(By objLocator,String Value) {
		bStatus = verifyElementVisible(objLocator);
		if(bStatus){
			try{
				Global.driver.findElement(objLocator).clear();
				Global.driver.findElement(objLocator).sendKeys(Value);
				logger.info(Value+" entered in text box");
				return true;
			}
			catch(Exception e){
				Global.gErrMsg = e.getMessage();
				logger.info(Value+" cannot entered in text box.Exception: "+e.getMessage());
				return false;
			}
		}
		return false;
	}

	public static boolean verifyElementVisible(By objLocator) {
		try {
			Global.gErrMsg = "";
			bStatus = Global.driver.findElement(objLocator).isDisplayed();
			logger.info("Element " + objLocator + " is visible");
			return bStatus;
		} catch (Exception e) {
			Global.gErrMsg = e.getMessage();
			logger.warn("Element " + objLocator + " is not visible.");
			return false;
		}
	}

	public static boolean click(By objLocator) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			try{
				Global.driver.findElement(objLocator).click();
				logger.info("The button " + objLocator+ " has been clicked successfully");
				return true;
			}
			catch(Exception e){
				Global.gErrMsg = e.getMessage();
				logger.warn("The button " + objLocator + " cannot be clicked because "+ e.getMessage());
				return false;
			}
		}
		return false;

	}

	public static boolean closeBrowser(){
		try{
			if(Global.driver!=null){
				Global.driver.close();
				Global.driver.quit();
				logger.info("Browsers closed succefully");
			} 
			return true;
		}
		catch(Exception e){
			Global.gErrMsg = e.getMessage();
			logger.warn("Browsers cannot closed succefully.Exception: "+Global.gErrMsg);
			return false;
		}
	}

	public static String getElementAttribute(By objLocator,String sAttrVal) {
		String sValue = null;
		bStatus = verifyElementPresent(objLocator);
		if (bStatus) {
			sValue = Global.driver.findElement(objLocator).getAttribute(sAttrVal);
			if (sValue == null) {
				Global.gErrMsg = "The element " + objLocator+ " has no attribute " + sAttrVal;
				logger.warn(Global.gErrMsg);
				return sValue;
			}
			logger.info("The element " + objLocator + " has value '" + sValue+ "' for attribute " + sAttrVal);
			return sValue;
		}
		return sValue;
	}

	public static boolean verifyElementPresent(By objLocator) {
		try {
			Global.gErrMsg = "";
			Global.driver.findElement(objLocator);
			logger.info("Element " + objLocator + " is present in DOM");
			return true;
		} catch (Exception e) {
			Global.gErrMsg = e.getMessage();
			logger.warn("Element " + objLocator+ " is not present in DOM because " + Global.gErrMsg);
		}
		return false;
	}

	public static String getText(By objLocator) {
		String sValue = null;
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			sValue = Global.driver.findElement(objLocator).getText();
			if (sValue == null) {
				logger.info("The element " + objLocator + " has no text ");
				return sValue;
			}
			logger.warn("The text " + sValue + " from the element "
					+ objLocator + " is retrieved");
			return sValue;
		}
		logger.warn("The text from the element " + objLocator
				+ " cannot be retrieved because " + Global.gErrMsg);
		return sValue;
	}

	public static boolean selectDropDownByText(By objLocator,String text) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus){
			try{
				Select selectText = new Select(Global.driver.findElement(objLocator));
				selectText.selectByVisibleText(text.trim());
				logger.info(text+" : is selected form dropdown");
				return true;
			}
			catch(Exception e){
				Global.gErrMsg = e.getMessage();
				logger.warn(text+" : is not selected form dropdown. Exception: "+Global.gErrMsg);
				return false;
			}
		}
		return false;
	}
	
	public static boolean deSelectAllValuesInDropDown(By objLocator){
		bStatus = verifyElementVisible(objLocator);
		if (bStatus){
			try{
				Select selectText = new Select(Global.driver.findElement(objLocator));
				selectText.deselectAll();
				logger.info("All values are deselected");
				return true;
			}
			catch(Exception e){
				Global.gErrMsg = e.getMessage();
				logger.warn(" Values are not deselected form dropdown. Exception: "+Global.gErrMsg);
				return false;
			}
		}
		return false;
	}
	
	public static boolean clearText(By objLocator) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			Global.driver.findElement(objLocator).clear();
			logger.info("The text has been cleared from the input box "
					+ objLocator + " successfully");
			return true;
		}
		logger.warn("The text could not be cleared from the input box "
				+ objLocator);
		return false;
	}

	public static boolean selectDropDownByIndex(By objLocator,int iIndex) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus){
			try{
				Select selectText = new Select(Global.driver.findElement(objLocator));
				selectText.deselectByIndex(iIndex);
				logger.info(iIndex+" : is selected form dropdown");
				return true;
			}
			catch(Exception e){
				Global.gErrMsg = e.getMessage();
				logger.warn(iIndex+" : is not selected form dropdown. Exception: "+Global.gErrMsg);
				return false;
			}
		}
		return false;
	}

	public static int getXpathCount(By objLocator) {
		int iSize = 0;
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			iSize = Global.driver.findElements(objLocator).size();
			logger.info("The xpath count of the element " + objLocator + " is "
					+ iSize);
			return iSize;
		}
		logger.warn("The xpath count of the element " + objLocator + " is "+ iSize + " because " +Global.gErrMsg);
		return iSize;
	}

	public static boolean verifyFileExists(String sFileName) {
		File objFile = new File(sFileName);
		if (objFile.exists()) {
			logger.info(sFileName + "exist in directory");
			return true;
		}
		Global.gErrMsg = sFileName + " doesn't exist in directory";
		logger.warn(Global.gErrMsg);
		return false;
	}

	public static boolean verifyEnable(By objLocator) {
		bStatus = verifyElementPresent (objLocator);
		if (bStatus) {
			bStatus = Global.driver.findElement(objLocator).isEnabled();
			if (bStatus) {
				logger.info("The element is enabled");
				return true;
			}
			Global.gErrMsg = objLocator + " is not enabled.";
			logger.warn(Global.gErrMsg);
			return false;
		}
		return false;
	}

	public static boolean verifyAlertPresent() {
		String alertMsg = getAlertMessage();
		if (alertMsg == null) {
			logger.warn("No alert found");
			return false;
		}
		logger.info("Alert present");
		return true;
	}

	public static String getAlertMessage() {
		String alertMsg = null;
		bStatus = waitForAlert(10);
		if (bStatus) {
			alertMsg = Global.driver.switchTo().alert().getText();
			if (alertMsg != null) {
				logger.info(alertMsg+" text found in alert.");
				return alertMsg;
			}
			logger.info("No text found in alert.");
			return alertMsg;
		}
		return alertMsg;
	}

	public static boolean acceptAlert() {
		bStatus = verifyAlertPresent();
		if (bStatus) {
			Global.driver.switchTo().alert().accept();
			logger.info("alert is accepted succesfully");
			return true;
		}
		logger.warn("alert is cannot be accepted");
		return false;
	}

	public static boolean closeAlert() {
		bStatus = verifyAlertPresent();
		if (bStatus) {
			Global.driver.switchTo().alert().dismiss();
			logger.info("alert is dismisswd succesfully");
			return true;
		}
		logger.warn("alert is cannot be dismissed");
		return false;
	}

	public static boolean waitForAlert(int iTimeout) {
		try{
			Global.gErrMsg = "";
			Global.wait=new WebDriverWait(Global.driver,iTimeout);
			Global.wait.until(ExpectedConditions.alertIsPresent());
			logger.info("alert is visible after waiting for "+iTimeout);
			return true;
		}
		catch(Exception e){
			Global.gErrMsg = e.getMessage();
			logger.warn("alert is not visible after waiting for "+iTimeout+" Exception: "+e.getMessage());
			return false;
		}
	}

	public static boolean switchToFrameByFrameElement(By objLocator) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			try{
				Global.driver.switchTo().frame(Global.driver.findElement(objLocator));
				logger.info("switched to frame.");
				return true;
			} catch (Exception e) {
				Global.gErrMsg = e.getMessage();
				logger.warn("cannot be switched to frame.Exception: "+e.getMessage());
				return false;
			}
		}
		return false;
	}

	public static boolean switchToFrameByName(String sName) {
		By objLocator = By.name(sName);
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			try {
				Global.driver.switchTo().frame(sName);
				logger.info("switched to frame.");
				return true;
			} catch (Exception e) {
				Global.gErrMsg = e.getMessage();
				logger.warn("cannot be switched to frame.Exception: "+e.getMessage());
				return false;
			}
		}
		return false;
	}

	public static boolean switchToFrameById(String sId) {
		By objLocator = By.id(sId);
		bStatus =verifyElementVisible(objLocator);
		if (bStatus) {
			try {
				Global.driver.switchTo().frame(sId);
				logger.info("switched to frame.");
				return true;
			} catch (Exception e) {
				Global.gErrMsg = e.getMessage();
				logger.warn("cannot be switched to frame.Exception: "+e.getMessage());
				return false;
			}
		}
		return false;
	}
	
	public static boolean waitForElementPresence(By objLocator, long iTimeout) {
		try {
			Global.wait = new WebDriverWait(Global.driver, iTimeout);
			Global.wait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
			logger.info("element " + objLocator + " is present after waiting.");
			return true;
		} catch (Exception e) {
			Global.gErrMsg = e.getMessage();
			logger.warn("element " + objLocator+ " is not present after waiting " + iTimeout + ".");
		}
		return false;
	}

	public static boolean mouseOver(By objLocator) {
		WebElement wbElement = getWebElement(objLocator);
		if (wbElement == null) {
			logger.warn("The mouse over operation could not be performed on "
					+ objLocator + " due to " + Global.gErrMsg);
			return false;
		}
		Actions act = new Actions(Global.driver);
		act.moveToElement(wbElement);
		act.perform();
		logger.info("The mouse over operation on " + objLocator
				+ " has been performed successfully.");
		return true;
	}
	
	public static WebElement getWebElement(By objLocator) {
		bStatus = verifyElementVisible(objLocator);
		if (bStatus) {
			logger.info("The Element " + objLocator
					+ " is visible and can be used");
			return Global.driver.findElement(objLocator);
		}
		logger.warn("The Element " + objLocator
				+ " is not visible and cannot be used");
		return null;
	}
	
	public static boolean doubleClick(By objLocator) {
		WebElement wbElement = getWebElement(objLocator);
		if (wbElement == null) {
			logger.warn("A double-click at middle of the given element on "
					+ objLocator + " could not be performed due to "
					+ Global.gErrMsg);
			return false;
		}
		Actions act = new Actions(Global.driver);
		act.doubleClick(wbElement);
		act.perform();
		logger.info("A double-click at middle of the given element on "
				+ objLocator + " has been performed succesfully.");
		return true;
	}
	
	public static void navigateBack() {
		Global.driver.navigate().back();
	}

	public static void navigateForward() {
		Global.driver.navigate().forward();
	}

	public static void reloadPage() {
		Global.driver.navigate().refresh();
	}

	public static void deleteAllCookies() {
		Global.driver.manage().deleteAllCookies();
	}

	public static String GenerateEmailId() {
		
		 String sEmailID = "QAtester"+System.currentTimeMillis()+"@gmail.com";
		 logger.info("Generated EmailID: "+sEmailID);
		 return sEmailID; 
	}
	
	
	public static String generatePhoneNumber() {
		
		 String sPhoneNumber = "9866"+generateRandomString(6,"NUMERIC");
		 logger.info("Generated PhoneNumber: "+sPhoneNumber);
		 return sPhoneNumber; 
	}
	

	public static String generateRandomString(int length, String mode){

	StringBuffer buffer = new StringBuffer();
	String characters = "";

	switch(mode){

	case "ALPHA":
	characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	break;

	case "ALPHANUMERIC":
	characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	break;

	case "NUMERIC":
	characters = "1234567890";
	break;
	}

	int charactersLength = characters.length();

	for (int i = 0; i < length; i++) {
	double index = Math.random() * charactersLength;
	buffer.append(characters.charAt((int) index));
	}
	return buffer.toString();
	}

	public static void mouseDown(String locator){ 
	 Actions action = new Actions(Global.driver);
     action.sendKeys(Keys.PAGE_DOWN);
     try {
    	 Thread.sleep(5000);
	} catch (Exception e) {
		// TODO: handle exception
	}
     action.click(Global.driver.findElement(By.xpath("locator"))).perform();
}
	
	
	
	public static void mouseDown1(){
		
		Actions actions = new Actions(Global.driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		
	}
	
	
	
	public static boolean clickByJS(final By by) {
		WebElement element = Global.wait.until(ExpectedConditions.presenceOfElementLocated(by));
		JavascriptExecutor js = (JavascriptExecutor)Global.driver;
		js.executeScript("arguments[0].click();", element);
		logger.info("element clicked succesfully");
		return true;
		
	}
	
	public static boolean waitForElementInvisible(By objLocator,int iTimeout) {
		
		try{
			Global.gErrMsg = "";
			Global.wait=new WebDriverWait(Global.driver,iTimeout);
			Global.wait.until(ExpectedConditions.invisibilityOfElementLocated(objLocator));
			logger.info(objLocator+" element is not visible after waiting for "+iTimeout);
			return true;
		}
		catch(Exception e){
			Global.gErrMsg = e.getMessage();
			logger.warn(objLocator+" element is visible after waiting for "+iTimeout+" Exception: "+e.getMessage());
			return false;
		}
		
		
	}
	
	public static boolean switchWindow(String windowTitle) {
		
		Set<String> windows = Global.driver.getWindowHandles();

		for (String window : windows) {
			if(window.equals(windowTitle)){
				Global.driver.switchTo().window(window);
			}
			if (Global.driver.getTitle().contains(windowTitle)) {
				return true;
			}		
		}
		return false;
	}
		
	public static boolean waitForElementisClickable(By objLocator,int iTimeout){
		try{
		Global.gErrMsg = "";
		Global.wait=new WebDriverWait(Global.driver,iTimeout);
		Global.wait.until(ExpectedConditions.elementToBeClickable(objLocator));
		logger.info(objLocator+" element is clickable after waiting for "+iTimeout);
		return true;
		}
		catch(Exception e){
		Global.gErrMsg = e.getMessage();
		logger.warn(objLocator+" element is not visible after waiting for "+iTimeout+" Exception: "+e.getMessage());
		return false;
		}
		}


	}
	


	


