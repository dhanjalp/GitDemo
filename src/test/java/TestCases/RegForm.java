package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegForm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).sendKeys("Sunny");
		
		//WebDriverWait wait= new WebDriverWait(driver,20);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='button'])[1]"))).click();

		driver.findElement(By.xpath("(//*[@value='Submit'])[2]")).click();
		
		//driver.findElement(By.className("button")).click();
		
				
	}

}
