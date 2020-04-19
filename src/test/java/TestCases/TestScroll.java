package TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.canada.ca/en/employment-social-development/corporate/notices/coronavirus.html");
			
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		
		js.executeScript("scroll(0, 500);");
		
		//scroll(Horizontal, vertical);
		
	}

}
