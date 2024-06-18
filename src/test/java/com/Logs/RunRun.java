package com.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "https://www.rthree.live");
		map.put(2, "https://www.salezrobot.com");

		driver.get(map.get(2));
		Thread.sleep(3000);
		driver.quit();

		//2d array
		int[][] num = new int[1][2];
		num[0][0] = 1;
		num[0][1] = 2;

		Integer a = num[0][1];
		System.out.println(a);
	}
}