package com.thrymr.functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.thrymr.global.Global;
import com.thrymr.objects.Objects;
import com.thymr.constants.Constants;

public class ApplicationFunctions extends GeneralFunctions
{
	

		private static Logger logger = Logger.getLogger("ApplicationFunctions");
		private static boolean bStatus = false;


		public static boolean loginToApplication(String sUserName,String sPassword){

			bStatus = waitForElementVisibility(Objects.LoginPage.Textbox.username, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.LoginPage.Textbox.username,sUserName);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.LoginPage.Textbox.Password,sPassword);
			if(!bStatus){
				return false;
			}

			bStatus = click(Objects.LoginPage.Button.submit);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = waitForElementVisibility(Objects.homePage.Button.logout, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			return true;
		}

		public static boolean navigateToRegisterPage()
		{

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.LoginPage.Button.SignUp, Constants.iWaitTimeOut);
			if(!bStatus){
				//return false;
			}
			bStatus = GeneralFunctions.click(Objects.LoginPage.Button.SignUp);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.registerPage.Form.registerForm, Constants.iWaitTimeOut);
		if(!bStatus){
				return false;
			}
			logger.info("Register page is displayed");			
			return true;			
		}
		public static boolean NavigateToPasswordResetPage(){

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.LoginPage.link.forgotPswd, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.click(Objects.LoginPage.link.forgotPswd);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.passwordResetPage.Textbox.forgotPswdEmail, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			return true;
		}
		public static boolean EnterCredentialsInLoginPage(String sUserName,String sPassword){

			bStatus = waitForElementVisibility(Objects.LoginPage.Textbox.username, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.LoginPage.Textbox.username,sUserName);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.LoginPage.Textbox.Password,sPassword);
			if(!bStatus){
				return false;
			}

			bStatus = click(Objects.LoginPage.Button.submit);
			if(!bStatus){
				return false;
			}
			return true;
		}
		public static boolean enterCredentialsInRegisterPage(String Email,String Password){
			bStatus = waitForElementVisibility(Objects.registerPage.Textbox.email, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.registerPage.Textbox.email,Email);
			if(!bStatus){
				return false;
			}

			bStatus = enterText(Objects.registerPage.Textbox.mobilePhone,Password);
			if(!bStatus){
				return false;
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			
			

			bStatus = click(Objects.registerPage.Button.signUp);
			if(!bStatus){
				return false;
			}
			return true;
		}
		public static boolean ValidatePasswordResetPage(String Email) {

			bStatus = ApplicationFunctions.NavigateToPasswordResetPage();
			if(!bStatus){
				return false;
			}
			bStatus = enterText(Objects.passwordResetPage.Textbox.forgotPswdEmail, Email);
			if(!bStatus){
				return false;
			}
			bStatus = click(Objects.passwordResetPage.Button.sendPassword);
			if(!bStatus){
				return false;
			}
			return true;
		}
		
		public static boolean NavigateToTagChildPage(){
			
			bStatus = ApplicationFunctions.pleaseWait();
			if(!bStatus){
				return false;
			}
			
			bStatus = waitForElementVisibility(Objects.homePage.links.tagChildLink,Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = click(Objects.homePage.links.tagChildLink);
			if(!bStatus){
				return false;
			}

			bStatus = waitForElementVisibility(Objects.tagChildPage.Button.tagChildBtn, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			return true;
		}

		public static boolean ValidateTagChildPageFields(String childName,String DOB,String childDeviceID) {
			
			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName,Global.sPassword);
			if(!bStatus){
				return false;
			}
			
			bStatus = ApplicationFunctions.NavigateToTagChildPage();
			if(!bStatus){
				return false;
			}
			
			if(childName.equalsIgnoreCase("RANDOM")){
				childName = GeneralFunctions.generateRandomString(7, "ALPHA");
			
			}
			
			if(childDeviceID.equalsIgnoreCase("RANDOM")){
				childDeviceID = GeneralFunctions.generateRandomString(7, "ALPHA");
			}
			
			bStatus = GeneralFunctions.enterText(Objects.tagChildPage.TextBox.childName, childName);
			if(!bStatus){
				return false;
			
			
			}
			bStatus = GeneralFunctions.enterText(Objects.tagChildPage.TextBox.DOB, DOB);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.enterText(Objects.tagChildPage.TextBox.deviceId, childDeviceID);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.tagChildPage.Button.tagChildBtn, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.click(Objects.tagChildPage.Button.tagChildBtn);
			if(!bStatus){
				return false;
			}
			return true;
		}



		public static boolean logout() {


			bStatus = GeneralFunctions.waitForElementVisibility(Objects.homePage.Button.logout, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}


			bStatus = GeneralFunctions.clickByJS(Objects.homePage.Button.logout);
			if(!bStatus){
				return false;
			}

			return true;
		}

		public static boolean navigateToSettingsPage() {
		
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.dashboardPage.Button.settings, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}	
			bStatus = GeneralFunctions.clickByJS(Objects.dashboardPage.Button.settings);
			if(!bStatus){
				return false;
			}	
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.settingsPage.panel.blockSpecificNumbers, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}	
			//settings
			return true;	

		}
		public static boolean navigateToReportsPage() {

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.dashboardPage.Button.reports, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}	
			bStatus = GeneralFunctions.click(Objects.dashboardPage.Button.reports);
			if(!bStatus){
				return false;
			}	
			bStatus = GeneralFunctions.verifyAlertPresent();
			if (bStatus) {
				
				bStatus = GeneralFunctions.acceptAlert();
				if(!bStatus){
					return false;
				}
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.reportsPage.Button.voiceAndSms, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}	
			
			return true;	

		}

		//settings
		public static boolean blockSpecificNumber(String Contact,String fromTime,String toTime,String Day)  {
			
			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}
			
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.button.phoneBook, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.click(Objects.digitalInteractionPage.button.phoneBook);
			if(!bStatus){
				return false;
			}	
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.panel.addressBookPanel, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.click(By.xpath("//form[@id='addressBookForm']//td[text()='"+Contact+"']/preceding-sibling::td[2]"));
			if(!bStatus){
				return false;
			}	
		bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='112']"), Constants.iWaitTimeOut);
		if(!bStatus){
			return false;
		}
		bStatus = GeneralFunctions.clickByJS(By.xpath("//*[@value='112']"));
		if(!bStatus){
			return false;
		}	
		bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='Submit']"));
		if(!bStatus){
			return false;
		}	

		
			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='specificInteraction']//input[@id='startTime']"), fromTime);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='specificInteraction']//input[@id='endTime']"), toTime);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[@id='specificInteraction']//label[text()='"+Day+"']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			if (!Day.equals("")){
				bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='specificInteraction']//label[text()='"+Day+"']"));
				if(!bStatus){
					return false;
				}
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath(".//*[@id='specificInteraction']/div/div[3]/button"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.clickByJS(By.xpath("(//*[text()='SET'])[1]"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Digital interaction config has been saved']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}


			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='View Configurations']"));
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Custom Block Rule']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='Custom Block Rule']"));
			if(!bStatus){
				return false;
			}

			
			return true;
			
			}
			

		public static boolean EnterBlockSpecificNumberFields(String Contact,String fromTime,String toTime,String Day) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.button.phoneBook, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.clickByJS(Objects.digitalInteractionPage.button.phoneBook);
			if(!bStatus){
				return false;
			}	
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.panel.addressBookPanel, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//form[@id='addressBookForm']//td[text()='"+Contact+"']/preceding-sibling::td[2]"));
			if(!bStatus){
				return false;
			}	
			
			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='Submit']"));
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='specificInteraction']//input[@id='startTime']"), fromTime);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='specificInteraction']//input[@id='endTime']"), toTime);
			if(!bStatus){
				return false;
			}

			if (!Day.equals("")){
				bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='specificInteraction']//label[text()='"+Day+"']"));
				if(!bStatus){
					return false;
				}
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='specificInteraction']//button[text()='SET']"));
			if(!bStatus){
				return false;
			}
			return true;
		}
		    //settings
		public static boolean blockAllNumbers(String fromTime,String toTime,String Day) {


			
			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='allCommBlocked']//input[@id='startTime']"), fromTime);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='allCommBlocked']//input[@id='endTime']"), toTime);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[@id='allCommBlocked']//label[text()='"+Day+"']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='allCommBlocked']//label[text()='"+Day+"']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='allCommBlocked']//button[text()='SET']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Config created successfully']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='Digital Interaction']"));
			if(!bStatus){
				return false;
			}

			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='View Configurations']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='View Configurations']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='Block All Communication']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("(//*[text()='Start Time'])[2]"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("(//*[text()='End Time'])[2]"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("(//*[text()='Days:'])[2]"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			return true;
			
		}

		public static boolean EnterBlockAllNumberFields(String fromTime,String toTime,String Day) {


			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='allCommBlocked']//input[@id='startTime']"), fromTime);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.enterText(By.xpath("//div[@id='allCommBlocked']//input[@id='endTime']"), toTime);
			if(!bStatus){
				return false;
			}

			if(!Day.equals("")){
				bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='allCommBlocked']//label[text()='"+Day+"']"));
				if(!bStatus){
					return false;
				}
			}
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='allCommBlocked']//button[text()='SET']"));
			if(!bStatus){
				return false;
			}
			return true;
		}

		public static boolean communicationAlwaysAllowed(String phoneNumber) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.enterText(By.xpath("//input[@data-bind='value:phoneNumber']"), phoneNumber);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.click(By.xpath("//div[@id='alwaysAlowed']//button[text()='SET']"));
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[@id='alwaysAlowed']//span[@data-bind='text: successMessage']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[text()='View Configurations']"));
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Communication Always Allowed']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.click(By.xpath("//*[text()='Communication Always Allowed']"));
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//span[text()='"+phoneNumber+"']"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
        return true;
		}


		public static boolean enterCommunicationAlwaysAllowedFields(String phoneNumber) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.enterText(By.xpath("//input[@data-bind='value:phoneNumber']"), phoneNumber);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='alwaysAlowed']//button[text()='SET']"));
			if(!bStatus){
				return false;
			}
			return true;
		}


		public static boolean Maximum_Number_Of_SMS(String msgsLimit) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//select[@id='availableAppOptions']/option[1]"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//input[@data-bind='value:maxSms']"), msgsLimit);
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.click(By.xpath("//*[@data-bind='click:setConfig']"));
			if(!bStatus){
				return false;
			}

			return true;
		}


		public static boolean Enter_Maximum_Number_Of_SMS_Fields(String msgsLimit) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.enterText(By.xpath("//input[@data-bind='value:maxSms']"), msgsLimit);
			if(!bStatus){
				return false;
			}
			Global.driver.findElement(By.xpath("(//*[@class='panel-body'])[3]")).click();
			bStatus = GeneralFunctions.clickByJS(By.xpath("//*[@event-type='SEMSPD']"));
			if(!bStatus){
				return false;
			}
           
		
			return true;
		}


		public static boolean SMS_Barred_Content(String barredContent) {

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.textBox.blockedWords, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			
			bStatus = GeneralFunctions.enterText(Objects.digitalInteractionPage.textBox.blockedWords, barredContent);
			if(!bStatus){
				return false;
			}
			 Global.driver.findElement(By.xpath("(//*[@class='panel-body'])[3]")).click();	
			bStatus = GeneralFunctions.clickByJS(Objects.digitalInteractionPage.button.SmsBarredPanelSET);
			if(!bStatus){
				return false;
			}

			return true;
		}




		public static boolean application_Restriction(String application, String startTime,String endTime,String Day) 
		{

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.click(By.xpath("//a[text()='Application']"));
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[text()='Application Restriction']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.selectDropDownByText(By.xpath("//select[@id='allApps']"), application);

			if(!bStatus){
				return false;
			}


			bStatus = GeneralFunctions.enterText(Objects.applicationsPage.textBox.applicationStartTime, startTime);

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(Objects.applicationsPage.textBox.applicationEndTime,endTime);

			if(!bStatus){
				return false;
			}

			

			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='appSetting']//label[text()='"+Day+"']"));
			if(!bStatus){
				return false;
			}
             Global.driver.findElement(By.xpath(("//*[@class='panel-body'])[5]"))).click();
			bStatus = GeneralFunctions.click(By.xpath("//*[@data-bind='click: setAppUsageConfig']"));
			if(!bStatus){
				return false;
			}
			
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//span [text()='Config successfully saved']"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//tbody[@data-bind='foreach: blockedAppList']/tr[1]//td[1][contains(text(),'"+application+"')]"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//tbody[@data-bind='foreach: blockedAppList']/tr[1]//td[2][contains(text(),'"+startTime+"')]"));
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//tbody[@data-bind='foreach: blockedAppList']/tr[1]//td[3][contains(text(),'"+endTime+"')]"));
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//tbody[@data-bind='foreach: blockedAppList']/tr[1]//td[4][contains(text(),'"+Day+"')]"));
			if(!bStatus)
			{
				return false;
			}

			return true;
		}
		public static boolean deleteBlokedApllication(String appToDelete) {

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//td[text()='"+appToDelete+"']/parent::tr//td/button[text()='Unblock']"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.clickByJS(By.xpath("//td[text()='"+appToDelete+"']/parent::tr//td/button[text()='Unblock']"));
			if(!bStatus){
				return false;
			}
			return true;
		}

		public static boolean trackLocation(String location, String startTime, String endTime, String Day,String km) throws Exception 
		{

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}

			//bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			//if(!bStatus){
			//	return false;
			//}

			bStatus = GeneralFunctions.click(By.xpath("//a[text()='Location']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.enterText(By.xpath("//input[@id='locationTextField']"),"Gachibowli");
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[text()='Location']/parent::div//input[@id='startTime']"),startTime);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(By.xpath("//div[text()='Location']/parent::div//input[@id='endTime']"),endTime);
			if(!bStatus){
				return false;
			}

			if(!Day.equals("")){
				bStatus = GeneralFunctions.click(By.xpath("//div[@id='locationSettings']//label[text()='"+Day+"']"));
				if(!bStatus){
					return false;
				}
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//input[@data-bind='value: allowance']"),Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
	        bStatus=GeneralFunctions.click(Objects.locationPage.textBox.locationPanelAllowanceKM);
			bStatus = GeneralFunctions.enterText(Objects.locationPage.textBox.locationPanelAllowanceKM,km);
			if(!bStatus){
				return false;
			}
			Thread.sleep(5000);
			bStatus=GeneralFunctions.click(Objects.locationPage.panel.locationLogPanel);

			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[text()='Location']/parent::div//button[text()='SET']"));
			if(!bStatus){
				return false;
			}

			
			
			return true;
		}

		public static boolean NavigateToLocationPage() {

			bStatus = ApplicationFunctions.navigateToSettingsPage();

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.settingsPage.Button.location,Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.click(Objects.settingsPage.Button.location);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.locationPage.panel.LocationPanel,Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			return true;


		}
		public static boolean NavigateToApplicationsPage() {

			bStatus = ApplicationFunctions.navigateToSettingsPage();

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.click(Objects.settingsPage.Button.application);

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.applicationsPage.panel.applicationRestrictionPanel, Constants.iWaitTimeOut);

			if(!bStatus){
				return false;
			}
			return true;
		}	

		public static boolean EnterApplicationPanelFields(String application, String startTime,String endTime,String Day) {

			bStatus = ApplicationFunctions.NavigateToApplicationsPage();

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.selectDropDownByText(Objects.applicationsPage.dropDown.applicationDrpdown, application);

			if(!bStatus){
				return false;
			}


			bStatus = GeneralFunctions.enterText(Objects.applicationsPage.textBox.applicationStartTime, startTime);

			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.enterText(Objects.applicationsPage.textBox.applicationEndTime, endTime);

			if(!bStatus){
				return false;
			}

			if(!Day.equals("")){
				bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='appSetting']//label[text()='"+Day+"']"));
				if(!bStatus){
					return false;
				}
			}


			bStatus = GeneralFunctions.clickByJS(Objects.applicationsPage.Button.applicationSET);
			if(!bStatus){
				return false;
			}
			return true;

		}
		public static boolean NavigateToGenetalSettings() 
		{

			
			bStatus = GeneralFunctions.waitForElementInvisible(By.xpath("//div[@id='popup']//b[text()='Please wait...']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementisClickable(Objects.homePage.links.settings,Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.Button.generalSettings, Constants.iWaitTimeOut);
			if(!bStatus){
				bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
				if(!bStatus){
					return false;
				}
			}

			return true;


		}

		public static boolean EnterChangePswdFields(String oldPswd,String newPswd,String confirmPswd) {


			bStatus = GeneralFunctions.clickByJS(Objects.generalSettings.Button.changePassword);
			if(!bStatus)
			{	
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.textBox.oldPassword, Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				return false;
			}

			bStatus = GeneralFunctions.enterText(Objects.generalSettings.textBox.oldPassword, oldPswd);
			if(!bStatus)
			{	
				return false;
			}

			bStatus = GeneralFunctions.enterText(Objects.generalSettings.textBox.newPassword, newPswd);
			if(!bStatus)
			{	
				return false;
			}
	       
			bStatus = GeneralFunctions.enterText(Objects.generalSettings.textBox.confirmPassword, confirmPswd);
			if(!bStatus)
			{	
				return false;
			}	
		   
	        bStatus=GeneralFunctions.click(Objects.generalSettings.Button.changePassword);
			bStatus = GeneralFunctions.click(Objects.generalSettings.Button.changePswdBtn);
			if(!bStatus)
			{	
				return false;
			}
			return true;


		}
		public static boolean navigateToDigitalInteractionsPage() {


			bStatus = ApplicationFunctions.navigateToSettingsPage();

			if(!bStatus){

				return false;
			}

			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.clickByJS(Objects.settingsPage.Button.allDigitalInteractionConfigurations);
			if(!bStatus)
			{	
				return false;
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//a[text()='Block All Communication']"),Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				return false;
			}
			
			bStatus = ApplicationFunctions.pleaseWait();
			if(!bStatus){
				return false;
			}
			return true;
		}
		
		public static boolean ENterMaxAppUsageFields(String app, String maxTime, String Day) {
			
			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			if(!app.equals("")){
			bStatus = GeneralFunctions.selectDropDownByText(Objects.digitalInteractionPage.dropDown.maxAppsDropdown, app);

			if(!bStatus){
				return false;
			}
			}

	        
			bStatus = GeneralFunctions.enterText(Objects.digitalInteractionPage.textBox.maxAppUsageTime, maxTime);

			if(!bStatus){
				return false;
			}
			
			bStatus = GeneralFunctions.click(Objects.digitalInteractionPage.textBox.MaxSMSTextBox);
			if(!bStatus){
				return false;
			}
			
			if(!Day.equals("")){
				
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@id='blockSpecificApps']//label[text()='"+Day+"']"));
			if(!bStatus){
				return false;
			}
			
			}
			
			bStatus = GeneralFunctions.clickByJS(Objects.digitalInteractionPage.button.maxAppsSet);

			if(!bStatus){
				return false;
			}
			return true;

		}
		
		public static boolean pleaseWait() {
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			return true;
		}
		
		public static boolean selectDuriationInReportsPage(String Duriation) {
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[@class='button-group round toggle']//label[text()='"+Duriation+"']"), Constants.iWaitTimeOut);
			if(!bStatus){
				return false;
			}
			
			
			bStatus = GeneralFunctions.clickByJS(By.xpath("//div[@class='button-group round toggle']//label[text()='"+Duriation+"']"));
			if(!bStatus){
				return false;
			}
			bStatus = GeneralFunctions.acceptAlert();
			if(!bStatus){
				return false;
			}
			
			return true;
			
		}
		


		
	}
