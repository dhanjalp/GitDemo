package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestVerifyTitle {

	@Test
	public void testcase1() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// String actual_title = driver.getTitle(); //****** We can get title of page
		// either by getTitle OR getPageSource method.****
		// System.out.println(actual_title);

		// String expected = "Facebook - Log In or Sign Up";   

		// Assert.assertEquals(actual_title, expected);

		// Assert.assertTrue(actual_title.contains("Facebook - Log In"));

		String actual_title = driver.getPageSource();
		boolean istextpresent = actual_title.contains("Facebook - Log In");

		System.out.println(istextpresent);
		Assert.assertTrue(istextpresent);

		// ****Similarly To Verify ERROR MESSAGES in Selenium,  we can do by 2 WAYS:
		// 1. getText() - we can capture text and it will return text in String format
		// 2. getAttribute("innnerHTML") - we can capture inner HTML which will return
		// the inner text and will return String message.
		
		
	}

}
