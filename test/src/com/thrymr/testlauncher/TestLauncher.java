package com.thrymr.testlauncher;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestLauncher 
{

	public static void main(String[] args) {
		//testng testsuite preparation
		XmlSuite suite = new XmlSuite();
		suite.setName("Regression TestSuite");
		XmlTest test = new XmlTest(suite);
		test.setName("TestCases");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.thrymr.testscripts.RegressionTestCases"));
		test.setXmlClasses(classes);
		
		//set of testsuites to be run
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}
}


