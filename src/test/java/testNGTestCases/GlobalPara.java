package testNGTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalPara {

	public static WebDriver driver;

	@Test
	public void doLogin() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\prabh\\eclipse-workspaceNew\\SeleniumTesting\\src\\test\\java\\testNGTestCases\\datadriven.properties");
		prop.load(fis);

		System.out.println(prop.getProperty("URL"));
		if ((prop.getProperty("browser")).equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		} else if ((prop.getProperty("browser")).equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(prop.getProperty("URL"));
		System.out.println(driver.getTitle());

	}

}
