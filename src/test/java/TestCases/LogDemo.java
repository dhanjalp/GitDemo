package TestCases;

import java.lang.module.Configuration;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Property;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class LogDemo {

	public static void main(String[] args) {

		Logger logger=Logger.getLogger("LogDemo");
		
		PropertyConfigurator.configure("log4j.properties");
		
		Date d= new Date();
		System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		
		logger.info("browser launched");
		logger.error("here the error loges will be printed");
				
				
		
		

	}

}
