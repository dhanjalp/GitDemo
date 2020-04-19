package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRadioAndCheckbox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> localradio = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

		//
		for (int i = 0; i < localradio.size(); i++) {

			WebElement value = localradio.get(i);
			String s = value.getAttribute("value");
			System.out.println("Values from radiobutton are " + s);
			
			if(s.equalsIgnoreCase("Python")) {
				
				value.click();
			}

		}

		List<WebElement> localcheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0; i< localcheckbox.size(); i++) {
			
			WebElement value = localcheckbox.get(i);
			String s = value.getAttribute("id");
			System.out.println("Values from checkboxes are " + s);
			
			if(s.equalsIgnoreCase("code")) {
				
				value.click();
				break;
			}
		}
	}

}
