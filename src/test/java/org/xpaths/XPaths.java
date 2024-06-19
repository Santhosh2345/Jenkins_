package org.xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class XPaths {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Using property file to get credentials
        Properties prop = new Properties();
        FileReader read = new FileReader("src/main/resources/rthreeLogin.properties");
        prop.load(read);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rthree.live"); //Testing Source

        //Attribute xpath
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(prop.getProperty("email"));

        //Multiple Attribute xpath
        WebElement password = driver.findElement(By.xpath("//input[@type='password'][@id='password']"));
        password.sendKeys(prop.getProperty("password"));

        //Conditional xpath (and, or)
        WebElement send = driver.findElement(By.xpath("//button[@type='submit' or text()='SIGN IN']"));
        send.click();

        Thread.sleep(1500);

        //Contains xpath (and, or)
        WebElement page = driver.findElement(By.xpath("//label[contains(@id,'second-lbl')]"));
        prop.setProperty("Landing Page", page.getText());

        //Starts-with xpath
        List<WebElement> noOfIcons = driver.findElements(By.xpath("//i[starts-with(@class,'material-icons')]"));
        prop.setProperty("Number of material icons", String.valueOf(noOfIcons.size()));

        /*FOS is needed to write and store the property file*/
        FileOutputStream fos = new FileOutputStream("src/main/resources/rthreeLogin.properties");
        prop.store(fos, "Update properties");

        //Last element xpath
        WebElement last = driver.findElement(By.xpath("(//i[starts-with(@class,'material-icons')])[last()]"));
        System.out.println("Last icon founded" + last);

        //Position xpath
        WebElement position = driver.findElement(By.xpath("(//i[starts-with(@class,'material-icons')])[position()=5]"));
        System.out.println("5th position icon found" + position);

        //Text xpath
        WebElement messageUI = driver.findElement(By.xpath("//button[text()='Message']"));
        System.out.println("Message UI found using Text" + messageUI);

        //Text xpath using contains and .
        WebElement question = driver.findElement(By.xpath("//label[contains(.,'Pub')]"));
        boolean displayed = question.isDisplayed();
        System.out.println("Publish element found using Text with contains and dot: " + displayed);

        //Normalize text xpath
        WebElement addBuild = driver.findElement(By.xpath("//label[text()[normalize-space()='Add build']]"));
        Point location = addBuild.getLocation();
        System.out.println("Add Build location" + location.toString());

        //Parent xpath
        WebElement layerIconLink = driver.findElement(By.xpath("//i[.='layers']//parent::a"));
        System.out.println("Parent tag of element is: " + layerIconLink.getTagName());

        //Ancestor xpath
        WebElement layerIconList = driver.findElement(By.xpath("//i[.='layers']//ancestor::li"));
        System.out.println("Ancestor tag of element is: " + layerIconList.getTagName());

        //Child xpath
        WebElement layerIcon = driver.findElement(By.xpath("//a//child::i[.='layers']"));
        System.out.println("Child tag of element is: " + layerIcon.getTagName());

        //Following xpath
        List<WebElement> iconTexts = driver.findElements(By.xpath("//a//following::span"));
        System.out.println("Following xpath - Number of Icons Text: " + iconTexts.size());

        //Following Siblings xpath
        WebElement icon = driver.findElement(By.xpath("//i[.='layers']//following-sibling::span"));
        System.out.println("Following sibling xpath - Icon Label is: " + icon.getText());

        //Preceding xpath
        WebElement iconName = driver.findElement(By.xpath("//span[.='Chat Design']//preceding::i[1]"));
        System.out.println("Preceding xpath - Icon name is: " + iconName.getText());

        //Preceding xpath
        WebElement iconName2 = driver.findElement(By.xpath("//span[.='Chat Design']//preceding-sibling::i"));
        System.out.println("Preceding xpath - Icon2 name is: " + iconName2.getText());

        //Finding svg tag
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        System.out.println("Number of svg tab in DOM:" + svgElements.size());

        //Wildcards xpath
        //One is --> //*[@class='script-ui-btn draggable']
        //Another is --> //button[@*='script-ui-btn draggable']
        List<WebElement> uis = driver.findElements(By.xpath("//button[@*='script-ui-btn draggable']"));
        System.out.println("Number of UI types:" + uis.size());
    }
}
