package com.ScreenShot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScreenShot {
static Logger log;
static WebDriver driver;
	@Parameters({"email", "password"})
	@Test
	public void rthree_Login(String email, String password) throws AWTException, IOException, InterruptedException {
		log = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		driver.get("https://www.rthree.live");
		log.info("URL opened in the browser");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		log.info("Login Succeed");
		
		WebElement sideBar = driver.findElement(By.cssSelector("div#sidebar_body"));

		Point location = sideBar.getLocation();
		int width = sideBar.getSize().getWidth();
		int height = sideBar.getSize().getHeight();
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File screenshotAs = screen.getScreenshotAs(OutputType.FILE);
		
		BufferedImage image = ImageIO.read(screenshotAs);
		
		BufferedImage des = image.getSubimage(location.getX(), location.getY(), width, height);
		
		ImageIO.write(des, "png", screenshotAs);
		
		File file = new File("D:\\Work\\Automation\\Eclipse\\RSoft_Automation\\LetsGo\\Screenshot\\sideBarDivision.png");
		
		FileHandler.copy(screenshotAs, file);
		
	}
	
	@AfterSuite
	private void browserQuit() {
		driver.quit();

	}
}
