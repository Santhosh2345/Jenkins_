package com.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RunRun {
	
	
	public static void main(String[] args) throws InterruptedException {
		RunRun a = new RunRun();                                                     
		a.main2();
	}

	@Test
 public void main2() throws InterruptedException {
		
		Logger log = LogManager.getLogger(this.getClass());
		
		System.out.println("Hello-1");
		log.info("Info-1");
		log.debug("Debug-1");
		log.error("Error-1");
		log.fatal("Fatal-1");
		log.trace("trace-1");
		log.warn("Warning-1");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		driver.quit();
	}
}
