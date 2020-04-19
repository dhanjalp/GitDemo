package TestCases;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalendars {

	static int targetDay = 0, targetMonth = 0, targetYear = 0;

	static int currentDay = 0, currentMonth = 0, currentYear = 0;

	static int jumpMonthsBy = 0;

	static boolean increment = true;

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		//get current date 
		getCurrentDayMonthAndYear();
		System.out.println(currentDay + "  " + currentMonth + "  " + currentYear);
		
		//get target date 
		String tgtDate = "07/06/2020";
		getTargetDayMonthAndYear(tgtDate);
		System.out.println(targetDay + "  " + targetMonth + "  " + targetYear);
		
		//get Jump Month
		howManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:qa.way2automation.com/datepicker/defult1.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}

	public static void getCurrentDayMonthAndYear() {

		Calendar cal = Calendar.getInstance();

		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1; // Georgian calendar is one month behind, hence +1
		currentYear = cal.get(Calendar.YEAR);

	}

	public static void getTargetDayMonthAndYear(String dateString) {

		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);

	}

	public static void howManyMonthsToJump() {

		if ((targetMonth - currentMonth) > 0) {

			jumpMonthsBy = (targetMonth - currentMonth);
			
		} else {
			
			jumpMonthsBy = (currentMonth - targetMonth);
			increment = false;

		}

	}

}
