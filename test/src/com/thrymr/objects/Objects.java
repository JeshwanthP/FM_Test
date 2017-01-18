package com.thrymr.objects;

import org.openqa.selenium.By;

public class Objects
{
	public static class LoginPage{

		public static class Textbox {

			public static By username = By.xpath(XMLObjects.getLocator("username"));
			public static By Password = By.xpath(XMLObjects.getLocator("password"));
		}

		public static class Button {

			public static By SignUp= By.xpath(XMLObjects.getLocator("SignUp"));
			public static By submit = By.xpath(XMLObjects.getLocator("login"));

		}

		public static class Form {

			public static By loginForm = By.xpath(XMLObjects.getLocator("loginForm"));

		}
		public static class ErrMsg {

			public static By errMsgEmail = By.xpath(XMLObjects.getLocator("errMsgEmail"));
			public static By errMsgPswd = By.xpath(XMLObjects.getLocator("errMsgPswd"));	   

		}

		public static class link {

			public static By forgotPswd = By.xpath(XMLObjects.getLocator("forgotPswd"));
		}

	}


	public static class registerPage{

		public static class Textbox {

			public static By email = By.xpath(XMLObjects.getLocator("email"));
			public static By mobilePhone = By.xpath(XMLObjects.getLocator("mobilePhone"));
		}

		public static class Button {

			//public static By trial = By.xpath(XMLObjects.getLocator("trial"));
			//public static By purchase = By.xpath(XMLObjects.getLocator("purchase"));
			public static By signUp = By.xpath(XMLObjects.getLocator("signUp"));
			//public static By trialActivated = By.xpath(XMLObjects.getLocator("trialActivated"));

		}
		public static class Form {

			public static By registerForm = By.xpath(XMLObjects.getLocator("registerForm"));
		}
		public static class ErrMsg {

			public static String errMsgRegisterPage = "//span[@class='app--validation--error-message' and text()='XXX']";
			public static By errMsgEmail = By.xpath(XMLObjects.getLocator("errMsgEmail"));
			public static By errMsgMobile = By.xpath(XMLObjects.getLocator("errMsgMobile"));
		}
		public static class dropDown {

			public static By packages = By.xpath(XMLObjects.getLocator("packages"));
		}

		public static class header {

			public static By reports = By.xpath(XMLObjects.getLocator("reportsHeader"));
		}


	}


	public static class passwordResetPage{

		public static class Textbox {

			public static By forgotPswdEmail = By.xpath(XMLObjects.getLocator("forgotPswdEmail"));
		}
		public static class ErrMsg {

			public static By errMsgResetPswd = By.xpath(XMLObjects.getLocator("errMsgResetPswd"));
		}
		public static class Button {

			public static By sendPassword = By.xpath(XMLObjects.getLocator("sendPassword"));
		}
		public static class successMsg {

			public static By successMessage = By.xpath(XMLObjects.getLocator("successMessage"));
		}



	}
	public static class homePage{

		public static class Button {

			public static By logout = By.xpath(XMLObjects.getLocator("logout"));
		}
		public static class links {

			public static By tagChildLink = By.xpath(XMLObjects.getLocator("tagChildLink"));
			public static By dashboard = By.xpath(XMLObjects.getLocator("dashboard"));
			public static By settings = By.xpath(XMLObjects.getLocator("settings"));
			public static By children = By.xpath(XMLObjects.getLocator("children"));
			public static By profile = By.xpath(XMLObjects.getLocator("profile"));

		}

	}
	public static class tagChildPage{

		public static class Button {

			public static By tagChildBtn = By.xpath(XMLObjects.getLocator("tagChildBtn"));
		}
		public static class TextBox {

			public static By childName = By.xpath(XMLObjects.getLocator("childName"));
			//public static By nickName = By.xpath(XMLObjects.getLocator("nickName"));
			public static By DOB = By.xpath(XMLObjects.getLocator("DOB"));
			public static By deviceId = By.xpath(XMLObjects.getLocator("deviceId"));
			public static By errMsgLocator = By.xpath(XMLObjects.getLocator("ErrMsgScreen"));
			
		}
	}
	public static class dashboardPage{

