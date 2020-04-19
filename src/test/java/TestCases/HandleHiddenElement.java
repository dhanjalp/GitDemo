package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleHiddenElement {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//input[@id='male']")).click(); ** as it returns
		// 2 records with xpath and insuch case it will try to select the first one, and
		// the first element is hidden, hence will overcome by findelements()

		List<WebElement> radio = driver.findElements(By.xpath("//input[@id='male']"));

		int count = radio.size();

		for (int i = 0; i < count; i++) {
			
			WebElement ele = radio.get(i);
			
			int x = ele.getLocation().getX();
			
			if(x!=0) {
				
				ele.click();
				break;
			}

		}

	}

}
