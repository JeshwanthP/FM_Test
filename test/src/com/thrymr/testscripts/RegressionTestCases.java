package com.thrymr.testscripts;



import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.thrymr.testhelper.RegressionTestcaseHelper;

public class RegressionTestCases extends BaseTest
{
	private static Logger logger = Logger.getLogger("RegressionTestCases");


	@Test
	public static void DH_01(){
		RegressionTestcaseHelper.DH_01_Validate_Digital_Hawk_Loginpage();
		logger.info("this is DH_01 testcase");

	}
		/*@Test
		public static void DH_02(){
			RegressionTestcaseHelper.DH_02_Validate_Sign_Up_Button_In_Loginpage();
			logger.info("this is DH_02 testcase");
		}
		@Test
		public static void DH_03(){
			RegressionTestcaseHelper.DH_03_Register_page_GUI_Check();
			logger.info("this is DH_03 testcase");
		}*/
		
		
		//This test case covers DH_04,DH_05,DH_06,DH_07,DH_08 test cases
		@Test(dataProvider="getSignUpDetails")
		public static void DH_04_VerifyregistrationPageWithDifftestdata(String username,String phone,String expected,String ErrMsg){
			RegressionTestcaseHelper.verifyRegisterpage(username,phone,expected,ErrMsg);
			logger.info("This test case covers DH_04,DH_05,DH_06,DH_07,DH_08 test cases");
		}
		
