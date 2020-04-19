package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleUntrustedCertificates {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver = new ChromeDriver(cap);

		driver.get("https://www.cacert.org/");

	}

}
