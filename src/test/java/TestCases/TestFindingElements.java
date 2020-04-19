package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	public static String browser = "chrome"; // excel
	public static WebDriver driver;

	public static void main(String[] args) {

		System.out.println("HI");

	//	System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		
		driver.get("https:www.google.com");
		driver.manage().window().maximize();
		System.out.println("Bye");
//		driver.get("https://www.makemytrip.com/");
//	
	}

	private static void If(boolean equals) {
		// TODO Auto-generated method stub
		
	}

}
