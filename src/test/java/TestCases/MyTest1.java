package TestCases;

import org.testng.annotations.Test;
import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyTest1 {
	@Test
	public void myTest() {

		int a = 90;
		int b = 90;

		Assert.assertEquals(a, b);

		System.out.println("=========Test Done==========");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws EmailException {

		if (result.getStatus() == ITestResult.FAILURE) {
			SendEmailJava.SendEmail();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("=========Starting the Test ==========");
	}

}
