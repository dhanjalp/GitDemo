package TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("---------Generating PARENT window ID from FIRST window----------");

		String parent = driver.getWindowHandle();
		System.out.println("Parent window ID is " + parent);

		// driver.findElement(By.xpath());

		System.out.println("---------Generating window ID's from FIRST window----------");

		Set<String> windids = driver.getWindowHandles();

		/*
		 * ArrayList<String> tabs = new ArrayList<String>(windids);
		 * 
		 * driver.switchTo().window(tabs.get(1));
		 * 
		 * driver.close();
		 * 
		 * driver.switchTo().window(tabs.get(0));
		 * 
		 * driver.close();
		 */

		int count = windids.size();

		System.out.println("Total window id's are " + count);

		for (String child : windids) {

			if (!parent.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);

				System.out.println("Child Window id is " + child);

				System.out.println("CHILD Window Title is " + driver.getTitle());

				Thread.sleep(3000);

				//driver.close();

			}
		}

		driver.switchTo().window(parent);

		driver.getTitle();
		
		//driver.close();

	}

}

/*
 * Set<String> winids = driver.getWindowHandles();
 * 
 * Iterator<String> itr = winids.iterator();
 * 
 * while(itr.hasNext()) {
 * 
 * String child = itr.next();
 * 
 * if (!parent.equalsIgnoreCase(child)) {
 * 
 * driver.switchTo().window(child);
 * 
 * System.out.println("Child Window id is " + child);
 * 
 * System.out.println("CHILD Window Title is " + driver.getTitle());
 * 
 * Thread.sleep(3000);
 * 
 * driver.close(); }
 * 
 * }
 * 
 * driver.switchTo().window(parent);
 * 
 * driver.getTitle();
 */