		public static class Button {

			public static By settings = By.xpath(XMLObjects.getLocator("dashboardSettings"));
			public static By reports = By.xpath(XMLObjects.getLocator("dashboardReports"));
			public static By location = By.xpath(XMLObjects.getLocator("dashboardLocation"));


		}
	}
	public static class settingsPage{

		public static class panel {
			public static By blockSpecificNumbers = By.xpath(XMLObjects.getLocator("blockSpecificNumbers"));
		}


		public static class Button {

			public static By digitalInteraction = By.xpath(XMLObjects.getLocator("digitalInteraction"));
			public static By location = By.xpath(XMLObjects.getLocator("location"));
			public static By application = By.xpath(XMLObjects.getLocator("application"));
			public static By webbrowser = By.xpath(XMLObjects.getLocator("webbrowser"));
			public static By facebook = By.xpath(XMLObjects.getLocator("facebook"));

			public static By generalSettings = By.xpath(XMLObjects.getLocator("generalSettings"));
			public static By changePassword = By.xpath(XMLObjects.getLocator("changePassword"));
			public static By stopMonitoring = By.xpath(XMLObjects.getLocator("stopMonitoring"));
			public static By removeChild = By.xpath(XMLObjects.getLocator("removeChild"));
			public static By allDigitalInteractionConfigurations = By.xpath(XMLObjects.getLocator("allDigitalInteractionConfigurations"));

		}
		public static class msg {
			public static By pleaseWaitMsg = By.xpath(XMLObjects.getLocator("pleaseWait"));
		}
		

	}

	public static class generalSettings{

		public static class textBox {

			public static By oldPassword = By.xpath(XMLObjects.getLocator("oldPassword"));
			public static By newPassword = By.xpath(XMLObjects.getLocator("newPassword"));
			public static By confirmPassword = By.xpath(XMLObjects.getLocator("confirmPassword"));
		}


		public static class Button {

			public static By generalSettings = By.xpath(XMLObjects.getLocator("generalSettings"));
			public static By changePassword = By.xpath(XMLObjects.getLocator("changePassword"));
			public static By stopMonitoring = By.xpath(XMLObjects.getLocator("stopMonitoring"));
			public static By removeChild = By.xpath(XMLObjects.getLocator("removeChild"));
			public static By startMonitoring = By.xpath(XMLObjects.getLocator("startMonitoring"));
			public static By changePswdBtn = By.xpath(XMLObjects.getLocator("changePswdBtn"));

		}

		public static class errMsg {

			public static By errOldPswd = By.xpath(XMLObjects.getLocator("errOldPswd"));
			public static By errNewPswd = By.xpath(XMLObjects.getLocator("errNewPswd"));
			public static By pswsDoNotMatch = By.xpath(XMLObjects.getLocator("pswsDoNotMatch"));
			public static By errPswdPatrn = By.xpath(XMLObjects.getLocator("errPswdPatrn"));
		}
	}



	public static class locationPage{

		public static class header {

			public static By location = By.xpath(XMLObjects.getLocator("locationHeader"));
		}

		public static class panel {

			public static By locationLogPanel = By.xpath(XMLObjects.getLocator("locationLogPanel"));
			public static By LocationPanel = By.xpath(XMLObjects.getLocator("locationLogPanel"));
		}


		public static class textBox {

			public static By locationPanelLocationField = By.xpath(XMLObjects.getLocator("locationPanelLocationField"));
			public static By locationPanelStartTime = By.xpath(XMLObjects.getLocator("locationStartTime"));
			public static By locationPanelEndTime = By.xpath(XMLObjects.getLocator("locationPanelEndTime"));
			public static By locationPanelAllowanceKM = By.xpath(XMLObjects.getLocator("locationPanelAllowance"));
			public static By logInterval = By.xpath(XMLObjects.getLocator("logInterval"));

		}

		public static class Button {

			public static By locationPanelSET = By.xpath(XMLObjects.getLocator("locationPanelSET"));
			public static By logIntervalSet = By.xpath(XMLObjects.getLocator("logIntervalSet"));


		}

