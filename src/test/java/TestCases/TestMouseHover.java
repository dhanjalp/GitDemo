package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestMouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement sbox = driver.findElement(By.name("q"));
		sbox.sendKeys("way2automation.com");
		sbox.sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		
		WebElement value= driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[8]/a"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(value).perform();
		
		driver.findElement(By.linkText("Practice site 1")).click();
		
	}

}
