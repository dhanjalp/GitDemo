package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData") // ****Parameterization with multiple data sets by running tests with multiple
									// combinations and it can be achieved by data provider annotation which is
									// independent of testng.xml file and is specific to a test case **

	public void doLogin(String un, String pswd) {

		System.out.println(un + "------" + pswd);

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "abc@gmail.com";
		data[0][1] = "sdfd";

		data[1][0] = "java@gmail.com";
		data[1][1] = "java234";

		data[2][0] = "sel@gmail.com";
		data[2][1] = "selfd";

		return data;

	}
}