		public static class errMsg {

			public static By locationPanelErrStartTime = By.xpath(XMLObjects.getLocator("locationPanelErrStartTime"));
			public static By locationPanelErrDay = By.xpath(XMLObjects.getLocator("locationPanelErrDay"));
			public static By locationPanelErrAllowanceKM = By.xpath(XMLObjects.getLocator("locationPanelErrAllowanceKM"));


		}

		public static class successMsg {

			public static By logIntervalSuccessMsg = By.xpath(XMLObjects.getLocator("logIntervalSuccessMsg"));



		}


	}




	public static class digitalInteractionPage{

		public static class panel {

			public static By blockSpecificNum = By.xpath(XMLObjects.getLocator("blockSpecificNum"));
			public static By blockAllNumPanel = By.xpath(XMLObjects.getLocator("blockAllNumPanel"));
			public static By CommunicationalwaysAlowedPanel = By.xpath(XMLObjects.getLocator("CommunicationalwaysAlowedPanel"));
			public static By MaxSMSPanel = By.xpath(XMLObjects.getLocator("MaxSMSPanel"));
			public static By SmsBarredPanel = By.xpath(XMLObjects.getLocator("SmsBarredPanel"));
			public static By addressBookPanel = By.xpath(XMLObjects.getLocator("addressBookPanel"));
			
		}

		public static class dropDown {

			public static By contacts = By.xpath(XMLObjects.getLocator("contacts"));
			public static By maxAppsDropdown = By.xpath(XMLObjects.getLocator("maxAppsDropdown"));
		}

		public static class textBox {

			public static By blockSpecificNumStartTime = By.xpath(XMLObjects.getLocator("blockSpecificNumStartTime"));
			public static By blockSpecificNumEndTime = By.xpath(XMLObjects.getLocator("blockSpecificNumEndTime"));
			public static By blockAllNumStartTime = By.xpath(XMLObjects.getLocator("blockAllNumStartTime"));
			public static By blockAllNumEndTime = By.xpath(XMLObjects.getLocator("blockAllNumEndTime"));
			public static By CommunicationalwaysAlowedPhoneNum = By.xpath(XMLObjects.getLocator("CommunicationalwaysAlowedPhoneNum"));
			public static By MaxSMSTextBox = By.xpath(XMLObjects.getLocator("MaxSMSTextBox"));
			public static By blockedWords = By.xpath(XMLObjects.getLocator("blockedWords"));
			public static By maxAppUsageTime = By.xpath(XMLObjects.getLocator("maxUsageTime"));
		}

		public static class button {

			public static By blockSpecificNumSET = By.xpath(XMLObjects.getLocator("blockSpecificNumSET"));
			public static By blockAllNumSET = By.xpath(XMLObjects.getLocator("blockAllNumSET"));
			public static By CommunicationalwaysAlowedSET = By.xpath(XMLObjects.getLocator("CommunicationalwaysAlowedSET"));
			public static By MaxSMSPanelSET = By.xpath(XMLObjects.getLocator("MaxSMSPanelSET"));
			public static By SmsBarredPanelSET = By.xpath(XMLObjects.getLocator("SmsBarredPanelSET"));
			public static By maxAppsSet = By.xpath(XMLObjects.getLocator("maxAppsSet"));
			public static By phoneBook = By.xpath(XMLObjects.getLocator("phoneBook"));
			
		}

		public static class successMsg {

			public static By SuccessMsgMaxAppUsage = By.xpath(XMLObjects.getLocator("SuccessMsgMaxAppUsage"));

		}

		public static class errMsg {

