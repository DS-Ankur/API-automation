package soapui_e2e;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.support.SoapUIException;



public class TestRunner {
	@Test
	public void soapui() throws XmlException, IOException, SoapUIException{
		// TODO Auto-generated method stub
//grab the project
		//WsdlProject project = new WsdlProject("C:/Users/Rana/Desktop/Test Automation/Test NG RS code/API testing/E2E framework/Libraray e2e.xml");
		
		WsdlProject project = new WsdlProject(System.getProperty("SOAPUI_Project/Libraray e2e.xml"));
		
		//grab the TestSuites
		for (int j = 0; j<project.getTestSuiteCount();j++)
			
		//grab particular testsuite
		{
			WsdlTestSuite testSuite = project.getTestSuiteAt(j);
		
		//grab and run the testcase
		for (int i = 0;i<testSuite.getTestCaseCount();i++)
			{WsdlTestCase testCase = testSuite.getTestCaseAt(i);
			WsdlTestCaseRunner runner = testCase.run(new PropertiesMap(),false);//this Propertymap is used if we take properties 
				//from java project and not soap project, may be thats y we use false argument
			Assert.assertEquals(Status.FINISHED.toString(),runner.getStatus().toString());//comapring 2 statuses status, soap ui and runner
				
			}
		}
	}

}
