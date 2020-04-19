package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
	    
	    Thread.sleep(5000);
 
	    //Alert alert = driver.switchTo().alert();
	    //System.out.println(alert.getText());
	    //alert.accept();
	    
	    //****Alerts can be either handled by the above way or by using the Explicit WAIT
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert= wait.until(ExpectedConditions.alertIsPresent());
	    
	    System.out.println(alert.getText());
	    alert.accept();
		
		
		
		

	}

}
