package TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSortOrderDropdown {

	@Test
	public void testcase1() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select select = new Select(driver.findElement(By.id("tools")));
		Select select = new Select(driver.findElement(By.id("tools1")));

		List actuallist = new ArrayList();

		List<WebElement> values = select.getOptions();

		for (WebElement ele : values) {
			String data = ele.getText();
			actuallist.add(data);
		}

		List temp = new ArrayList();

		temp.addAll(actuallist);

		// Ascending -----------******Collections is a class , where as Collection is an Interface.
		Collections.sort(temp);
		
		//Collections.sort(temp, Collections.reverseOrder());// to sort the list in the reverse order i.e. descending, we
															// need to pass the collections.reverseOrder as an argument

		
		Assert.assertTrue(actuallist.equals(temp));

	}

}
