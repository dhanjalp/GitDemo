package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class UploadFileAutoIT {

	public static void Testcase() throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.get("file:///D:/Softwares/resumeupload.html");
		
		driver.findElement(By.xpath("//*[@id='1']")).click();
		
		Thread.sleep(10000);
		
		Runtime.getRuntime().exec("D:\\AutoIT\\fileupload.exe");
	}

}
