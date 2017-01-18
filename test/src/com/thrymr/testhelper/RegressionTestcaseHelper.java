        package com.thrymr.testhelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.thrymr.functions.ApplicationFunctions;
import com.thrymr.functions.GeneralFunctions;
import com.thrymr.global.Global;
import com.thrymr.objects.Objects;
import com.thrymr.objects.Objects.LoginPage.Button;
import com.thymr.constants.Constants;



public class RegressionTestcaseHelper 
{
	
		private static Logger logger = Logger.getLogger("RegressionTestCaseHelper");

		static boolean bStatus = false;

		public static void DH_01_Validate_Digital_Hawk_Loginpage(){
			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.Form.loginForm);
			if(!bStatus){
				Assert.fail("Login page is not displayed. Error: "+Global.gErrMsg);
			}
			logger.info("login page is successfully displayed");
		}

		public static void DH_02_Validate_Sign_Up_Button_In_Loginpage(){

			bStatus = ApplicationFunctions.navigateToRegisterPage();
			if(!bStatus){
				Assert.fail("Registration page is not displayed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_03_Register_page_GUI_Check(){

			bStatus = ApplicationFunctions.navigateToRegisterPage();
			if(!bStatus){
				Assert.fail("Registration page is not displayed. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.registerPage.Textbox.email);
			if(!bStatus){
				Assert.fail("Email field is not present in registration page. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.registerPage.Textbox.mobilePhone);
			if(!bStatus){
				Assert.fail("Mobile field is not present in registration page. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.verifyElementVisible(Objects.registerPage.Button.signUp);
			if(!bStatus){
				Assert.fail("SineUp button is not present in registration page. Error: "+Global.gErrMsg);
			}	

		}
		
		//This test case covers all registeration page tcs
		public static void verifyRegisterpage(String username,String Phone,String Expected,String ErrMsg)
		{

			bStatus = ApplicationFunctions.navigateToRegisterPage();
			if(!bStatus){
				Assert.fail("Registration page is not displayed. Error: "+Global.gErrMsg);
			}

			if(username.equalsIgnoreCase("Random")){
				username = GeneralFunctions.GenerateEmailId();
			}

			if(Phone.equalsIgnoreCase("Random")){
				Phone = GeneralFunctions.generatePhoneNumber();
			}

			bStatus = ApplicationFunctions.enterCredentialsInRegisterPage(username,Phone);
			if(!bStatus)
			{
				Assert.fail("Failed while entering data in register page");
			}

			if(!ErrMsg.equals("") &&  Expected.equalsIgnoreCase("fail")){
				String ErrMsgScreen = Objects.registerPage.ErrMsg.errMsgRegisterPage.replace("XXX",ErrMsg);
				By errMsgLocator = By.xpath(ErrMsgScreen);
				bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator, Constants.iErrMsgTimeout);
				if(!bStatus){
					Assert.fail(ErrMsg+": Error Message not displayed");
				}
			}
			else{
				bStatus = GeneralFunctions.waitForElementVisibility(Objects.LoginPage.Button.SignUp, Constants.iWaitTimeOut);
				if(!bStatus){
					Assert.fail("Registration Failed with Valid Credentials");
				}
			}
		}

		public static void verifyLoginpage(String username,String password,String Expected,String ErrMsg)
		{
			if(username.equalsIgnoreCase("GLOBAL")){
				username = Global.sUserName;
			}

			if(password.equalsIgnoreCase("GLOBAL")){
				password = Global.sPassword;
			}

			boolean bStatus = ApplicationFunctions.EnterCredentialsInLoginPage(username, password);
			if(!bStatus){
				Assert.fail("Unable to enter credentials in login fields. Error: "+Global.gErrMsg);
			}

			if(Expected.equalsIgnoreCase("fail")){
				if(ErrMsg.contains("Please re-enter") || ErrMsg.contains("Looks like you don't have a familyhawk ")){
					String alertMsg = "//strong[text()=' Error:']";
					By errMsgLocator = By.xpath(alertMsg);
					bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator, Constants.iErrMsgTimeout);
					if(!bStatus){
						Assert.fail(ErrMsg+": Error Message not displayed");
					}
				}
				
				else{
					if(ErrMsg.contains(":")){
						String ErrMsgs[] = ErrMsg.split(":");
						String ErrMsgScreen = Objects.registerPage.ErrMsg.errMsgRegisterPage.replace("XXX",ErrMsgs[0]);
						By errMsgLocator = By.xpath(ErrMsgScreen);
						bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator, Constants.iErrMsgTimeout);
						if(!bStatus){
							Assert.fail(ErrMsgs[0]+": Error Message not displayed");
						}

						String ErrMsgScreen2 = Objects.registerPage.ErrMsg.errMsgRegisterPage.replace("XXX",ErrMsgs[1]);
						By errMsgLocator2 = By.xpath(ErrMsgScreen2);
						bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator2, Constants.iErrMsgTimeout);
						if(!bStatus){
							Assert.fail(ErrMsgs[1]+": Error Message not displayed");
						}
					}
					else{
						String ErrMsgScreen = Objects.registerPage.ErrMsg.errMsgRegisterPage.replace("XXX",ErrMsg);
						By errMsgLocator = By.xpath(ErrMsgScreen);
						bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator, Constants.iErrMsgTimeout);
						if(!bStatus){
							Assert.fail(ErrMsg+": Error Message not displayed");
						}
					}
				}
			}

			else{
				bStatus = GeneralFunctions.waitForElementVisibility(Objects.homePage.Button.logout, Constants.iWaitTimeOut);
				if(!bStatus){
					Assert.fail("Login Failed with Valid Credentials");
				}
			}
		}

		public static void DH_11_Validate_login_Page_GUI () {

			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.Textbox.username);
			if(!bStatus){
				Assert.fail("Email field is not present in login page. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.Textbox.Password);
			if(!bStatus){
				Assert.fail("Password field is not present in login page. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Button.submit);
			if(!bStatus){
				Assert.fail("submit button is not present in login page. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.Button.SignUp);
			if(!bStatus){
				Assert.fail("Sign Up button is not present in login page. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.link.forgotPswd);
			if(!bStatus){
				Assert.fail("forgot password link is not present in login page. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_18_Validatye_Forgot_Password_link_in_Login_page () {

			bStatus = GeneralFunctions.verifyElementVisible(Objects.LoginPage.link.forgotPswd);
			if(!bStatus){				
				Assert.fail("Login page should contain forgot password link. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_19_Validate_Forgot_Password_link_in_Login_page() {

			bStatus = ApplicationFunctions.NavigateToPasswordResetPage();
			if(!bStatus){
				Assert.fail("Should navigate to password reset page. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_20_Verify_GUI_objects_in_Password_Reset_page () {

			bStatus = ApplicationFunctions.NavigateToPasswordResetPage();
			if(!bStatus){
				Assert.fail("Should navigate to password reset page. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.passwordResetPage.Textbox.forgotPswdEmail);
			if(!bStatus){
				Assert.fail("Password Reset page should contain forgotPswdEmail field. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.passwordResetPage.Button.sendPassword);
			if(!bStatus){
				Assert.fail("Password Reset page should contain Send Password button. Error: "+Global.gErrMsg);
			}				

		}

		public static void DH_21_Validate_Send_button_functionality_with_invalid_data_of_email_in_Password_Rest_Page() {

			bStatus = ApplicationFunctions.ValidatePasswordResetPage("7856486");
			if(!bStatus){
				Assert.fail("Validation is not happened in password reset page. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//span[text()='Please verify the email address']"), Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msg is not displayed after 30s Please verify the email address. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_22_Validate_Send_button_functionality_with_no_data_of_email_in_Password_Rest_Page () {

			bStatus = ApplicationFunctions.ValidatePasswordResetPage(Global.empty);
			if(!bStatus){
				Assert.fail("Validation is not happened in password reset page. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.waitForElementVisibility(Objects.passwordResetPage.ErrMsg.errMsgResetPswd, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msg is not displayed after 30s Please enter email address to continue. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_23_Validate_Send_button_functionality_with_valid_email_in_Password_Reset_page() {

			bStatus = ApplicationFunctions.ValidatePasswordResetPage(Global.sUserName);
			if(!bStatus){
				Assert.fail("Validation is not happened in password reset page. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.passwordResetPage.successMsg.successMessage, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Success messag should display. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_24_Verify_GUI_objects_in_dashboard_page() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("login to application is failed. Error: "+Global.gErrMsg);
			}
			String[] list = {"tagChildPage", "dashPage", "setPage", "childPage", "profPage"};
			for ( String listValue: list) {
				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//li[@id='"+listValue+"']"));
				if(!bStatus){
					Assert.fail("Home page should contain "+listValue+" in navigation bar. Error: "+Global.gErrMsg);
				}

			}
		}

		public static void DH_25_Verify_GUI_Objects_Of_Tag_New_Child_Page() {
			// cerate a new child

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToTagChildPage();
			if(!bStatus){
				Assert.fail("Navigation to Tag Child page is failed. Error: "+Global.gErrMsg);
			}
			String[] list = {"name", "dob", "deviceId"};
			for ( String listValue: list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//input[@id='"+listValue+"']"));
				if(!bStatus)
				{
					Assert.fail("Tag child page should contain "+listValue+" . Error: "+Global.gErrMsg);
				}	
			}
		}
            //26
		public static void VerifyTagChildDetails(String childname,String dob,String childDevice,String Expected,String ErrMsg) {
			bStatus = ApplicationFunctions.ValidateTagChildPageFields(childname, dob, childDevice);
			if(!bStatus){
				Assert.fail("Failed while entering data in Tag Child page fields. Error: "+Global.gErrMsg);
			}

			if(Expected.equals("fail")){
				String[] Errmsgs = ErrMsg.split(":");
				for (int MsgCount = 0; MsgCount < Errmsgs.length; MsgCount++) {
					String msg[] = Errmsgs[MsgCount].split("child's");
					String ErrMsgScreen = "//span[@class='app--validation--error-message' and contains(text(),'"+msg[1].trim()+"')]";
					By errMsgLocator = By.xpath(ErrMsgScreen);
					bStatus = GeneralFunctions.waitForElementVisibility(errMsgLocator,Constants.iErrMsgTimeout);
					if(!bStatus){
						Assert.fail(Errmsgs[MsgCount]+": Error Message not displayed");
					}
				}
			}
			else{
				//wait for success message
			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{
				Assert.fail("Logout from application is failed. Error: "+Global.gErrMsg);
			}	


		}


		public static void DH_32_Verify_GUI_Objects_Of_Dashboard_Page() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("login to application is failed. Error: "+Global.gErrMsg);
			}	

			String[] listBtns = {"Location", "Reports", "Settings"};
			{
				for ( String listValue: listBtns) {
					bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[@ event-type='REDASH']"), Constants.iWaitTimeOut);
					if(!bStatus){
						Assert.fail("Dashboard page should contain "+listValue+" field. Error: "+Global.gErrMsg);
					}		
				}
			}
			String[] list = {"Voice Call/SMS", "App Usage", "Web Browsing", "Location", "Contacts"};
			{
				for ( String listValue: list) {
					bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//li[text()='"+listValue+"']"));
					if(!bStatus){
						Assert.fail("Home page should contain "+listValue+" in navigation bar. Error: "+Global.gErrMsg);
					}
				}
			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout from application is failed. Error: "+Global.gErrMsg);
			}	
		}

		// need to change(under progress)

		/*public static void DH_33_Verify_Location_Button_Navigation_In_Dashboard_Page () {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("Login functionality is failed. Error: "+Global.gErrMsg);
			}	
			
			bStatus = ApplicationFunctions.pleaseWait();
			if(!bStatus)
			{	
				Assert.fail("Please wait is visible after 30s. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.waitForElementVisibility(Objects.dashboardPage.Button.location, Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("location button is not present in dashboard page. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//*[@class='alert alert-danger padding-tb-5 margin-bottom-15']"));
			if(!bStatus){
				
		    bStatus = GeneralFunctions.click(Objects.dashboardPage.Button.location);
		    if(!bStatus)
				{	
					Assert.fail("Click action is not performed on settings button. Error: "+Global.gErrMsg);
				}
              /*  
				}
				bStatus = GeneralFunctions.switchWindow("Google maps");
				if(!bStatus)
				{	
					Assert.fail("window switching to AsusTracking page is failed. Error: "+Global.gErrMsg);
				}
				
				
				String windowTitle = Global.driver.getTitle();
				Assert.assertEquals(windowTitle, "Google maps");

			}
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}*/



		public static void DH_34_Verify_Reports_Button_Navigation_In_Dashboard_Page(){

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("Login functionality is failed. Error: "+Global.gErrMsg);
			}	
			bStatus = ApplicationFunctions.navigateToReportsPage();
			if(!bStatus)
			{	
				Assert.fail("navigateToReportsPage is failed. Error: "+Global.gErrMsg);
			}

		}



		public static void DH_35_Dashboard_Settings_Button_Navigation_In_Dashboard_Page() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Login failed:");
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_36_Configuration_Page_GUI_Check_By_Clicking_Setting_Button_Of_Dashboard () {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Login failed:");
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.digitalInteraction);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain digitalInteraction button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.location);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain location button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.application);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain application button. Error: "+Global.gErrMsg);
			}
            bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.webbrowser);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain application button. Error: "+Global.gErrMsg);
			}
            bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.facebook);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain application button. Error: "+Global.gErrMsg);
			}

		}


		public static void DH_37_Configuration_Page_BlockSpecificNumber_Panel_GUI() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Login failed:");
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}


			//create a child 

			bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.panel.blockSpecificNumbers);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain blockSpecificNumbers panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.dropDown.contacts);
			if(!bStatus)
			{	
				Assert.fail(" blockSpecificNumbers panel should contacts dropdown. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.blockSpecificNumStartTime);
			if(!bStatus)
			{	
				Assert.fail(" blockSpecificNumbers panel should contain Start Time textbox. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.blockSpecificNumEndTime);
			if(!bStatus)
			{	
				Assert.fail(" blockSpecificNumbers panel should contain End Time textbox. Error: "+Global.gErrMsg);
			}


			String[] list = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
			for ( String listValue: list) {
				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//div[@id='specificInteraction']/div/div[2]/div[6]/div/span/label[text()='"+listValue+"']"));
				if(!bStatus){
					Assert.fail("blockSpecificNumbers panel should contain "+listValue+" button. Error: "+Global.gErrMsg);
				}
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.blockSpecificNumSET);

			if(!bStatus)
			{	
				Assert.fail(" blockSpecificNumbers panel should contain SET button. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_38_Configuration_Page_BlockSpecificNumber_Panel_with_no_DAY() {

			//create a child 
			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterBlockSpecificNumberFields("112", "02:00 PM", "04:00 PM", "");

			if(!bStatus)
			{	
				Assert.fail("Failed while entering data in BlockSpecificNumber Panel . Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.blockSpecificNumDAY);

			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Select at least one day. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

	


				//Settings Page_digital_interaction
		public static void DH_42_Verify_Block_Specific_Number_Functionality_In_Digital_Interaction_Tab_Of_Configuration_Page()  {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.blockSpecificNumber("112", "12:00 PM", "02:00 PM", "MON");
			if(!bStatus)
			{	
				Assert.fail("block Specific Number functionality is failed. Error: "+Global.gErrMsg);
			}	
              try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		bStatus = GeneralFunctions.click(By.xpath("//*[@id='customBlockRule']/div[3]/div/div[2]/table/tbody/tr/td[6]/button"));

			if(!bStatus)
			{	
				Assert.fail("Delete functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}	

		public static void DH_43_Block_All_Numbers_Panel_GUI_Test_Case() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.panel.blockAllNumPanel);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain blockAllNumbers panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.blockAllNumStartTime);
			if(!bStatus)
			{	
				Assert.fail("blockAllNumPanel should contain Start Time text box. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.blockAllNumEndTime);
			if(!bStatus)
			{	
				Assert.fail("blockAllNumPanel should contain End Time text box. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.blockAllNumSET);
			if(!bStatus)
			{	
				Assert.fail("blockAllNumPanel should contain SET button. Error: "+Global.gErrMsg);
			}

			
			if(!bStatus)
				bStatus = GeneralFunctions.click(By.xpath("(//*[text()='Unblock'])[2]"));
			{
			Assert.fail("Delete functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

			}
		


		public static void DH_44_Block_All_Numbers_Panel_With_No_DAY() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterBlockAllNumberFields("02:00PM", "06:00PM", "");
			if(!bStatus)
			{	
				Assert.fail("blockAllNumbers functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.BlockAllNumsDay);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Please select at least one day. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_45_Block_All_Numbers_Panel_With_No_DateRange() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterBlockAllNumberFields("", "", "SUN");
			if(!bStatus)
			{	
				Assert.fail("blockAllNumbers functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.BlockAllNumStartTime);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Please enter start time. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.BlockAllNumEndTime);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Please enter end time. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_46_Block_All_Numbers_Panel_with_No_startTime() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterBlockAllNumberFields("", "02:00PM", "SUN");
			if(!bStatus)
			{	
				Assert.fail("blockAllNumbers functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.BlockAllNumStartTime);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Please enter start time. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}
		public static void DH_47_Block_All_Numbers_Panel_with_No_endTime() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterBlockAllNumberFields("02:00PM", "", "SUN");
			if(!bStatus)
			{	
				Assert.fail("blockAllNumbers functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.BlockAllNumEndTime);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Please enter End time. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}


		//Settings page digital interaction block all communication configuration
		public static void DH_48_Validate_Block_All_Numbers_Functionality_In_Digital_Interaction_Settings_Tab_Of_Configuration_Page() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}
			bStatus = ApplicationFunctions.blockAllNumbers("1:00 PM", "05:00 PM", "MON");
			if(!bStatus)
			{	
				Assert.fail("block All Numbers functionality is failed. Error: "+Global.gErrMsg);
			}

			//bStatus = GeneralFunctions.click(By.xpath("(//*[text()='Unblock'])[2]"));

			//if(!bStatus)
			//{	
				//Assert.fail("Delete functionality is failed. Error: "+Global.gErrMsg);
			//}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_49_Communication_Always_Allowed_Panel_GUI() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}	

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.panel.CommunicationalwaysAlowedPanel);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain CommunicationalwaysAlowedPanel panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.CommunicationalwaysAlowedPhoneNum);
			if(!bStatus)
			{	
				Assert.fail("CommunicationalwaysAlowedPanel should contain  Phone Number field. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.CommunicationalwaysAlowedSET);
			if(!bStatus)
			{	
				Assert.fail("CommunicationalwaysAlowedPanel should contain  SET button. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}



		public static void DH_50_Validate_Phone_Number_Field_With_Invalid_Data_Characters_In_Communication_Always_Allowed_Panel_In_Settings_Of_Dashboard () {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.enterCommunicationAlwaysAllowedFields("invaliData");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering daat in communicationAlwaysAllowed panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.CommunicationalwaysAlowed);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Phone number should be consisting of numbers only and of 10 digits. Error: "+Global.gErrMsg);
			}

		}


		public static void DH_51_Validate_Phone_Number_Field_With_SpecialsCharacters_In_Communication_Always_Allowed_Panel_In_Settings_Of_Dashboard() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.enterCommunicationAlwaysAllowedFields("*&(%$%^$%^$%$");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering daat in communicationAlwaysAllowed panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.CommunicationalwaysAlowed);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Phone number should be consisting of numbers only and of 10 digits. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_52_Validate_Phone_Number_Field_With_Invalid_Data_less_than_10_digits_In_Communication_Always_Allowed_Panel() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.enterCommunicationAlwaysAllowedFields("765876");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering daat in communicationAlwaysAllowed panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.CommunicationalwaysAlowed);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Phone number should be consisting of numbers only and of 10 digits. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_53_Communication_Always_Allowed_panel_valid_data_moreThan10() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.enterCommunicationAlwaysAllowedFields("765876895864568");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering daat in communicationAlwaysAllowed panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.CommunicationalwaysAlowed);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Phone number should be consisting of numbers only and of 10 digits. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_54_Communication_Always_Allowed_panel_With_DigitsAndSpecialChars() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.enterCommunicationAlwaysAllowedFields("7658768&*^*&%^&%");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering daat in communicationAlwaysAllowed panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.errMsg.CommunicationalwaysAlowed);
			if(!bStatus)
			{	
				Assert.fail("Error msg should display as Phone number should be consisting of numbers only and of 10 digits. Error: "+Global.gErrMsg);
			}

		}
		//Settings Page_digital_interaction
		public static void DH_55_Communication_Always_Allowed_Positive() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.communicationAlwaysAllowed("2612");
			if(!bStatus)
			{	
				Assert.fail("block All Numbers functionality is failed. Error: "+Global.gErrMsg);
			}

			//bStatus = GeneralFunctions.click(By.xpath("(//*[text()='Unblock'])[13]"));

			//if(!bStatus)
			//{	
				//Assert.fail("Delete functionality is failed. Error: "+Global.gErrMsg);
			//}


			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_56_Maximum_No_Of_Sms_Panel_GUI() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.panel.MaxSMSPanel);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain Max No  of SMS Panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.MaxSMSTextBox);
			if(!bStatus)
			{	
				Assert.fail("Max No  of SMS Panel should contain max No of SMS text box. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.MaxSMSPanelSET);
			if(!bStatus)
			{	
				Assert.fail("Max No  of SMS Panel should contain SET button. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}
		public static void DH_57_max_sms_Positive() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.Maximum_Number_Of_SMS("29");
			if(!bStatus)
			{	
				Assert.fail("maximun no of sms functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Monitor Max Number of SMS has been saved']"), Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Success msg is not displayed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}


		public static void DH_58_max_sms_invalid_data() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.Enter_Maximum_Number_Of_SMS_Fields("eh");
			if(!bStatus)
			{	
				Assert.fail("maximun no of sms functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.errMsg.MaxSMSPanel,Constants.iWaitTimeOut);
			if(!bStatus)//*[text()='Blocked content been saved']
			{	
				Assert.fail("Error msg Should display as Should contain only digits. Error: "+Global.gErrMsg);
			}


			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		//SMS barred Content panel

		public static void DH_59_Sms_Barred_Content_Panel_GUI_Test_Cases() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("Setting page is not displayed. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.panel.SmsBarredPanel);
			if(!bStatus)
			{	
				Assert.fail("Setting page should contain SmsBarredPanel panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.blockedWords);
			if(!bStatus)
			{	
				Assert.fail("SmsBarredPanel panel should contain  blockedWords. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.SmsBarredPanelSET);
			if(!bStatus)
			{	
				Assert.fail("SmsBarredPanel should contain SET button. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_60_SMS_barred_content_no_data() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus){
				Assert.fail("navigateToSettingsPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.textBox.blockedWords, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Max sms text box is not visible. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.enterText(Objects.digitalInteractionPage.textBox.blockedWords, "");
			if(!bStatus){
				Assert.fail("Text is not entered in Max sms text box Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.clickByJS(Objects.digitalInteractionPage.button.SmsBarredPanelSET);
			if(!bStatus){
				Assert.fail("Click is not performed on SmsBarredPanelSET. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//span[text()='Please enter atleast one word']"),Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("Error message should display as Please enter at least one word. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

			//Settings Page_digital_interaction
			public static void DH_61_blocked_words() {

				bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
				if(!bStatus)
				{	
					Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
				}

				bStatus = ApplicationFunctions.SMS_Barred_Content("jkhhjgf");
				if(!bStatus)
				{	
					Assert.fail("SMS_Barred_Content functionality is failed. Error: "+Global.gErrMsg);
				}

               
               
				
				bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Blocked content been saved']"), Constants.iWaitTimeOut);
				if(!bStatus){
					Assert.fail("Success msg should display. Error: "+Global.gErrMsg);
				}

				bStatus = ApplicationFunctions.logout();
				if(!bStatus)
				{	
					Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
				}

		}
		//Maximum App usage per Day Panel

		public static void DH_62_Maximun_App_UsagePanel_GUI() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();
			if(!bStatus)
			{	
				Assert.fail("navigateToSettingsPage is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.dropDown.maxAppsDropdown);
			if(!bStatus)
			{	
				Assert.fail("digitalInteractionPage should contain maxAppsDropdown. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.textBox.maxAppUsageTime);
			if(!bStatus)
			{	
				Assert.fail("digitalInteractionPage should contain maxAppUsageTime. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionPage.button.maxAppsSet);
			if(!bStatus)
			{	
				Assert.fail("digitalInteractionPage should contain maxAppsSet. Error: "+Global.gErrMsg);
			}


			String[] list = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
			for ( String listValue: list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//div[@id='blockSpecificApps']//label[text()='"+listValue+"']"));
				if(!bStatus)
				{

					Assert.fail("Location panel should contain "+listValue+" button. Error: "+Global.gErrMsg);
				}
			}
			
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_63_Max_App_Usage_Missing_UsageTime() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.ENterMaxAppUsageFields("Calculator", "", "SUN");
			if(!bStatus){
				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.errMsg.ErrMaxAppUsageTime,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msh should display as Select the time. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_64_Max_App_Usage_Missing_App() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.ENterMaxAppUsageFields("", "04:38", "SUN");
			if(!bStatus){

				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.errMsg.ErrMaxAppUsageApp,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msh should display as Please select at least one app. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_65_Max_App_Usage_Missing_Day() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.ENterMaxAppUsageFields("Calculator", "04:07", "");
			if(!bStatus){

				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.errMsg.ErrMaxAppUsageDay,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msh should display as Select at least one day. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_66_Max_App_Usage_Positive() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.ENterMaxAppUsageFields("Drive", "05:07", "SUN");

			if(!bStatus){

				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.digitalInteractionPage.successMsg.SuccessMsgMaxAppUsage,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Success msg should display as Apps usage limit config has been saved. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.clickByJS(Objects.settingsPage.Button.allDigitalInteractionConfigurations);
			if(!bStatus)
			{	
				Assert.fail("Click action is not performed on allDigitalInteractionConfigurations button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Maximum App usage per Day']"),Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("AllDigitalInteractionConfigurations page should display. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.pleaseWait();
			if(!bStatus)
			{	
				Assert.fail("Please wait msg is displayed for long time. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//*[text()='Maximum App usage per Day']"),Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("MaxAppUsageLimit panel is not displayed. Error: "+Global.gErrMsg);
			}

			
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		//Location
		public static void DH_67_ConfigurationPage_Location_Page_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus)
			{	
				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.panel.locationLogPanel);
			if(!bStatus)
			{	
				Assert.fail("Location page should contain locationLogPanel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.panel.LocationPanel);
			if(!bStatus)
			{	
				Assert.fail("Location page should contain LocationPanel. Error: "+Global.gErrMsg);
			}


			String[] list = {"Address", "Map", "Allowed Range(KM)", "Action"};
			for ( String listValue: list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//div[@id='locationSettings']//th[text()='"+listValue+"']"));
				if(!bStatus)
				{

					Assert.fail("Location page should contain "+listValue+" table header. Error: "+Global.gErrMsg);
				}

			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_68_ConfigurationPage_Location_tab_location_panel_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus)
			{	
				Assert.fail("NavigateToLocationPage functionality is failed. Error: "+Global.gErrMsg);
			}


			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.textBox.locationPanelLocationField);
			if(!bStatus)
			{	
				Assert.fail("LocationPanel should contain LocationField. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.textBox.locationPanelStartTime);
			if(!bStatus)
			{	
				Assert.fail("LocationPanel should contain Start time text field. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.textBox.locationPanelEndTime);
			if(!bStatus)
			{	
				Assert.fail("LocationPanel should contain End time text field. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.textBox.locationPanelAllowanceKM);
			if(!bStatus)
			{	
				Assert.fail("LocationPanel should contain AllowanceKM text field. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.locationPage.Button.locationPanelSET);
			if(!bStatus)
			{	
				Assert.fail("LocationPanel should contain locationPanelSET button. Error: "+Global.gErrMsg);
			}


			String[] list = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
			for ( String listValue: list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//label[@for='LocationDays']/parent::div//label[text()='"+listValue+"']"));
				if(!bStatus)
				{

					Assert.fail("Location panel should contain "+listValue+" button. Error: "+Global.gErrMsg);
				}


			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_69_Location_tab_location_panel_Missing_StartTime() throws Exception {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.trackLocation("Gachibowli", "", "6:00 PM", "MON", "10");
			if(!bStatus)
			{	
				Assert.fail("track_location functionality is failed. Error: "+Global.gErrMsg);
			}
			Thread.sleep(5000);

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.locationPage.errMsg.locationPanelErrStartTime,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msg should display as Please mention start time. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}
		}

		public static void DH_70_Location_tab_location_panel_Missing_EndTime() throws Exception
		{

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.trackLocation("Gachibowli", "6:00 PM", "", "MON", "10");
			if(!bStatus)
			{	
				Assert.fail("track_location functionality is failed. Error: "+Global.gErrMsg);
			}

			//bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//div[text()='Location']/parent::div//p[text()='Please mention end time']"),Constants.iWaitTimeOut);
			//if(!bStatus){
				//Assert.fail("Error msh should display as Please mention end time. Error: "+Global.gErrMsg);
			//}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}
		}

		public static void DH_71_Location_tab_location_panel_Missing_Day() throws Exception
		{

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.trackLocation("Gachibowli", "6:00 PM", "6:00 PM", "", "10");
			if(!bStatus)
			{	
				Assert.fail("track_location functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.locationPage.errMsg.locationPanelErrDay,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msg should display as Please mention start time. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}


		}


		public static void DH_72_Location_tab_location_panel_Missing_Allowance_KM() throws Exception
		{

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.trackLocation("Gachibowli", "6:00 PM", "6:00 PM", "SUN", "");
			if(!bStatus)
			{	
				Assert.fail("track_location functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.locationPage.errMsg.locationPanelErrAllowanceKM,Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error msh should display as Please enter allowed distance. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}
		}

		public static void DH_73_ConfigurationPage_Location_tab_Location_Monitoring_MissingData() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus){
				Assert.fail("Location page navigation failed. Error: "+Global.gErrMsg);
			}

			bStatus =GeneralFunctions.enterText(By.xpath("//input[@id='newInterval']"), "");
			if(!bStatus){
				Assert.fail("Enter text in log interval failed failed. Error: "+Global.gErrMsg);
			}

			bStatus =GeneralFunctions.clickByJS(Objects.locationPage.Button.logIntervalSet);
			if(!bStatus){
				Assert.fail("Click is not performed on logIntervalSet button. Error: "+Global.gErrMsg);
			}

			bStatus =GeneralFunctions.waitForElementVisibility(By.xpath("//span[text()='Please enter an interval']"),Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Error should display as//span[text()='Please enter an interval'] . Error: "+Global.gErrMsg);
			}	
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}

		}

		public static void DH_74_ConfigurationPage_Location_tab_Location_Monitoring_InavlidData() throws Exception {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus){
				Assert.fail("Location page navigation failed. Error: "+Global.gErrMsg);
			}
            bStatus=GeneralFunctions.click(By.xpath("//input[@id='newInterval']"));
			bStatus =GeneralFunctions.enterText(By.xpath("//input[@id='newInterval']"), "char");
			if(!bStatus){
				Assert.fail("Enter text in log interval failed failed. Error: "+Global.gErrMsg);
			}
			Thread.sleep(5000);
            bStatus=GeneralFunctions.click(Objects.locationPage.panel.LocationPanel);
			bStatus =GeneralFunctions.clickByJS(Objects.locationPage.Button.logIntervalSet);
			if(!bStatus){
				Assert.fail("Clcik action is not performes on logIntervalSet btn. Error: "+Global.gErrMsg);
			}
			
			bStatus =GeneralFunctions.verifyElementVisible(By.xpath("//span[text()='Interval must be numeric']"));
			if(!bStatus){
				Assert.fail("Location unable to set. Error: "+Global.gErrMsg);
			}	
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);

			}

		}

		public static void DH_75_track_location() throws Exception {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.trackLocation("Gachibowli", "12:00 PM", "6:00 PM", "MON", "15");
			if(!bStatus)
			{	
				Assert.fail("track_location functionality is failed. Error: "+Global.gErrMsg);
			}
            
            
			bStatus = GeneralFunctions.waitForElementVisibility(By.xpath("//span[text()='Config created successfully']"),Constants.iWaitTimeOut);
			if(!bStatus)
			{
				Assert.fail("Success msg should display as . Error: "+Global.gErrMsg);
			}


			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_76_track_location_Delete() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus){
				Assert.fail("Location page navigation failed. Error: "+Global.gErrMsg);
			}			

			bStatus = GeneralFunctions.clickByJS(By.xpath("(//*[text()='Unblock'])[1]"));

			if(!bStatus)
			{	
				Assert.fail("Delete functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.waitForElementInvisible(Objects.settingsPage.msg.pleaseWaitMsg, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Please wait is displayed for long time. Error: "+Global.gErrMsg);
			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_78_Location_Monitering_panel_valid_data() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToLocationPage();
			if(!bStatus){
				Assert.fail("Location page navigation failed. Error: "+Global.gErrMsg);
			}			
			bStatus=GeneralFunctions.waitForElementVisibility(Objects.locationPage.textBox.logInterval,Constants.iWaitTimeOut);
			bStatus = GeneralFunctions.enterText(Objects.locationPage.textBox.logInterval, "24");

			if(!bStatus)
			{	
				Assert.fail("Unable to enter data in the field. Error: "+Global.gErrMsg);
			}
			
            bStatus=GeneralFunctions.waitForElementVisibility(Objects.locationPage.Button.logIntervalSet,Constants.iWaitTimeOut);
            Global.driver.findElement(By.xpath("(//*[@class='panel-body col2 colHeight'])[2]")).click();
			bStatus = GeneralFunctions.clickByJS(Objects.locationPage.Button.logIntervalSet);

			if(!bStatus)
				
			{	
				Assert.fail("Click action is not performed on SET button of Log interval panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.locationPage.successMsg.logIntervalSuccessMsg, Constants.iWaitTimeOut);

			if(!bStatus)
			{	
				Assert.fail("Success mag should display as Location Monitoring interval has been saved. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}


		//Application Page

		public static void DH_79_ConfigurationPage_Application_tab_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.NavigateToApplicationsPage();
			if(!bStatus){
				Assert.fail("Application page navigation failed. Error: "+Global.gErrMsg);
			}	

			bStatus = GeneralFunctions.verifyElementVisible(Objects.applicationsPage.dropDown.applicationDrpdown);
			if(!bStatus){
				Assert.fail("Application Restriction panel should contain application dropdown. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.applicationsPage.textBox.applicationStartTime);
			if(!bStatus){
				Assert.fail("Application Restriction panel should contain start time text box. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.applicationsPage.textBox.applicationEndTime);
			if(!bStatus){
				Assert.fail("Application Restriction panel should contain end time text box. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.applicationsPage.Button.applicationSET);
			if(!bStatus){
				Assert.fail("Application Restriction panel should contain SET button. Error: "+Global.gErrMsg);
			}

			String[] list = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
			for ( String listValue: list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//div[text()='Application Restriction']/parent::div//label[text()='"+listValue+"']"));
				if(!bStatus)
				{

					Assert.fail("Location panel should contain "+listValue+" button. Error: "+Global.gErrMsg);
				}


			}

		}

		public static void DH_80_Application_Restriction_Panel_with_no_Start_time() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterApplicationPanelFields("Contacts", "", "07:00 PM", "SUN");
			if(!bStatus){
				Assert.fail("Failed while entering data in Application Restriction panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.applicationsPage.ErrMsg.ErrAppStartTime, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Err msg should display as Please mention start time. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_81_Application_Restriction_Panel_with_no_End_time() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterApplicationPanelFields("Contacts", "07:00 PM", "", "SUN");
			if(!bStatus){
				Assert.fail("Failed while entering data in Application Restriction panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.applicationsPage.ErrMsg.ErrAppEndTime, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Err msg should display as Please mention end time. Error: "+Global.gErrMsg);
			}


		}

		public static void DH_82_Application_Restriction_Panel_with_no_Day() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterApplicationPanelFields("Contacts", "07:00 PM", "08:00 PM", "");
			if(!bStatus){
				Assert.fail("Failed while entering data in Application Restriction panel. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.applicationsPage.ErrMsg.ErrAppDay, Constants.iWaitTimeOut);
			if(!bStatus){
				Assert.fail("Err msg should display as Please select at least one day. Error: "+Global.gErrMsg);
			}
		}


		// In progress
		/*public static void DH_83_Application_Restriction(){

			bStatus = ApplicationFunctions.NavigateToApplicationsPage();

			if(!bStatus)
			{	
				Assert.fail("Navigation to Applications page is failed. Error: "+Global.gErrMsg);
			}
		}
		{
		}*/


		public static void DH_83_Block_UnBlock_App() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.application_Restriction(Global.appToBlock,"07:00 PM", "08:00 PM","FRI");
			if(!bStatus)
			{	
				Assert.fail("Blocking app functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.deleteBlokedApllication(Global.appToBlock);

			if(!bStatus)
			{	
				Assert.fail("deleteBlokedApllication functionality is failed. Error: "+Global.gErrMsg);
			}
			try {
				Thread.sleep(10000);

			} catch (Exception e) {
				// TODO: handle exception
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_84_Verify_GUI_Of_Settings_Page  () 
		{
			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}

			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.generalSettings.Button.generalSettings);
			if(!bStatus)
			{	
				Assert.fail("GenetalSettings page should contain generalSettings button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.generalSettings.Button.changePassword);
			if(!bStatus)
			{	
				Assert.fail("GenetalSettings page should contain changePassword button. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_85_Verify_General_Settings_Tab_GUI_Objects  () 
		{

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}
			
			// create child should done here 

			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}

			

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.Button.startMonitoring,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				bStatus = GeneralFunctions.verifyElementVisible(Objects.generalSettings.Button.stopMonitoring);	
				if(!bStatus)
				{
					Assert.fail("GenetalSettings page should contain either stopMonitoring or startMonitoring button. Error: "+Global.gErrMsg);
				}
			}

			

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_86_Validate_Change_Password_Tab_GUI_Objects  () {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}
			
			
			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}
			

			bStatus = GeneralFunctions.clickByJS(Objects.generalSettings.Button.changePassword);
			if(!bStatus)
			{	
				Assert.fail("Clic action is not performed on generalSettings button. Error: "+Global.gErrMsg);
			}

			String[] list = {"oldPassword", "newPassword", "confirmPassword"};
			for (String listValue:list) {

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//input[@data-bind='value: "+listValue+"']"));
				if(!bStatus)
				{	
					Assert.fail("GenetalSettings page should contain "+listValue+" text box. Error: "+Global.gErrMsg);
				}


			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_87_Validate_Start_Monitoring_Button_in_General_Settings_tab()
		{

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}
			
			
			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}
			
			// create a child
			//bStatus = ApplicationFunctions.NavigateToGenetalSettings();
			//if(!bStatus)
			//{	
			//	Assert.fail("NavigateToGenetalSettings page is failed. Error: "+Global.gErrMsg);
			//}

			//bStatus = GeneralFunctions.click(Objects.generalSettings.Button.generalSettings);
			//if(!bStatus)
			//{	
				//Assert.fail("Click action is not performed on generalSettings button. Error: "+Global.gErrMsg);
			//}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.Button.startMonitoring,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				bStatus = GeneralFunctions.clickByJS(Objects.generalSettings.Button.stopMonitoring);
				if(!bStatus)
				{	
					Assert.fail("Click action is not performed on stopMonitoring button. Error: "+Global.gErrMsg);
				}
				bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.Button.startMonitoring,Constants.iWaitTimeOut);
				if(!bStatus)
				{	
					Assert.fail("startMonitoring button should visible. Error: "+Global.gErrMsg);
				}

			}
			else {
				
				bStatus = GeneralFunctions.clickByJS(Objects.generalSettings.Button.startMonitoring);
				if(!bStatus)
				{	
					Assert.fail("Click action is not performed on startMonitoring button. Error: "+Global.gErrMsg);
				}

				bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.Button.stopMonitoring,Constants.iWaitTimeOut);
				if(!bStatus){	
					Assert.fail("stopMonitoring button should visible. Error: "+Global.gErrMsg);
				}

			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}
		

		public static void DH_89_Validate_Change_Password_Buton_Functionality_With_No_Data() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}
			
			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}
						
			bStatus = ApplicationFunctions.EnterChangePswdFields("", "", "");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering data in Change_password fields. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.errMsg.errOldPswd,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("Err msg should display as Please enter the old password to continue. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.errMsg.errNewPswd,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("Err msg should display as Please enter password to continue. Error: "+Global.gErrMsg);
			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_90_Validate_Change_password_functionality_with_missing_data_confirmPswd()
		{
			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}

			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}
						
			bStatus = ApplicationFunctions.EnterChangePswdFields("oldPswd", "newPswd", "");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering data in Change_password fields. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.errMsg.pswsDoNotMatch,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("Err msg should display as New passwords do not match.. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}
		//The below testcase covers all change Pswd tcs[91-107]
		
		public static void Validate_New_Pswd_Field_with_diffData(String newPswd) {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){
				Assert.fail("Unable to Login");
			}
			
			bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
			if(!bStatus)
			{	
				Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.EnterChangePswdFields("oldPswd", "newPswd", "");
			if(!bStatus)
			{	
				Assert.fail("Failed while entering data in Change_password fields. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.errMsg.errPswdPatrn,Constants.iWaitTimeOut);
			if(!bStatus)
			{	
				Assert.fail("Err msg should display as Password should be in the mentioned pattern. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

			}

		//covers all change Pswd tcs[109-125]
		
	public static void Validate_ConfirmPswd_DiffData(String confirmPswd) {
		
		bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
		if(!bStatus){
			Assert.fail("Unable to Login");
		}
		
		bStatus = GeneralFunctions.click(Objects.homePage.links.settings);
		if(!bStatus)
		{	
			Assert.fail("NavigateToGeneralSettings page is failed. Error: "+Global.gErrMsg);
		}
		bStatus = ApplicationFunctions.EnterChangePswdFields("oldPswd", "newPswd", "confirmPswd");
		if(!bStatus)
		{	
			Assert.fail("Failed while entering data in Change_password fields. Error: "+Global.gErrMsg);
		}

		bStatus = GeneralFunctions.waitForElementVisibility(Objects.generalSettings.errMsg.pswsDoNotMatch,Constants.iWaitTimeOut);
		if(!bStatus)
		{	
			Assert.fail("Err msg should display as New passwords do not match. Error: "+Global.gErrMsg);
		}


		bStatus = ApplicationFunctions.logout();
		if(!bStatus)
		{	
			Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
		}
	}


		public static void DH_126_Validate_Report_page_GUI_Check(){

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.navigateToReportsPage();

			if(!bStatus)
			{	
				Assert.fail("navigateToRegisterPage page is failed. Error: "+Global.gErrMsg);
			}

			String[] list = {"voice_sms", "app_location", "exception","webaccess","mediaFiles","facebookDetails"};
			for (String listValue:list){

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//a[@href='#"+listValue+"']"));
				if(!bStatus)
				{	
					Assert.fail("reports page should contain "+listValue+". Error: "+Global.gErrMsg);
				}


			}


		}

		public static void DH_127_Validate_Report_Page_Voice_SMS_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.navigateToReportsPage();

			if(!bStatus)
			{	
				Assert.fail("navigateToRegisterPage page is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.reportsPage.header.digitslInteractionsPanel, Constants.iWaitTimeOut);

			if(!bStatus)
			{	
				Assert.fail("Voice&SM page should contain digitslInteractions header. Error: "+Global.gErrMsg);
			}


			String[] list = {"Call Duration", "Frequency of Calls and SMS", "Duration of Calls to Numbers under Watch", "Calls to Numbers under Watch", "Call Attempts to Blocked Numbers", "Monitored Words in SMS"};
			for (String listValue:list){

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//h4[text()='"+listValue+"']"));
				if(!bStatus)
				{	
					Assert.fail("reports page should contain "+listValue+" panel. Error: "+Global.gErrMsg);
				}

			}

		}
		public static void DH_128_Validate_ReportPage_App_Location_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.navigateToReportsPage();

			if(!bStatus)
			{	
				Assert.fail("navigateToReportsPage page is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.click(Objects.reportsPage.Button.applocation);

			if(!bStatus)
			{	
				Assert.fail("Click action is not performed on application button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.reportsPage.header.appLocationPanel, Constants.iWaitTimeOut);

			if(!bStatus)
			{	
				Assert.fail("App&Location page should contain appLocation main panel or header. Error: "+Global.gErrMsg);
			}


			String[] list = {"Location Tracker", "Location violations", "Time Spent on Application", "Frequency of Application Usage"};
			for (String listValue:list){

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//h4[text()='"+listValue+"']/parent::div"));
				if(!bStatus)
				{	
					Assert.fail("App&Location panel of Reports page should contain "+listValue+" sub panel. Error: "+Global.gErrMsg);
				}

			}

		}

		     public static void DH_129_Validate_ReportPage_Exception_tab_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.navigateToReportsPage();

			if(!bStatus)
			{	
				Assert.fail("navigateToReportsPage page is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.click(Objects.reportsPage.Button.exception);

			if(!bStatus)
			{	
				Assert.fail("Click action is not performed on exception button. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.waitForElementVisibility(Objects.reportsPage.header.exceptionEventsPanel, Constants.iWaitTimeOut);

			if(!bStatus)
			{	
				Assert.fail("App&Location page should contain Exception Events header. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//h3[text()='Exception Events']/following-sibling::div[text()='There is no data as of Now in this sections']"));
			if(!bStatus)
			{	
				String[] list = {"Date", "Time", "Event"};

				for (String listValue:list){

					bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//h3[text()='Exception Events']/parent::div//th[text()='"+listValue+"']"));
					if(!bStatus)
					{	
						Assert.fail("Exception panel of Reports page should contain "+listValue+" sub panel. Error: "+Global.gErrMsg);
					}

				}
				
			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_133_Validate_Digital_Interactions_Link_in_Configurations_Page() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToSettingsPage();

			if(!bStatus){

				Assert.fail("navigateToSettingsPage is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.settingsPage.Button.digitalInteraction);
			if(!bStatus)
			{	
				Assert.fail("Settings page should contain All Digital Interactions Configuration button at bottom. Error: "+Global.gErrMsg);
			}		


		}

		public static void DH_134_Validate_Digital_Interactions_Page_Navigation() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToDigitalInteractionsPage();

			if(!bStatus){

				Assert.fail("navigateToDigitalInteractionsPage is failed. Error: "+Global.gErrMsg);
			}	

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_135_Digital_Interaction_Configuration_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus)
			{	
				Assert.fail("loginToApplication functionality is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToDigitalInteractionsPage();

			if(!bStatus){

				Assert.fail("navigateToDigitalInteractionsPage is failed. Error: "+Global.gErrMsg);
			}

			String[] list = {"Custom Block Rule", "Block All Communication", "Communication Always Allowed", "Maximum App usage per Day", "Always Block Number", "Watch List"};
			for (String listValue:list){

				bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//a[text()='"+listValue+"']"));
				if(!bStatus)
				{	
					Assert.fail("DigitalInteractionsPage should contain "+listValue+"  panel. Error: "+Global.gErrMsg);
				}
			}	
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}
		}

		public static void DH_136_Verify_All_Comminucation_Blocked_Time_Configuration_tab_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){

				Assert.fail("loginToApplication is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToDigitalInteractionsPage();
			if(!bStatus){

				Assert.fail("navigateToDigitalInteractionsPage is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.click(Objects.digitalInteractionsConfig.Button.allCommBlokedTimeConfigBtn);
			if(!bStatus){

				Assert.fail("Click action is not performed on allCommBlokedTimeConfigBtn button. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionsConfig.text.allCommBlokedTimeConfigNoData);
			if(!bStatus){

				String[] list = {"Start Time", "End Time", "Days:","Status","Action"};
				for (String listValue:list){

					bStatus = GeneralFunctions.verifyElementVisible(By.xpath(".//*[@id='blockAllCommunication']/div[3]/div/div[2]/table/thead/tr/th[text()='"+listValue+"']"));
					if(!bStatus)
					{	
						Assert.fail("All Communication Blocked Time Configuration panel should contain "+listValue+"  panel. Error: "+Global.gErrMsg);
					}
				}

			}

			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}

		public static void DH_137_Verify_Delete_Button_in_All_Comminucation_Blocked_Time_Configuration() {

			logger.info("This test case is covered in DH_48");

		}

		public static void DH_138_Verify_All_Communication_Blocked_Time_Configuration_display_details() {

			logger.info("This test case is covered in DH_48");

		}

		public static void DH_25_Dashboard_TagNewChild_tag() {


			bStatus = ApplicationFunctions.NavigateToTagChildPage();
			if(!bStatus){
				Assert.fail("Navigation to Tag Child page is failed. Error: "+Global.gErrMsg);
			}


		}
		//Partially Blocked Communication Tab
		public static void DH_139_Partially_Blocked_Communication_Tab_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){

				Assert.fail("loginToApplication is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToDigitalInteractionsPage();
			if(!bStatus){

				Assert.fail("navigateToDigitalInteractionsPage is failed. Error: "+Global.gErrMsg);
			}

			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionsConfig.Button.partailyBlokedCommBtn);
			if(!bStatus){

				Assert.fail("action is not performed on partailyBlokedComm . Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionsConfig.text.partailyBlokedCommNoData);
			if(!bStatus){

				String[] list = {"Phone Number", "Start Time", "End Time", "Days:","Status", "Action"};
				for (String listValue:list){

					bStatus = GeneralFunctions.verifyElementVisible(By.xpath(".//*[@id='customBlockRule']/div[3]/div/div[2]/table/thead/tr/th[text()='"+listValue+"']"));
					if(!bStatus)
					{	
						Assert.fail("Partially Blocked Communication Configuration panel should contain "+listValue+"  panel. Error: "+Global.gErrMsg);
					}
				}

			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}
		
		//Partially Blocked Communication Tab
		public static void DH_142_Verify_Watch_List_Configuration_GUI_Check() {

			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){

				Assert.fail("loginToApplication is failed. Error: "+Global.gErrMsg);
			}

			bStatus = ApplicationFunctions.navigateToDigitalInteractionsPage();
			if(!bStatus){
				Assert.fail("navigateToDigitalInteractionsPage is failed. Error: "+Global.gErrMsg);
			}
		
			bStatus = GeneralFunctions.clickByJS(Objects.digitalInteractionsConfig.Button.watchlistConfigBtn);
			if(!bStatus){

				Assert.fail("Click action is not performed on watchlistConfigBtn. Error: "+Global.gErrMsg);
			}
			bStatus = GeneralFunctions.verifyElementVisible(Objects.digitalInteractionsConfig.text.watchListConfigNoData);
			if(!bStatus){

				String[] list = {"Phone Number","Since","Action"};
				for (String listValue:list){

					bStatus = GeneralFunctions.verifyElementVisible(By.xpath("//h4[text()='Watchlist Configuration']/parent::div//th[text()='"+listValue+"']"));
					if(!bStatus)
					{	
						Assert.fail("Watchlist Configuration panel should contain "+listValue+"  panel. Error: "+Global.gErrMsg);
					}
				}

			}
			bStatus = ApplicationFunctions.logout();
			if(!bStatus)
			{	
				Assert.fail("Logout functionality is failed. Error: "+Global.gErrMsg);
			}

		}
		
		public static void  DH_143_Verify_watch_list_configuration_functionality_put_on_watch_list_button () {
			
			bStatus = ApplicationFunctions.loginToApplication(Global.sUserName, Global.sPassword);
			if(!bStatus){

				Assert.fail("loginToApplication is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.navigateToReportsPage();
			if(!bStatus){

				Assert.fail("navigateToReportsPage is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.closeAlert();
			if(!bStatus){

				Assert.fail("closeAlert is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = ApplicationFunctions.selectDuriationInReportsPage("Last Week");
			if(!bStatus){

				Assert.fail("selectDuriationInReportsPage is failed. Error: "+Global.gErrMsg);
			}
			
			bStatus = GeneralFunctions.acceptAlert();
			if(!bStatus){

				Assert.fail("acceptAlert is failed. Error: "+Global.gErrMsg);
			}
			
		}
	
}