	/*	//This test case covers DH_12 to DH_17 test cases
		@Test(dataProvider="getLoginDetails")
		public static void DH_07_VerifyLoginPageWithDiffTestdata(String username,String phone,String expected,String ErrMsg){
			RegressionTestcaseHelper.verifyLoginpage(username,phone,expected,ErrMsg);
			logger.info("This test case covers DH_12 to DH_17 test cases");
		}
		*/
		//This test case covers DH_26 to DH_30 test cases
		@Test(dataProvider="getChildDetails")
		public static void DH_26_Validate_Tag_New_Page(String childName,String dob,String deviceId, String expected,String ErrMsg){
			RegressionTestcaseHelper.VerifyTagChildDetails(childName, dob, deviceId, expected, ErrMsg);
			logger.info("This test case covers DH_26 to DH_30 test cases");
		}
		
		
     /*    @Test
		public static void DH_11(){
			RegressionTestcaseHelper.DH_11_Validate_login_Page_GUI();
			logger.info("this is DH_11 testcase");
			}

		@Test
		public static void DH_18(){
			RegressionTestcaseHelper.DH_18_Validatye_Forgot_Password_link_in_Login_page();
			logger.info("this is DH_18 testcase");
		}
		@Test
		public static void DH_19(){
			RegressionTestcaseHelper.DH_19_Validate_Forgot_Password_link_in_Login_page();
			logger.info("this is DH_19 testcase");
		}
		@Test
		public static void DH_20(){
			RegressionTestcaseHelper.DH_20_Verify_GUI_objects_in_Password_Reset_page();
			logger.info("this is DH_20 testcase");
		}

		@Test
		public static void DH_21(){
			RegressionTestcaseHelper.DH_21_Validate_Send_button_functionality_with_invalid_data_of_email_in_Password_Rest_Page();
			logger.info("this is DH_21 testcase");
		}

		@Test
		public static void DH_22(){
			RegressionTestcaseHelper.DH_22_Validate_Send_button_functionality_with_no_data_of_email_in_Password_Rest_Page();
			logger.info("this is DH_22 testcase");
		}
		@Test
		public static void DH_23(){
			RegressionTestcaseHelper.DH_23_Validate_Send_button_functionality_with_valid_email_in_Password_Reset_page();
			logger.info("this is DH_23 testcase");
		}
		@Test
		public static void DH_24(){
			RegressionTestcaseHelper.DH_24_Verify_GUI_objects_in_dashboard_page();
			logger.info("this is DH_24 testcase");
		}
		@Test
		public static void DH_25(){
			RegressionTestcaseHelper.DH_25_Verify_GUI_Objects_Of_Tag_New_Child_Page();
			logger.info("this is DH_25 testcase");
		}
		
		
		
		@Test
		public static void DH_32()
		{
			RegressionTestcaseHelper.DH_32_Verify_GUI_Objects_Of_Dashboard_Page();
			logger.info("this is DH_32 testcase");
		}

		
		/*@Test
		public static void DH_33(){
			RegressionTestcaseHelper.DH_33_Verify_Location_Button_Navigation_In_Dashboard_Page();
			logger.info("this is DH_33 testcase");	  

		}*/
	/* @Test
		public static void DH_34(){
			RegressionTestcaseHelper.DH_34_Verify_Reports_Button_Navigation_In_Dashboard_Page();
			logger.info("this is DH_34 testcase");	  

		} 


		@Test
		public static void DH_35(){
			RegressionTestcaseHelper.DH_35_Dashboard_Settings_Button_Navigation_In_Dashboard_Page();
			logger.info("this is DH_35 testcase");	  

		} 

		//Dashboard

		@Test
		public static void DH_36()
		{
			RegressionTestcaseHelper.DH_36_Configuration_Page_GUI_Check_By_Clicking_Setting_Button_Of_Dashboard();
			logger.info("this is DH_36 testcase");	  

		}

		//Dashboard(progress)

		@Test
		public static void DH_37(){
			RegressionTestcaseHelper.DH_37_Configuration_Page_BlockSpecificNumber_Panel_GUI();
			logger.info("this is DH_37 testcase");	  

		}

		//Dashboard

		@Test
		
		public static void DH_38(){
			RegressionTestcaseHelper.DH_38_Configuration_Page_BlockSpecificNumber_Panel_with_no_DAY();
			logger.info("this is DH_38 testcase");	  

		}

		@Test
		public static void DH_42(){
			RegressionTestcaseHelper.DH_42_Verify_Block_Specific_Number_Functionality_In_Digital_Interaction_Tab_Of_Configuration_Page();
			logger.info("this is DH_42 testcase");	  

		}

	@Test
		public static void DH_43(){
			RegressionTestcaseHelper.DH_43_Block_All_Numbers_Panel_GUI_Test_Case();
			logger.info("this is DH_43 testcase");	  
 
		}
		@Test
		public static void DH_44(){
			RegressionTestcaseHelper.DH_44_Block_All_Numbers_Panel_With_No_DAY();
			logger.info("this is DH_44 testcase");	  


		}

		@Test
		public static void DH_45(){
			RegressionTestcaseHelper.DH_45_Block_All_Numbers_Panel_With_No_DateRange();
			logger.info("this is DH_45 testcase");	  

		}

		@Test
		public static void DH_46(){
			RegressionTestcaseHelper.DH_46_Block_All_Numbers_Panel_with_No_startTime();
			logger.info("this is DH_46 testcase");	  

		}
		
		@Test
		public static void DH_47(){
			RegressionTestcaseHelper.DH_47_Block_All_Numbers_Panel_with_No_endTime();
			logger.info("this is DH_47 testcase");	  

		}

		@Test
		public static void DH_48(){
			RegressionTestcaseHelper.DH_48_Validate_Block_All_Numbers_Functionality_In_Digital_Interaction_Settings_Tab_Of_Configuration_Page();
			logger.info("this is DH_48 testcase");	  

		}

		@Test
		public static void DH_49(){
			RegressionTestcaseHelper.DH_49_Communication_Always_Allowed_Panel_GUI();
			logger.info("this is DH_49 testcase");	  

		}

		@Test
		public static void DH_50(){
			RegressionTestcaseHelper.DH_50_Validate_Phone_Number_Field_With_Invalid_Data_Characters_In_Communication_Always_Allowed_Panel_In_Settings_Of_Dashboard();
			logger.info("this is DH_50 testcase");	  

		}

		@Test
		public static void DH_51(){
			RegressionTestcaseHelper.DH_51_Validate_Phone_Number_Field_With_SpecialsCharacters_In_Communication_Always_Allowed_Panel_In_Settings_Of_Dashboard();
			logger.info("this is DH_51 testcase");	  

		}

		@Test
		public static void DH_52(){
			RegressionTestcaseHelper.DH_52_Validate_Phone_Number_Field_With_Invalid_Data_less_than_10_digits_In_Communication_Always_Allowed_Panel();
			logger.info("this is DH_52 testcase");	  

		}

		@Test
		public static void DH_53(){
			RegressionTestcaseHelper.DH_53_Communication_Always_Allowed_panel_valid_data_moreThan10();
			logger.info("this is DH_53 testcase");	  

		}                                                                                                                                                    
		@Test
		public static void DH_54(){
			RegressionTestcaseHelper.DH_54_Communication_Always_Allowed_panel_With_DigitsAndSpecialChars();
			logger.info("this is DH_54 testcase");	  

		}

		@Test
		public static void DH_55(){
			RegressionTestcaseHelper.DH_55_Communication_Always_Allowed_Positive();
			logger.info("this is DH_55 testcase");	  

		}

		@Test
		public static void DH_56(){
			RegressionTestcaseHelper.DH_56_Maximum_No_Of_Sms_Panel_GUI();
			logger.info("this is DH_56 testcase");	  

		}

	    @Test
		public static void DH_57(){
			RegressionTestcaseHelper.DH_57_max_sms_Positive();
			logger.info("this is DH_57 testcase");	  

		}
		@Test
		public static void DH_58(){
			RegressionTestcaseHelper.DH_58_max_sms_invalid_data();
			logger.info("this is DH_58 testcase");	  

		}


		@Test
		public static void DH_59(){
			RegressionTestcaseHelper.DH_59_Sms_Barred_Content_Panel_GUI_Test_Cases();
			logger.info("this is DH_59 testcase");	  

		}



		@Test
		public static void DH_60(){
			RegressionTestcaseHelper.DH_60_SMS_barred_content_no_data();
			logger.info("this is DH_61 testcase");	  

		}

		@Test
		public static void DH_61(){
			RegressionTestcaseHelper.DH_61_blocked_words();
			logger.info("this is DH_60 testcase");	  

		}

		@Test
		public static void DH_62(){
			RegressionTestcaseHelper.DH_62_Maximun_App_UsagePanel_GUI();
			logger.info("this is DH_62 testcase");	  

		}
		
		@Test
		public static void DH_63(){
			RegressionTestcaseHelper.DH_63_Max_App_Usage_Missing_UsageTime();
			logger.info("this is DH_63 testcase");	  

		}
		@Test
		public static void DH_64(){
			RegressionTestcaseHelper.DH_64_Max_App_Usage_Missing_App();
			logger.info("this is DH_64 testcase");	  

		}
		@Test
		public static void DH_65(){
			RegressionTestcaseHelper.DH_65_Max_App_Usage_Missing_Day();
			logger.info("this is DH_65 testcase");	  

		}

		@Test
		public static void DH_66(){
			RegressionTestcaseHelper.DH_66_Max_App_Usage_Positive();
			logger.info("this is DH_66 testcase");	  

		}

		@Test
		public static void DH_67(){
			RegressionTestcaseHelper.DH_67_ConfigurationPage_Location_Page_GUI_Check();
			logger.info("this is DH_67 testcase");	  

		}

		@Test
		public static void DH_68(){
			RegressionTestcaseHelper.DH_68_ConfigurationPage_Location_tab_location_panel_GUI_Check();
			logger.info("this is DH_68 testcase");	  

		}
		@Test
		public static void DH_69() throws Exception{
			RegressionTestcaseHelper.DH_69_Location_tab_location_panel_Missing_StartTime();
			logger.info("this is DH_69 testcase");	  
		}

		@Test
		public static void DH_70() throws Exception{
		RegressionTestcaseHelper.DH_70_Location_tab_location_panel_Missing_EndTime();
			logger.info("this is DH_70 testcase");	  

		}
		
		@Test
		public static void DH_71()throws Exception{
			RegressionTestcaseHelper.DH_71_Location_tab_location_panel_Missing_Day();
			logger.info("this is DH_71 testcase");	  

		}
		
		@Test
		public static void DH_72() throws Exception{
			RegressionTestcaseHelper.DH_72_Location_tab_location_panel_Missing_Allowance_KM();
			logger.info("this is DH_72 testcase");	  

		}
	
		@Test
		public static void DH_73()throws Exception{
			RegressionTestcaseHelper.DH_73_ConfigurationPage_Location_tab_Location_Monitoring_MissingData();
			logger.info("this is DH_73 testcase");	  

		}
		
		@Test
		public static void DH_74() throws Exception  {
			RegressionTestcaseHelper.DH_74_ConfigurationPage_Location_tab_Location_Monitoring_InavlidData();
			logger.info("this is DH_74 testcase");	  

		}

		@Test
		public static void DH_75() throws Exception{
			RegressionTestcaseHelper.DH_75_track_location ();
			logger.info("this is DH_75 testcase");	  

		}
		
		@Test
		public static void DH_76(){
			RegressionTestcaseHelper.DH_76_track_location_Delete();
			logger.info("this is DH_76 testcase");	  

		}

		@Test
		public static void DH_78(){
			RegressionTestcaseHelper.DH_78_Location_Monitering_panel_valid_data();
			logger.info("this is DH_78 testcase");	  

		}	
		@Test
		public static void DH_79(){
			RegressionTestcaseHelper.DH_79_ConfigurationPage_Application_tab_GUI_Check();
			logger.info("this is DH_79 testcase");	  
		}

		@Test
		public static void DH_80(){
			RegressionTestcaseHelper.DH_80_Application_Restriction_Panel_with_no_Start_time();
			logger.info("this is DH_79 testcase");	  

		}

		@Test
		public static void DH_81(){
			RegressionTestcaseHelper.DH_81_Application_Restriction_Panel_with_no_End_time();
			logger.info("this is DH_81 testcase");	  

		}

		@Test
		public static void DH_82(){
			RegressionTestcaseHelper.DH_82_Application_Restriction_Panel_with_no_Day();
			logger.info("this is DH_82 testcase");	  

		}

		
 
    	@Test
		public static void DH_84(){
			RegressionTestcaseHelper.DH_84_Verify_GUI_Of_Settings_Page();
			logger.info("this is DH_84 testcase");	  

		}

		@Test
		public static void DH_85(){
			RegressionTestcaseHelper.DH_85_Verify_General_Settings_Tab_GUI_Objects();
			logger.info("this is DH_85 testcase");	  

		}

		@Test
		public static void DH_86(){
			RegressionTestcaseHelper.DH_86_Validate_Change_Password_Tab_GUI_Objects();
			logger.info("this is DH_86 testcase");	  

		}

		@Test
		public static void DH_87(){
			RegressionTestcaseHelper.DH_87_Validate_Start_Monitoring_Button_in_General_Settings_tab();
			logger.info("this is DH_87 testcase");	  

		}


		
        @Test
		public static void DH_89(){
			RegressionTestcaseHelper.DH_89_Validate_Change_Password_Buton_Functionality_With_No_Data();
		logger.info("this is DH_89 testcase");	  

		}

        @Test
		public static void DH_90(){
			RegressionTestcaseHelper.DH_90_Validate_Change_password_functionality_with_missing_data_confirmPswd();
			logger.info("this is DH_90 testcase");	  

		}

		@Test(dataProvider="getNewPswdDetails")
		public static void Validate_New_Pswd_Field(String newPswd){
			RegressionTestcaseHelper.Validate_New_Pswd_Field_with_diffData(newPswd);
			logger.info("This test case covers New_Pswd_Field test cases");
		}
	
		@Test(dataProvider="getConfirmPswdDetails")
		public static void Validate_ConfirmPswd_DiffData(String confirmPswd){
			RegressionTestcaseHelper.Validate_ConfirmPswd_DiffData(confirmPswd);
			logger.info("This test case covers Confirm_Pswd_Field test cases");
		} 

		@Test
		public static void DH_126(){
			RegressionTestcaseHelper.DH_126_Validate_Report_page_GUI_Check();
			logger.info("this is DH_126 testcase");	  

		}

		@Test
		public static void DH_127(){
			RegressionTestcaseHelper.DH_127_Validate_Report_Page_Voice_SMS_GUI_Check();
			logger.info("this is DH_127 testcase");	  

		}
        
		@Test
		public static void DH_128(){
			RegressionTestcaseHelper.DH_128_Validate_ReportPage_App_Location_GUI_Check();
			logger.info("this is DH_128 testcase");	  

		}
       
		@Test
		public static void DH_129(){
			RegressionTestcaseHelper.DH_129_Validate_ReportPage_Exception_tab_GUI_Check();
			logger.info("this is DH_129 testcase");	  
			// need review
		}
       
		@Test 
		public static void DH_133(){
			RegressionTestcaseHelper.DH_133_Validate_Digital_Interactions_Link_in_Configurations_Page();
			logger.info("this is DH_133 testcase");	  

		}
        
		@Test
		public static void DH_134(){
			RegressionTestcaseHelper.DH_134_Validate_Digital_Interactions_Page_Navigation();
			logger.info("this is DH_134 testcase");	  

		}
        
		@Test
		public static void DH_135(){
			RegressionTestcaseHelper.DH_135_Digital_Interaction_Configuration_GUI_Check();
			logger.info("this is DH_135 testcase");	  

		}
        
		@Test
		public static void DH_136(){
			RegressionTestcaseHelper.DH_136_Verify_All_Comminucation_Blocked_Time_Configuration_tab_GUI_Check();
			logger.info("this is DH_136 testcase");	  

		}
		
		@Test
		public static void DH_137(){
			
			logger.info("This test case is covered in DH_48");

		}
		
		@Test
		public static void DH_138(){
			
			logger.info("This test case is covered in DH_48"); 

		}
		
		@Test
		public static void DH_139(){
			RegressionTestcaseHelper.DH_139_Partially_Blocked_Communication_Tab_GUI_Check();
			logger.info("this is DH_139 testcase");	  

		}
		
			@Test
		public static void DH_140(){
			
			logger.info("This test case is covered in DH_42");

		}
		
		@Test
		public static void DH_141(){
			
			logger.info("This test case is covered in DH_42"); 

		}
		
		@Test
		public static void DH_142(){
		
			RegressionTestcaseHelper.DH_142_Verify_Watch_List_Configuration_GUI_Check();
			logger.info("this is DH_142 testcase");

		}*/
       
}
