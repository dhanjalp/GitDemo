package TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsnPopUps {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://v1.hdfcbank.com/assets/popuppages/netbanking.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("---------Generating window ids from FIRST window----------");
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator();
		String first_window = iterate.next();
		System.out.println(first_window);
		
		
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[4]/div/a")).click();
		driver.findElement(By.xpath("//a[@href='/personal/ways-to-bank/bank-online/netbanking?accordname=accordian6']")).click();
		
		
		
		//2nd window
		
		System.out.println("---------Generating window ids from SECOND window----------");
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		
		System.out.println(iterate.next());
		String second_window = iterate.next();
		System.out.println(second_window);
				
		driver.switchTo().window(second_window);
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().contains("NetBanking, Internet Banking, Online Banking, E-banking India "));
		
		//driver.close(); //current focused window will close only i.e.2nd window
		//driver.switchTo().window(first_window);// the step used if we are on 10th window and we need to close the 4th window,since we will be storing the window id
		//driver.close(); //we can use this the above driver.switchTo the window we want to close.
		
		driver.quit(); // if we want to close all the windows in one go in the current session
		
		
		
		

	}

}
