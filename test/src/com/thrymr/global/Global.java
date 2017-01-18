package com.thrymr.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static String sBrowserName = "gc";
	public static String sURL = "http://139.59.46.238:9000/";
	public static String sUserName = "suryajyoti.bisen@thrymr.net";
	public static String sPassword="8801866275";
	//public static String sUserName = "sumahyd.b@gmail.com";
	//public static String sPassword="7386757300";
	public static String empty="";

	public static String gErrMsg;
	public static String gAppErrMsg;
	
	public static String appToBlock="Contacts";
	
}
