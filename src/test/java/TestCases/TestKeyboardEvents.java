package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboardEvents {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		// email.sendKeys(Keys.ENTER); OR

		Actions action = new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/span/div/div")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL + "a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL + "c")).perform();
		
		//action.sendKeys(Keys.chord(Keys.CONTROL + "a")).sendKeys(Keys.chord(Keys.CONTROL + "c")).build().perform();
		//build().perform(); is used for composite actions

		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL + "v")).perform();

	}

}
