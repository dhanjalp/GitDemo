package testNGTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

	@Test(groups="functional")
	public void getTitle() {

		String expected_title = "Yahoo.com"; // Req doc
		String actual_title = "Gmail.com"; // Selenium

		/*
		 * if (expected_title.equals(actual_title)) {
		 * 
		 * System.out.println("Test case PASSED"); } else {
		 * 
		 * System.out.println("Test case Failed");
		 * 
		 * } //******With IF -Else u can never report a trigger**, in this case it will
		 * print msg TestCase Failed but TC will PASS.
		 */

		// Assert.assertEquals(actual_title, expected_title);
		// isElementPresent("xpath") - True, False
		// Assert.assertTrue(false, "Element Not Found");

		Assert.fail("Failing the test as the condition is not met");
		// Forcefully failing the test case by above line.
		
		System.out.println("==========Test Case DONE===========");
	}
}
