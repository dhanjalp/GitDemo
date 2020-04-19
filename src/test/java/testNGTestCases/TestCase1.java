package testNGTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase1 {

	@Test(groups="smoke")
	public void getTitle() {

		String expected_title = "Yahoo.com"; // Req doc
		String actual_title = "Gmail.com"; // Selenium

		
		SoftAssert softAssert = new SoftAssert();
		
		// Assert.assertEquals(actual_title, expected_title);
		// isElementPresent("xpath") - True, False
		// Assert.assertTrue(false, "Element Not Found");

		softAssert.fail("Failing the test as the condition is not met");
		// Forcefully failing the test case by above line.
		
		System.out.println("==========Test Case DONE===========");
		
		softAssert.assertAll();  
	}
}
