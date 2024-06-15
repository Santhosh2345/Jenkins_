package com.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Right {
		static Logger log = LogManager.getLogger(Right.class);
		
		@Test
		public void he() {
			
			System.out.println("Hello");
			log.info("Info");
			log.debug("Debug");
			log.error("Error");
			log.fatal("Fatal");
			log.trace("trace");
			log.warn("Warning");
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.salezcrm.com/login/public");
			driver.manage().window().maximize();
			driver.close();
		}
}
