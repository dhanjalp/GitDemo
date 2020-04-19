package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// **dropdown list can be created using 1. select tag-option value and 2. input

		// driver.findElement(By.id("searchLanguage")).sendKeys("Dansk");
		// driver.findElement(By.id("searchLanguage")).sendKeys("Eesti"); //bt its
		// selecting ESPANol instead

		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		 
		Select select = new Select(dropdown);
		
		//It shld return default value
		WebElement defaultvalue = select.getFirstSelectedOption();
		System.out.println("Default dropdown value "+ defaultvalue.getText());
		// select.selectByVisibleText("Eesti") or select.selectByValue("et"); or selectByIndex
		
		//select.selectByValue("hi");
		select.selectByVisibleText("Eesti");
		
		Thread.sleep(5000);
		
		//After selecting a particular dropdown value
		WebElement afterselection = select.getFirstSelectedOption();
		System.out.println("After selecting validating the dropdown value "+ afterselection.getText());
		
		//Count the no of dropdown values and printing their texts.
		
		//List<WebElement> values = driver.findElements(By.tagName("option")); 
		List<WebElement> values= select.getOptions();
		
		int noofdropdownvalues = values.size();
		
		Assert.assertEquals(noofdropdownvalues, 66);
		
		System.out.println("Total Values are"+ noofdropdownvalues);
		
		System.out.println(values.get(7).getText());
		
		for (int i = 0;i<values.size();i++) {
			
			//System.out.println(values.get(i).getText());
			
			System.out.println(values.get(i).getAttribute("value"));
		}
		
		
		System.out.println("-----Printing all Links ------");
		
		
		//Print the links within a block and not from the entire page : Take the xpath of the block and pass that in the below line instead of drivers.
		WebElement block= driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		List<WebElement> lists = block.findElements(By.tagName("a"));
		
		
		//List<WebElement> lists = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links"+ lists.size());
		
		for(WebElement list:lists) {
			
			System.out.println(list.getText()+ "-----URL is -----" + list.getAttribute("href"));
		}

	}

}
