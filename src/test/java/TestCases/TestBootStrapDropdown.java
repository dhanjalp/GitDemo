package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBootStrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='menu1']")).click();

		List<WebElement> values = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
//		
//		for (int i=0; i<values.size();i++) {
//			
//			WebElement ele = values.get(i);
//			
//			String innerhtml = ele.getAttribute("innerHTML");
//			
//			if(innerhtml.contentEquals("JavaScript")) {
//				
//				ele.click();
//				break;
//			}
//		System.out.println("Values from dropdown are------> " + innerhtml);

//		}

		for (WebElement val : values) {

			String innrhtml = val.getAttribute("innerHTML");

			if (innrhtml.contentEquals("JavaScript")) {

				val.click();
				break;
			}

			System.out.println("Values from dropdown are------> " + innrhtml);
		}

		driver.quit();

	}

}
