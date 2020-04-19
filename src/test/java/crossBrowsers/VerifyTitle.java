package crossBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {

	// public static String browser = "chrome"; // excel
	public static WebDriver driver;

	@Test
	@Parameters({ "browser", "APIKey" }) // ***Global environment variables can be incorporated, such as URL, APIKey,
											// UN, PSWD**
	
	public void verifypageTitle(String browserName, String Key) throws InterruptedException {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(Key);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(Key);

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Thread.sleep(10000);
			System.out.println(Key);
		}

		driver.manage().window().maximize();
		driver.get("https:www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}
}
