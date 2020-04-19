package testNGTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase3 {

	@Test(priority = 1, groups= {"smoke", "functional"}, description = "This test case is to register user in their system")
	public void doUserReg() {

		System.out.println("Executing User registering successfully");
		Assert.fail("Unable to Register user successfully");

	}

	@Test(priority = 2, dependsOnMethods = "doUserReg", groups= {"smoke", "functional"} )
	public void doUserLogin() {

		System.out.println("Executing User login successfully");
	}

	@Test(priority = 3, dependsOnMethods = {"doUserReg", "fourthTest"}, alwaysRun = true, groups= {"smoke", "functional"})
	public void thirdTest() {
		
		System.out.println("Executing 3rd Test");
	}

	@Test(priority = 4, groups= {"smoke", "functional"})
	public void fourthTest() {
		
		System.out.println("Executing 4th Test");
	}
}