			public static By blockSpecificNumDAY = By.xpath(XMLObjects.getLocator("errMsgDay"));
			public static By blockSpecificNumStartTime = By.xpath(XMLObjects.getLocator("errMsgStartTime"));
			public static By blockSpecificNumEndTime = By.xpath(XMLObjects.getLocator("errMsgEndTime"));
			public static By BlockAllNumStartTime = By.xpath(XMLObjects.getLocator("blockAllNumErrStartTime"));
			public static By BlockAllNumEndTime = By.xpath(XMLObjects.getLocator("blockAllNumErrEndTime"));
			public static By CommunicationalwaysAlowed = By.xpath(XMLObjects.getLocator("ErrMsgCommunicationalwaysAlowed"));
			public static By MaxSMSPanel = By.xpath(XMLObjects.getLocator("ErrMaxSMSPanel"));
			public static By BlockAllNumsDay = By.xpath(XMLObjects.getLocator("BlockAllNumsDay"));

			public static By ErrMaxAppUsageTime = By.xpath(XMLObjects.getLocator("ErrMaxAppUsageTime"));
			public static By ErrMaxAppUsageDay = By.xpath(XMLObjects.getLocator("ErrMaxAppUsageDay"));
			public static By ErrMaxAppUsageApp = By.xpath(XMLObjects.getLocator("ErrMaxAppUsageApp"));

		}


	}


	public static class applicationsPage{

		public static class panel {

			public static By applicationRestrictionPanel = By.xpath(XMLObjects.getLocator("applicationRestrictionPanel"));

		}

		public static class dropDown {

			public static By applicationDrpdown = By.xpath(XMLObjects.getLocator("applicationDrpdown"));

		}

		public static class textBox {

			public static By applicationStartTime = By.xpath(XMLObjects.getLocator("applicationStartTime"));
			public static By applicationEndTime = By.xpath(XMLObjects.getLocator("applicationEndTime"));

		}

		public static class Button {

			public static By applicationSET = By.xpath(XMLObjects.getLocator("applicationSET"));


		}

		public static class ErrMsg {

			public static By ErrAppStartTime = By.xpath(XMLObjects.getLocator("ErrAppStartTime"));
			public static By ErrAppEndTime = By.xpath(XMLObjects.getLocator("ErrAppEndTime"));
			public static By ErrAppDay = By.xpath(XMLObjects.getLocator("ErrAppDay"));


		}
	}

	public static class reportsPage{

		public static class Button {
			public static By voiceAndSms =  By.xpath(XMLObjects.getLocator("voiceAndSms"));
			public static By applocation =  By.xpath(XMLObjects.getLocator("applocation"));
			public static By exception =  By.xpath(XMLObjects.getLocator("exception"));

		}

		public static class header {

			public static By appLocationPanel =  By.xpath(XMLObjects.getLocator("appLocationPanel"));
			public static By digitslInteractionsPanel =  By.xpath(XMLObjects.getLocator("digitslInteractionsPanel"));
			public static By exceptionEventsPanel =  By.xpath(XMLObjects.getLocator("exceptionEventsPanel"));

		}

	}

	public static class digitalInteractionsConfig{
		
		public static class Button{
			
			public static By allCommBlokedTimeConfigBtn =  By.xpath(XMLObjects.getLocator("allCommBlokedTimeConfigBtn"));
			public static By partailyBlokedCommBtn =  By.xpath(XMLObjects.getLocator("partailyBlokedCommBtn"));
			public static By allCommBlokedNumConfigBtn =  By.xpath(XMLObjects.getLocator("allCommBlokedNumConfigBtn"));
			public static By watchlistConfigBtn =  By.xpath(XMLObjects.getLocator("watchlistConfigBtn"));
			public static By allAllowedNumConfigBtn =  By.xpath(XMLObjects.getLocator("allAllowedNumConfigBtn"));
			public static By allAppUsageLimitConfigBtn =  By.xpath(XMLObjects.getLocator("allAppUsageLimitConfigBtn"));
			
			
		}
		
		public static class text{
			public static By allCommBlokedTimeConfigNoData =  By.xpath(XMLObjects.getLocator("allCommBlokedTimeConfigNoData"));
			public static By partailyBlokedCommNoData =  By.xpath(XMLObjects.getLocator("partailyBlokedCommNoData"));
			public static By watchListConfigNoData =  By.xpath(XMLObjects.getLocator("watchListConfigNoData"));
			
		}
		
	}
}


