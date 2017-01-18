package com.thrymr.objects;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLObjects
{
public static String setobjectLocatorFilePath;
	

	public static String getLocator(String sLocatorName){
		try {
			NodeList nodeList;
			FileInputStream file = new FileInputStream(new File(setobjectLocatorFilePath));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//object";
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if(eElement.getAttribute(sLocatorName).equals("")){
					continue;
				}
				else{
					return eElement.getAttribute(sLocatorName);
				}
			}
			return "0";
		}
		catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	
	public static Object[][] loadLoginData() {
		try {
			NodeList nodeList = getNodeList("TestData.xml","//UserInfo");
			String[][] userdetails =new String[nodeList.getLength()][4];
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				userdetails[iCount][0] = eElement.getAttribute("username");
				userdetails[iCount][1] = eElement.getAttribute("password");
				userdetails[iCount][2] = eElement.getAttribute("expected");
				userdetails[iCount][3] = eElement.getAttribute("errMsg");
			}
			return userdetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] loadTagNewChildData() {
		try {
			NodeList nodeList = getNodeList("TestData.xml","//TagChildInfo");
			String[][] childDetails =new String[nodeList.getLength()][5];
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				childDetails[iCount][0] = eElement.getAttribute("childName");
				childDetails[iCount][1] = eElement.getAttribute("dob");
				childDetails[iCount][2] = eElement.getAttribute("deviceId");
				childDetails[iCount][3] = eElement.getAttribute("expected");
				childDetails[iCount][4] = eElement.getAttribute("errMsg");
			}
			return childDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] loadSignUpData() {
		try {
			NodeList nodeList = getNodeList("TestData.xml","//SignUpInfo");
			String[][] signupdetails =new String[nodeList.getLength()][4];
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				signupdetails[iCount][0] = eElement.getAttribute("username");
				signupdetails[iCount][1] = eElement.getAttribute("phone");
				signupdetails[iCount][2] = eElement.getAttribute("expected");
				signupdetails[iCount][3] = eElement.getAttribute("errMsg");
			}
			return signupdetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] loadNewPswds() {
		try {
			NodeList nodeList = getNodeList("TestData.xml","//NewPswdInfo");
			String[][] nePswdDetails =new String[nodeList.getLength()][1];
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				nePswdDetails[iCount][0] = eElement.getAttribute("newPswd");
			}
			return nePswdDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object[][] loadConfirmPswds() {
		try {
			NodeList nodeList = getNodeList("TestData.xml","//ConfirmPswdInfo");
			String[][] confirmPswdDetails =new String[nodeList.getLength()][1];
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				confirmPswdDetails[iCount][0] = eElement.getAttribute("confirmPswd");
			}
			return confirmPswdDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static NodeList getNodeList(String filepath, String xpath){
		try{
			NodeList nodeList;
			FileInputStream file = new FileInputStream(new File(filepath));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = xpath+"/data";
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			return nodeList;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}