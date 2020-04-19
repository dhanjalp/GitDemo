package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParticularViewScroll {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scroll into View ---->It will scroll until element is not visible or in view.
		
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_3_container\"]/p[3]"));
		
		//now execute query which actually will scroll until that element is not appeared on page.
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		//Extract the text and verify
		System.out.println(element.getText());
		
	}

}
