package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframes {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//" + fileName));
	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		Set<String> winids = driver.getWindowHandles();
//		Iterator<String> iterate = winids.iterator();
//		String first_window = iterate.next();

		// driver.switchTo().frame("iframeResult");//**Switch to frame by using frame id
		// or frame name
		// How to switch without knowing frame id or name ? Answer: By index or best way
		// is WebElement.

		// driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		// driver.findElement(By.xpath("/html/body/button")).click();//**instead of this
		// JSExecutor is an Interface which will allow us to execute java script from
		// selenium script.
		// we can use the javascript executor i.e. we can call JS of thebrowser or can
		// inject our own JS as shown in next line, JS runs on client machine.

		// ((JavascriptExecutor) driver).executeScript("myFunction()");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));

		driver.switchTo().defaultContent();// defaultContent() method selects either the first frame on the page, or the
											// main document when a page contains iframes.
		// ****Frame is an area/section of a webpage, by using frame u can split ur
		// webpage
		// into different parts
		// where as*** IFrame is a web page which is embedded in another web page i.e.
		// to
		// show information frm another website.

		// driver.switchTo().window(first_window);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total no of frames in a page " + frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));
		}

		captureScreenshot();

	}

}
